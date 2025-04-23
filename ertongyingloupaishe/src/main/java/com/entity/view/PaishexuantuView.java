package com.entity.view;

import com.entity.PaishexuantuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 拍摄选图
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("paishexuantu")
public class PaishexuantuView extends PaishexuantuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 状态的值
		*/
		private String paishexuantuValue;



		//级联表 paishexiangmu
			/**
			* 订单号
			*/
			private String paisheyudingOrderUuidNumber;
			/**
			* 拍摄项目
			*/
			private Integer paishexiangmuTypes;
				/**
				* 拍摄项目的值
				*/
				private String paishexiangmuValue;
			/**
			* 预约时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
				* 订单类型的值
				*/
				private String paisheyudingOrderValue;
			/**
			* 拍摄预定 的 用户
			*/
			private Integer paishexiangmuYonghuId;

	public PaishexuantuView() {

	}

	public PaishexuantuView(PaishexuantuEntity paishexuantuEntity) {
		try {
			BeanUtils.copyProperties(this, paishexuantuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 状态的值
			*/
			public String getPaishexuantuValue() {
				return paishexuantuValue;
			}
			/**
			* 设置： 状态的值
			*/
			public void setPaishexuantuValue(String paishexuantuValue) {
				this.paishexuantuValue = paishexuantuValue;
			}












				//级联表的get和set paishexiangmu

					/**
					* 获取： 订单号
					*/
					public String getPaisheyudingOrderUuidNumber() {
						return paisheyudingOrderUuidNumber;
					}
					/**
					* 设置： 订单号
					*/
					public void setPaisheyudingOrderUuidNumber(String paisheyudingOrderUuidNumber) {
						this.paisheyudingOrderUuidNumber = paisheyudingOrderUuidNumber;
					}

					/**
					* 获取： 拍摄项目
					*/
					public Integer getPaishexiangmuTypes() {
						return paishexiangmuTypes;
					}
					/**
					* 设置： 拍摄项目
					*/
					public void setPaishexiangmuTypes(Integer paishexiangmuTypes) {
						this.paishexiangmuTypes = paishexiangmuTypes;
					}


						/**
						* 获取： 拍摄项目的值
						*/
						public String getPaishexiangmuValue() {
							return paishexiangmuValue;
						}
						/**
						* 设置： 拍摄项目的值
						*/
						public void setPaishexiangmuValue(String paishexiangmuValue) {
							this.paishexiangmuValue = paishexiangmuValue;
						}

					/**
					* 获取： 预约时间
					*/
					public Date getPaisheyudingTime() {
						return paisheyudingTime;
					}
					/**
					* 设置： 预约时间
					*/
					public void setPaisheyudingTime(Date paisheyudingTime) {
						this.paisheyudingTime = paisheyudingTime;
					}

					/**
					* 获取： 定金
					*/
					public Double getPaishexiangmuNumber() {
						return paishexiangmuNumber;
					}
					/**
					* 设置： 定金
					*/
					public void setPaishexiangmuNumber(Double paishexiangmuNumber) {
						this.paishexiangmuNumber = paishexiangmuNumber;
					}

					/**
					* 获取： 订单类型
					*/
					public Integer getPaisheyudingOrderTypes() {
						return paisheyudingOrderTypes;
					}
					/**
					* 设置： 订单类型
					*/
					public void setPaisheyudingOrderTypes(Integer paisheyudingOrderTypes) {
						this.paisheyudingOrderTypes = paisheyudingOrderTypes;
					}


						/**
						* 获取： 订单类型的值
						*/
						public String getPaisheyudingOrderValue() {
							return paisheyudingOrderValue;
						}
						/**
						* 设置： 订单类型的值
						*/
						public void setPaisheyudingOrderValue(String paisheyudingOrderValue) {
							this.paisheyudingOrderValue = paisheyudingOrderValue;
						}

					/**
					* 获取：拍摄预定 的 用户
					*/
					public Integer getPaishexiangmuYonghuId() {
						return paishexiangmuYonghuId;
					}
					/**
					* 设置：拍摄预定 的 用户
					*/
					public void setPaishexiangmuYonghuId(Integer paishexiangmuYonghuId) {
						this.paishexiangmuYonghuId = paishexiangmuYonghuId;
					}













}
