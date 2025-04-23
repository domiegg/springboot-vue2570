package com.entity.vo;

import com.entity.PaishexuantuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 拍摄选图
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("paishexuantu")
public class PaishexuantuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
