package com.entity.vo;

import com.entity.PaishexiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 拍摄预定
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("paishexiangmu")
public class PaishexiangmuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
