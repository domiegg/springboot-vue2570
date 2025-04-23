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
 * 服装饰品
 *
 * @author 
 * @email
 */
@TableName("fuzhuangshipin")
public class FuzhuangshipinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FuzhuangshipinEntity() {

	}

	public FuzhuangshipinEntity(T t) {
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
     * 服装编号
     */
    @TableField(value = "fuzhuangshipin_uuid_number")

    private String fuzhuangshipinUuidNumber;


    /**
     * 服装名称
     */
    @TableField(value = "fuzhuangshipin_name")

    private String fuzhuangshipinName;


    /**
     * 服装照片
     */
    @TableField(value = "fuzhuangshipin_photo")

    private String fuzhuangshipinPhoto;


    /**
     * 服装类型
     */
    @TableField(value = "fuzhuangshipin_types")

    private Integer fuzhuangshipinTypes;


    /**
     * 现价
     */
    @TableField(value = "fuzhuangshipin_new_money")

    private Double fuzhuangshipinNewMoney;


    /**
     * 服装介绍
     */
    @TableField(value = "fuzhuangshipin_content")

    private String fuzhuangshipinContent;


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
	 * 设置：服装编号
	 */
    public String getFuzhuangshipinUuidNumber() {
        return fuzhuangshipinUuidNumber;
    }
    /**
	 * 获取：服装编号
	 */

    public void setFuzhuangshipinUuidNumber(String fuzhuangshipinUuidNumber) {
        this.fuzhuangshipinUuidNumber = fuzhuangshipinUuidNumber;
    }
    /**
	 * 设置：服装名称
	 */
    public String getFuzhuangshipinName() {
        return fuzhuangshipinName;
    }
    /**
	 * 获取：服装名称
	 */

    public void setFuzhuangshipinName(String fuzhuangshipinName) {
        this.fuzhuangshipinName = fuzhuangshipinName;
    }
    /**
	 * 设置：服装照片
	 */
    public String getFuzhuangshipinPhoto() {
        return fuzhuangshipinPhoto;
    }
    /**
	 * 获取：服装照片
	 */

    public void setFuzhuangshipinPhoto(String fuzhuangshipinPhoto) {
        this.fuzhuangshipinPhoto = fuzhuangshipinPhoto;
    }
    /**
	 * 设置：服装类型
	 */
    public Integer getFuzhuangshipinTypes() {
        return fuzhuangshipinTypes;
    }
    /**
	 * 获取：服装类型
	 */

    public void setFuzhuangshipinTypes(Integer fuzhuangshipinTypes) {
        this.fuzhuangshipinTypes = fuzhuangshipinTypes;
    }
    /**
	 * 设置：现价
	 */
    public Double getFuzhuangshipinNewMoney() {
        return fuzhuangshipinNewMoney;
    }
    /**
	 * 获取：现价
	 */

    public void setFuzhuangshipinNewMoney(Double fuzhuangshipinNewMoney) {
        this.fuzhuangshipinNewMoney = fuzhuangshipinNewMoney;
    }
    /**
	 * 设置：服装介绍
	 */
    public String getFuzhuangshipinContent() {
        return fuzhuangshipinContent;
    }
    /**
	 * 获取：服装介绍
	 */

    public void setFuzhuangshipinContent(String fuzhuangshipinContent) {
        this.fuzhuangshipinContent = fuzhuangshipinContent;
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
        return "Fuzhuangshipin{" +
            "id=" + id +
            ", fuzhuangshipinUuidNumber=" + fuzhuangshipinUuidNumber +
            ", fuzhuangshipinName=" + fuzhuangshipinName +
            ", fuzhuangshipinPhoto=" + fuzhuangshipinPhoto +
            ", fuzhuangshipinTypes=" + fuzhuangshipinTypes +
            ", fuzhuangshipinNewMoney=" + fuzhuangshipinNewMoney +
            ", fuzhuangshipinContent=" + fuzhuangshipinContent +
            ", createTime=" + createTime +
        "}";
    }
}
