package com.entity.view;

import com.entity.FuzhuangshipinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 服装饰品
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fuzhuangshipin")
public class FuzhuangshipinView extends FuzhuangshipinEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 服装类型的值
		*/
		private String fuzhuangshipinValue;



	public FuzhuangshipinView() {

	}

	public FuzhuangshipinView(FuzhuangshipinEntity fuzhuangshipinEntity) {
		try {
			BeanUtils.copyProperties(this, fuzhuangshipinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 服装类型的值
			*/
			public String getFuzhuangshipinValue() {
				return fuzhuangshipinValue;
			}
			/**
			* 设置： 服装类型的值
			*/
			public void setFuzhuangshipinValue(String fuzhuangshipinValue) {
				this.fuzhuangshipinValue = fuzhuangshipinValue;
			}













}
