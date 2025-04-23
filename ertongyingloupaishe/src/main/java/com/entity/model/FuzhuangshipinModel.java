package com.entity.model;

import com.entity.FuzhuangshipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 服装饰品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FuzhuangshipinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 服装编号
     */
    private String fuzhuangshipinUuidNumber;


    /**
     * 服装名称
     */
    private String fuzhuangshipinName;


    /**
     * 服装照片
     */
    private String fuzhuangshipinPhoto;


    /**
     * 服装类型
     */
    private Integer fuzhuangshipinTypes;


    /**
     * 现价
     */
    private Double fuzhuangshipinNewMoney;


    /**
     * 服装介绍
     */
    private String fuzhuangshipinContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：服装编号
	 */
    public String getFuzhuangshipinUuidNumber() {
        return fuzhuangshipinUuidNumber;
    }


    /**
	 * 设置：服装编号
	 */
    public void setFuzhuangshipinUuidNumber(String fuzhuangshipinUuidNumber) {
        this.fuzhuangshipinUuidNumber = fuzhuangshipinUuidNumber;
    }
    /**
	 * 获取：服装名称
	 */
    public String getFuzhuangshipinName() {
        return fuzhuangshipinName;
    }


    /**
	 * 设置：服装名称
	 */
    public void setFuzhuangshipinName(String fuzhuangshipinName) {
        this.fuzhuangshipinName = fuzhuangshipinName;
    }
    /**
	 * 获取：服装照片
	 */
    public String getFuzhuangshipinPhoto() {
        return fuzhuangshipinPhoto;
    }


    /**
	 * 设置：服装照片
	 */
    public void setFuzhuangshipinPhoto(String fuzhuangshipinPhoto) {
        this.fuzhuangshipinPhoto = fuzhuangshipinPhoto;
    }
    /**
	 * 获取：服装类型
	 */
    public Integer getFuzhuangshipinTypes() {
        return fuzhuangshipinTypes;
    }


    /**
	 * 设置：服装类型
	 */
    public void setFuzhuangshipinTypes(Integer fuzhuangshipinTypes) {
        this.fuzhuangshipinTypes = fuzhuangshipinTypes;
    }
    /**
	 * 获取：现价
	 */
    public Double getFuzhuangshipinNewMoney() {
        return fuzhuangshipinNewMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setFuzhuangshipinNewMoney(Double fuzhuangshipinNewMoney) {
        this.fuzhuangshipinNewMoney = fuzhuangshipinNewMoney;
    }
    /**
	 * 获取：服装介绍
	 */
    public String getFuzhuangshipinContent() {
        return fuzhuangshipinContent;
    }


    /**
	 * 设置：服装介绍
	 */
    public void setFuzhuangshipinContent(String fuzhuangshipinContent) {
        this.fuzhuangshipinContent = fuzhuangshipinContent;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
