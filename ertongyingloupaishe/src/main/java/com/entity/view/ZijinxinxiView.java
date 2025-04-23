package com.entity.view;

import com.entity.ZijinxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 资金信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zijinxinxi")
public class ZijinxinxiView extends ZijinxinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String zijinxinxiValue;



	public ZijinxinxiView() {

	}

	public ZijinxinxiView(ZijinxinxiEntity zijinxinxiEntity) {
		try {
			BeanUtils.copyProperties(this, zijinxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getZijinxinxiValue() {
				return zijinxinxiValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setZijinxinxiValue(String zijinxinxiValue) {
				this.zijinxinxiValue = zijinxinxiValue;
			}













}
