package com.entity.model;

import com.entity.ZhiyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 职员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhiyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 职员姓名
     */
    private String zhiyuanName;


    /**
     * 头像
     */
    private String zhiyuanPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 联系方式
     */
    private String zhiyuanPhone;


    /**
     * 身份证号
     */
    private String zhiyuanIdNumber;


    /**
     * 邮箱
     */
    private String zhiyuanEmail;


    /**
     * 假删
     */
    private Integer zhiyuanDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：职员姓名
	 */
    public String getZhiyuanName() {
        return zhiyuanName;
    }


    /**
	 * 设置：职员姓名
	 */
    public void setZhiyuanName(String zhiyuanName) {
        this.zhiyuanName = zhiyuanName;
    }
    /**
	 * 获取：头像
	 */
    public String getZhiyuanPhoto() {
        return zhiyuanPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setZhiyuanPhoto(String zhiyuanPhoto) {
        this.zhiyuanPhoto = zhiyuanPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：联系方式
	 */
    public String getZhiyuanPhone() {
        return zhiyuanPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setZhiyuanPhone(String zhiyuanPhone) {
        this.zhiyuanPhone = zhiyuanPhone;
    }
    /**
	 * 获取：身份证号
	 */
    public String getZhiyuanIdNumber() {
        return zhiyuanIdNumber;
    }


    /**
	 * 设置：身份证号
	 */
    public void setZhiyuanIdNumber(String zhiyuanIdNumber) {
        this.zhiyuanIdNumber = zhiyuanIdNumber;
    }
    /**
	 * 获取：邮箱
	 */
    public String getZhiyuanEmail() {
        return zhiyuanEmail;
    }


    /**
	 * 设置：邮箱
	 */
    public void setZhiyuanEmail(String zhiyuanEmail) {
        this.zhiyuanEmail = zhiyuanEmail;
    }
    /**
	 * 获取：假删
	 */
    public Integer getZhiyuanDelete() {
        return zhiyuanDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setZhiyuanDelete(Integer zhiyuanDelete) {
        this.zhiyuanDelete = zhiyuanDelete;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
