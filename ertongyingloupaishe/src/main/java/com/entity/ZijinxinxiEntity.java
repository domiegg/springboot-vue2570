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
 * 资金信息
 *
 * @author 
 * @email
 */
@TableName("zijinxinxi")
public class ZijinxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZijinxinxiEntity() {

	}

	public ZijinxinxiEntity(T t) {
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
     * 标题
     */
    @TableField(value = "zijinxinxi_name")

    private String zijinxinxiName;


    /**
     * 相关金额
     */
    @TableField(value = "zijinxinxi_number")

    private Double zijinxinxiNumber;


    /**
     * 类型
     */
    @TableField(value = "zijinxinxi_types")

    private Integer zijinxinxiTypes;


    /**
     * 备注
     */
    @TableField(value = "zijinxinxi_text")

    private String zijinxinxiText;


    /**
     * 插入时间
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
	 * 设置：标题
	 */
    public String getZijinxinxiName() {
        return zijinxinxiName;
    }
    /**
	 * 获取：标题
	 */

    public void setZijinxinxiName(String zijinxinxiName) {
        this.zijinxinxiName = zijinxinxiName;
    }
    /**
	 * 设置：相关金额
	 */
    public Double getZijinxinxiNumber() {
        return zijinxinxiNumber;
    }
    /**
	 * 获取：相关金额
	 */

    public void setZijinxinxiNumber(Double zijinxinxiNumber) {
        this.zijinxinxiNumber = zijinxinxiNumber;
    }
    /**
	 * 设置：类型
	 */
    public Integer getZijinxinxiTypes() {
        return zijinxinxiTypes;
    }
    /**
	 * 获取：类型
	 */

    public void setZijinxinxiTypes(Integer zijinxinxiTypes) {
        this.zijinxinxiTypes = zijinxinxiTypes;
    }
    /**
	 * 设置：备注
	 */
    public String getZijinxinxiText() {
        return zijinxinxiText;
    }
    /**
	 * 获取：备注
	 */

    public void setZijinxinxiText(String zijinxinxiText) {
        this.zijinxinxiText = zijinxinxiText;
    }
    /**
	 * 设置：插入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：插入时间
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
        return "Zijinxinxi{" +
            "id=" + id +
            ", zijinxinxiName=" + zijinxinxiName +
            ", zijinxinxiNumber=" + zijinxinxiNumber +
            ", zijinxinxiTypes=" + zijinxinxiTypes +
            ", zijinxinxiText=" + zijinxinxiText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
