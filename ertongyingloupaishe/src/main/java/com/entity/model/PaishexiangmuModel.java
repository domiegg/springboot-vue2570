package com.entity.model;

import com.entity.PaishexiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 拍摄预定
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PaishexiangmuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String paisheyudingOrderUuidNumber;


    /**
     * 拍摄项目
     */
    private Integer paishexiangmuTypes;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date paisheyudingTime;


    /**
     * 定金
     */
    private Double paishexiangmuNumber;


    /**
     * 订单类型
     */
    private Integer paisheyudingOrderTypes;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：订单号
	 */
    public String getPaisheyudingOrderUuidNumber() {
        return paisheyudingOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setPaisheyudingOrderUuidNumber(String paisheyudingOrderUuidNumber) {
        this.paisheyudingOrderUuidNumber = paisheyudingOrderUuidNumber;
    }
    /**
	 * 获取：拍摄项目
	 */
    public Integer getPaishexiangmuTypes() {
        return paishexiangmuTypes;
    }


    /**
	 * 设置：拍摄项目
	 */
    public void setPaishexiangmuTypes(Integer paishexiangmuTypes) {
        this.paishexiangmuTypes = paishexiangmuTypes;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getPaisheyudingTime() {
        return paisheyudingTime;
    }


    /**
	 * 设置：预约时间
	 */
    public void setPaisheyudingTime(Date paisheyudingTime) {
        this.paisheyudingTime = paisheyudingTime;
    }
    /**
	 * 获取：定金
	 */
    public Double getPaishexiangmuNumber() {
        return paishexiangmuNumber;
    }


    /**
	 * 设置：定金
	 */
    public void setPaishexiangmuNumber(Double paishexiangmuNumber) {
        this.paishexiangmuNumber = paishexiangmuNumber;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getPaisheyudingOrderTypes() {
        return paisheyudingOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setPaisheyudingOrderTypes(Integer paisheyudingOrderTypes) {
        this.paisheyudingOrderTypes = paisheyudingOrderTypes;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发布时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
