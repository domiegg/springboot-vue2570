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
 * 拍摄选图
 *
 * @author 
 * @email
 */
@TableName("paishexuantu")
public class PaishexuantuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PaishexuantuEntity() {

	}

	public PaishexuantuEntity(T t) {
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
     * 拍摄预定
     */
    @TableField(value = "paishexiangmu_id")

    private Integer paishexiangmuId;


    /**
     * 图片
     */
    @TableField(value = "paishexuantu_photo")

    private String paishexuantuPhoto;


    /**
     * 状态
     */
    @TableField(value = "paishexuantu_types")

    private Integer paishexuantuTypes;


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
	 * 设置：拍摄预定
	 */
    public Integer getPaishexiangmuId() {
        return paishexiangmuId;
    }
    /**
	 * 获取：拍摄预定
	 */

    public void setPaishexiangmuId(Integer paishexiangmuId) {
        this.paishexiangmuId = paishexiangmuId;
    }
    /**
	 * 设置：图片
	 */
    public String getPaishexuantuPhoto() {
        return paishexuantuPhoto;
    }
    /**
	 * 获取：图片
	 */

    public void setPaishexuantuPhoto(String paishexuantuPhoto) {
        this.paishexuantuPhoto = paishexuantuPhoto;
    }
    /**
	 * 设置：状态
	 */
    public Integer getPaishexuantuTypes() {
        return paishexuantuTypes;
    }
    /**
	 * 获取：状态
	 */

    public void setPaishexuantuTypes(Integer paishexuantuTypes) {
        this.paishexuantuTypes = paishexuantuTypes;
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
        return "Paishexuantu{" +
            "id=" + id +
            ", paishexiangmuId=" + paishexiangmuId +
            ", paishexuantuPhoto=" + paishexuantuPhoto +
            ", paishexuantuTypes=" + paishexuantuTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
