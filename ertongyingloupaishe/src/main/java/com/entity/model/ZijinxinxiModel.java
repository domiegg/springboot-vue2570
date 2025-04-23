package com.entity.model;

import com.entity.ZijinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 资金信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZijinxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String zijinxinxiName;


    /**
     * 相关金额
     */
    private Double zijinxinxiNumber;


    /**
     * 类型
     */
    private Integer zijinxinxiTypes;


    /**
     * 备注
     */
    private String zijinxinxiText;


    /**
     * 插入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：标题
	 */
    public String getZijinxinxiName() {
        return zijinxinxiName;
    }


    /**
	 * 设置：标题
	 */
    public void setZijinxinxiName(String zijinxinxiName) {
        this.zijinxinxiName = zijinxinxiName;
    }
    /**
	 * 获取：相关金额
	 */
    public Double getZijinxinxiNumber() {
        return zijinxinxiNumber;
    }


    /**
	 * 设置：相关金额
	 */
    public void setZijinxinxiNumber(Double zijinxinxiNumber) {
        this.zijinxinxiNumber = zijinxinxiNumber;
    }
    /**
	 * 获取：类型
	 */
    public Integer getZijinxinxiTypes() {
        return zijinxinxiTypes;
    }


    /**
	 * 设置：类型
	 */
    public void setZijinxinxiTypes(Integer zijinxinxiTypes) {
        this.zijinxinxiTypes = zijinxinxiTypes;
    }
    /**
	 * 获取：备注
	 */
    public String getZijinxinxiText() {
        return zijinxinxiText;
    }


    /**
	 * 设置：备注
	 */
    public void setZijinxinxiText(String zijinxinxiText) {
        this.zijinxinxiText = zijinxinxiText;
    }
    /**
	 * 获取：插入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：插入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
