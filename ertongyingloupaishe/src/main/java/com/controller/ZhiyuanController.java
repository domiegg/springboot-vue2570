
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 职员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhiyuan")
public class ZhiyuanController {
    private static final Logger logger = LoggerFactory.getLogger(ZhiyuanController.class);

    @Autowired
    private ZhiyuanService zhiyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("顾客".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("职员".equals(role))
            params.put("zhiyuanId",request.getSession().getAttribute("userId"));
        params.put("zhiyuanDeleteStart",1);params.put("zhiyuanDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = zhiyuanService.queryPage(params);

        //字典表数据转换
        List<ZhiyuanView> list =(List<ZhiyuanView>)page.getList();
        for(ZhiyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhiyuanEntity zhiyuan = zhiyuanService.selectById(id);
        if(zhiyuan !=null){
            //entity转view
            ZhiyuanView view = new ZhiyuanView();
            BeanUtils.copyProperties( zhiyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiyuanEntity zhiyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhiyuan:{}",this.getClass().getName(),zhiyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhiyuanEntity> queryWrapper = new EntityWrapper<ZhiyuanEntity>()
            .eq("username", zhiyuan.getUsername())
            .or()
            .eq("zhiyuan_phone", zhiyuan.getZhiyuanPhone())
            .or()
            .eq("zhiyuan_id_number", zhiyuan.getZhiyuanIdNumber())
            .andNew()
            .eq("zhiyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhiyuanEntity zhiyuanEntity = zhiyuanService.selectOne(queryWrapper);
        if(zhiyuanEntity==null){
            zhiyuan.setZhiyuanDelete(1);
            zhiyuan.setCreateTime(new Date());
            zhiyuan.setPassword("123456");
            zhiyuanService.insert(zhiyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式或者身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhiyuanEntity zhiyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhiyuan:{}",this.getClass().getName(),zhiyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ZhiyuanEntity> queryWrapper = new EntityWrapper<ZhiyuanEntity>()
            .notIn("id",zhiyuan.getId())
            .andNew()
            .eq("username", zhiyuan.getUsername())
            .or()
            .eq("zhiyuan_phone", zhiyuan.getZhiyuanPhone())
            .or()
            .eq("zhiyuan_id_number", zhiyuan.getZhiyuanIdNumber())
            .andNew()
            .eq("zhiyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhiyuanEntity zhiyuanEntity = zhiyuanService.selectOne(queryWrapper);
        if("".equals(zhiyuan.getZhiyuanPhoto()) || "null".equals(zhiyuan.getZhiyuanPhoto())){
                zhiyuan.setZhiyuanPhoto(null);
        }
        if(zhiyuanEntity==null){
            zhiyuanService.updateById(zhiyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式或者身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<ZhiyuanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ZhiyuanEntity zhiyuanEntity = new ZhiyuanEntity();
            zhiyuanEntity.setId(id);
            zhiyuanEntity.setZhiyuanDelete(2);
            list.add(zhiyuanEntity);
        }
        if(list != null && list.size() >0){
            zhiyuanService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ZhiyuanEntity> zhiyuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZhiyuanEntity zhiyuanEntity = new ZhiyuanEntity();
//                            zhiyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //zhiyuanEntity.setPassword("123456");//密码
//                            zhiyuanEntity.setZhiyuanName(data.get(0));                    //职员姓名 要改的
//                            zhiyuanEntity.setZhiyuanPhoto("");//详情和图片
//                            zhiyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            zhiyuanEntity.setZhiyuanPhone(data.get(0));                    //联系方式 要改的
//                            zhiyuanEntity.setZhiyuanIdNumber(data.get(0));                    //身份证号 要改的
//                            zhiyuanEntity.setZhiyuanEmail(data.get(0));                    //邮箱 要改的
//                            zhiyuanEntity.setZhiyuanDelete(1);//逻辑删除字段
//                            zhiyuanEntity.setCreateTime(date);//时间
                            zhiyuanList.add(zhiyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //联系方式
                                if(seachFields.containsKey("zhiyuanPhone")){
                                    List<String> zhiyuanPhone = seachFields.get("zhiyuanPhone");
                                    zhiyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> zhiyuanPhone = new ArrayList<>();
                                    zhiyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("zhiyuanPhone",zhiyuanPhone);
                                }
                                //身份证号
                                if(seachFields.containsKey("zhiyuanIdNumber")){
                                    List<String> zhiyuanIdNumber = seachFields.get("zhiyuanIdNumber");
                                    zhiyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhiyuanIdNumber = new ArrayList<>();
                                    zhiyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("zhiyuanIdNumber",zhiyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<ZhiyuanEntity> zhiyuanEntities_username = zhiyuanService.selectList(new EntityWrapper<ZhiyuanEntity>().in("username", seachFields.get("username")).eq("zhiyuan_delete", 1));
                        if(zhiyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhiyuanEntity s:zhiyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<ZhiyuanEntity> zhiyuanEntities_zhiyuanPhone = zhiyuanService.selectList(new EntityWrapper<ZhiyuanEntity>().in("zhiyuan_phone", seachFields.get("zhiyuanPhone")).eq("zhiyuan_delete", 1));
                        if(zhiyuanEntities_zhiyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhiyuanEntity s:zhiyuanEntities_zhiyuanPhone){
                                repeatFields.add(s.getZhiyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //身份证号
                        List<ZhiyuanEntity> zhiyuanEntities_zhiyuanIdNumber = zhiyuanService.selectList(new EntityWrapper<ZhiyuanEntity>().in("zhiyuan_id_number", seachFields.get("zhiyuanIdNumber")).eq("zhiyuan_delete", 1));
                        if(zhiyuanEntities_zhiyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhiyuanEntity s:zhiyuanEntities_zhiyuanIdNumber){
                                repeatFields.add(s.getZhiyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhiyuanService.insertBatch(zhiyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ZhiyuanEntity zhiyuan = zhiyuanService.selectOne(new EntityWrapper<ZhiyuanEntity>().eq("username", username));
        if(zhiyuan==null || !zhiyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(zhiyuan.getZhiyuanDelete() != 1)
            return R.error("账户已被删除");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(zhiyuan.getId(),username, "zhiyuan", "职员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","职员");
        r.put("username",zhiyuan.getZhiyuanName());
        r.put("tableName","zhiyuan");
        r.put("userId",zhiyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ZhiyuanEntity zhiyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<ZhiyuanEntity> queryWrapper = new EntityWrapper<ZhiyuanEntity>()
            .eq("username", zhiyuan.getUsername())
            .or()
            .eq("zhiyuan_phone", zhiyuan.getZhiyuanPhone())
            .or()
            .eq("zhiyuan_id_number", zhiyuan.getZhiyuanIdNumber())
            .andNew()
            .eq("zhiyuan_delete", 1)
            ;
        ZhiyuanEntity zhiyuanEntity = zhiyuanService.selectOne(queryWrapper);
        if(zhiyuanEntity != null)
            return R.error("账户或者联系方式或者身份证号已经被使用");
        zhiyuan.setZhiyuanDelete(1);
        zhiyuan.setCreateTime(new Date());
        zhiyuanService.insert(zhiyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        ZhiyuanEntity zhiyuan = new ZhiyuanEntity();
        zhiyuan.setPassword("123456");
        zhiyuan.setId(id);
        zhiyuanService.updateById(zhiyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ZhiyuanEntity zhiyuan = zhiyuanService.selectOne(new EntityWrapper<ZhiyuanEntity>().eq("username", username));
        if(zhiyuan!=null){
            zhiyuan.setPassword("123456");
            boolean b = zhiyuanService.updateById(zhiyuan);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrZhiyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ZhiyuanEntity zhiyuan = zhiyuanService.selectById(id);
        if(zhiyuan !=null){
            //entity转view
            ZhiyuanView view = new ZhiyuanView();
            BeanUtils.copyProperties( zhiyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
