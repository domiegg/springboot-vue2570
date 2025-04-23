package com.entity.view;

import com.entity.PaishexiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 拍摄预定
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("paishexiangmu")
public class PaishexiangmuView extends PaishexiangmuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 拍摄项目的值
		*/
		private String paishexiangmuValue;
		/**
		* 订单类型的值
		*/
		private String paisheyudingOrderValue;



		//级联表 yonghu
			/**
			* 顾客姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 身份
			*/
			private Integer yonghushenfenTypes;
				/**
				* 身份的值
				*/
				private String yonghushenfenValue;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public PaishexiangmuView() {

	}

	public PaishexiangmuView(PaishexiangmuEntity paishexiangmuEntity) {
		try {
			BeanUtils.copyProperties(this, paishexiangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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


















				//级联表的get和set yonghu

					/**
					* 获取： 顾客姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 顾客姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 身份
					*/
					public Integer getYonghushenfenTypes() {
						return yonghushenfenTypes;
					}
					/**
					* 设置： 身份
					*/
					public void setYonghushenfenTypes(Integer yonghushenfenTypes) {
						this.yonghushenfenTypes = yonghushenfenTypes;
					}


						/**
						* 获取： 身份的值
						*/
						public String getYonghushenfenValue() {
							return yonghushenfenValue;
						}
						/**
						* 设置： 身份的值
						*/
						public void setYonghushenfenValue(String yonghushenfenValue) {
							this.yonghushenfenValue = yonghushenfenValue;
						}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}






}
