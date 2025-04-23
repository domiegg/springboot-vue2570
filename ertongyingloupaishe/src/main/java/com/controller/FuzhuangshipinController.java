
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
 * 服装饰品
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fuzhuangshipin")
public class FuzhuangshipinController {
    private static final Logger logger = LoggerFactory.getLogger(FuzhuangshipinController.class);

    @Autowired
    private FuzhuangshipinService fuzhuangshipinService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ZhiyuanService zhiyuanService;


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
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = fuzhuangshipinService.queryPage(params);

        //字典表数据转换
        List<FuzhuangshipinView> list =(List<FuzhuangshipinView>)page.getList();
        for(FuzhuangshipinView c:list){
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
        FuzhuangshipinEntity fuzhuangshipin = fuzhuangshipinService.selectById(id);
        if(fuzhuangshipin !=null){
            //entity转view
            FuzhuangshipinView view = new FuzhuangshipinView();
            BeanUtils.copyProperties( fuzhuangshipin , view );//把实体数据重构到view中

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
    public R save(@RequestBody FuzhuangshipinEntity fuzhuangshipin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fuzhuangshipin:{}",this.getClass().getName(),fuzhuangshipin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<FuzhuangshipinEntity> queryWrapper = new EntityWrapper<FuzhuangshipinEntity>()
            .eq("fuzhuangshipin_uuid_number", fuzhuangshipin.getFuzhuangshipinUuidNumber())
            .eq("fuzhuangshipin_name", fuzhuangshipin.getFuzhuangshipinName())
            .eq("fuzhuangshipin_types", fuzhuangshipin.getFuzhuangshipinTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FuzhuangshipinEntity fuzhuangshipinEntity = fuzhuangshipinService.selectOne(queryWrapper);
        if(fuzhuangshipinEntity==null){
            fuzhuangshipin.setCreateTime(new Date());
            fuzhuangshipinService.insert(fuzhuangshipin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FuzhuangshipinEntity fuzhuangshipin, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fuzhuangshipin:{}",this.getClass().getName(),fuzhuangshipin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<FuzhuangshipinEntity> queryWrapper = new EntityWrapper<FuzhuangshipinEntity>()
            .notIn("id",fuzhuangshipin.getId())
            .andNew()
            .eq("fuzhuangshipin_uuid_number", fuzhuangshipin.getFuzhuangshipinUuidNumber())
            .eq("fuzhuangshipin_name", fuzhuangshipin.getFuzhuangshipinName())
            .eq("fuzhuangshipin_types", fuzhuangshipin.getFuzhuangshipinTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FuzhuangshipinEntity fuzhuangshipinEntity = fuzhuangshipinService.selectOne(queryWrapper);
        if("".equals(fuzhuangshipin.getFuzhuangshipinPhoto()) || "null".equals(fuzhuangshipin.getFuzhuangshipinPhoto())){
                fuzhuangshipin.setFuzhuangshipinPhoto(null);
        }
        if(fuzhuangshipinEntity==null){
            fuzhuangshipinService.updateById(fuzhuangshipin);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        fuzhuangshipinService.deleteBatchIds(Arrays.asList(ids));
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
            List<FuzhuangshipinEntity> fuzhuangshipinList = new ArrayList<>();//上传的东西
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
                            FuzhuangshipinEntity fuzhuangshipinEntity = new FuzhuangshipinEntity();
//                            fuzhuangshipinEntity.setFuzhuangshipinUuidNumber(data.get(0));                    //服装编号 要改的
//                            fuzhuangshipinEntity.setFuzhuangshipinName(data.get(0));                    //服装名称 要改的
//                            fuzhuangshipinEntity.setFuzhuangshipinPhoto("");//详情和图片
//                            fuzhuangshipinEntity.setFuzhuangshipinTypes(Integer.valueOf(data.get(0)));   //服装类型 要改的
//                            fuzhuangshipinEntity.setFuzhuangshipinNewMoney(data.get(0));                    //现价 要改的
//                            fuzhuangshipinEntity.setFuzhuangshipinContent("");//详情和图片
//                            fuzhuangshipinEntity.setCreateTime(date);//时间
                            fuzhuangshipinList.add(fuzhuangshipinEntity);


                            //把要查询是否重复的字段放入map中
                                //服装编号
                                if(seachFields.containsKey("fuzhuangshipinUuidNumber")){
                                    List<String> fuzhuangshipinUuidNumber = seachFields.get("fuzhuangshipinUuidNumber");
                                    fuzhuangshipinUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> fuzhuangshipinUuidNumber = new ArrayList<>();
                                    fuzhuangshipinUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("fuzhuangshipinUuidNumber",fuzhuangshipinUuidNumber);
                                }
                        }

                        //查询是否重复
                         //服装编号
                        List<FuzhuangshipinEntity> fuzhuangshipinEntities_fuzhuangshipinUuidNumber = fuzhuangshipinService.selectList(new EntityWrapper<FuzhuangshipinEntity>().in("fuzhuangshipin_uuid_number", seachFields.get("fuzhuangshipinUuidNumber")));
                        if(fuzhuangshipinEntities_fuzhuangshipinUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FuzhuangshipinEntity s:fuzhuangshipinEntities_fuzhuangshipinUuidNumber){
                                repeatFields.add(s.getFuzhuangshipinUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [服装编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fuzhuangshipinService.insertBatch(fuzhuangshipinList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
