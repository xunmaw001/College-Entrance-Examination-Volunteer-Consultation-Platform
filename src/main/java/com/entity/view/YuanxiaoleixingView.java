package com.entity.view;

import com.entity.YuanxiaoleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 院校类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
@TableName("yuanxiaoleixing")
public class YuanxiaoleixingView  extends YuanxiaoleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuanxiaoleixingView(){
	}
 
 	public YuanxiaoleixingView(YuanxiaoleixingEntity yuanxiaoleixingEntity){
 	try {
			BeanUtils.copyProperties(this, yuanxiaoleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
