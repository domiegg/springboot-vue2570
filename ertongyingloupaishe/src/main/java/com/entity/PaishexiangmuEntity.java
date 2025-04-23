package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 拍摄预定
 *
 * @author 
 * @email
 */
@TableName("paishexiangmu")
public class PaishexiangmuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PaishexiangmuEntity() {

	}

	public PaishexiangmuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单号
     */
    @TableField(value = "paisheyuding_order_uuid_number")

    private String paisheyudingOrderUuidNumber;


    /**
     * 拍摄项目
     */
    @TableField(value = "paishexiangmu_types")

    private Integer paishexiangmuTypes;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "paisheyuding_time")

    private Date paisheyudingTime;


    /**
     * 定金
     */
    @TableField(value = "paishexiangmu_number")

    private Double paishexiangmuNumber;


    /**
     * 订单类型
     */
    @TableField(value = "paisheyuding_order_types")

    private Integer paisheyudingOrderTypes;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getPaisheyudingOrderUuidNumber() {
        return paisheyudingOrderUuidNumber;
    }
    /**
	 * 获取：订单号
	 */

    public void setPaisheyudingOrderUuidNumber(String paisheyudingOrderUuidNumber) {
        this.paisheyudingOrderUuidNumber = paisheyudingOrderUuidNumber;
    }
    /**
	 * 设置：拍摄项目
	 */
    public Integer getPaishexiangmuTypes() {
        return paishexiangmuTypes;
    }
    /**
	 * 获取：拍摄项目
	 */

    public void setPaishexiangmuTypes(Integer paishexiangmuTypes) {
        this.paishexiangmuTypes = paishexiangmuTypes;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getPaisheyudingTime() {
        return paisheyudingTime;
    }
    /**
	 * 获取：预约时间
	 */

    public void setPaisheyudingTime(Date paisheyudingTime) {
        this.paisheyudingTime = paisheyudingTime;
    }
    /**
	 * 设置：定金
	 */
    public Double getPaishexiangmuNumber() {
        return paishexiangmuNumber;
    }
    /**
	 * 获取：定金
	 */

    public void setPaishexiangmuNumber(Double paishexiangmuNumber) {
        this.paishexiangmuNumber = paishexiangmuNumber;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getPaisheyudingOrderTypes() {
        return paisheyudingOrderTypes;
    }
    /**
	 * 获取：订单类型
	 */

    public void setPaisheyudingOrderTypes(Integer paisheyudingOrderTypes) {
        this.paisheyudingOrderTypes = paisheyudingOrderTypes;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Paishexiangmu{" +
            "id=" + id +
            ", paisheyudingOrderUuidNumber=" + paisheyudingOrderUuidNumber +
            ", paishexiangmuTypes=" + paishexiangmuTypes +
            ", paisheyudingTime=" + paisheyudingTime +
            ", paishexiangmuNumber=" + paishexiangmuNumber +
            ", paisheyudingOrderTypes=" + paisheyudingOrderTypes +
            ", yonghuId=" + yonghuId +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
