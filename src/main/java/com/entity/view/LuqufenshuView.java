package com.entity.view;

import com.entity.LuqufenshuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 录取分数
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
@TableName("luqufenshu")
public class LuqufenshuView  extends LuqufenshuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LuqufenshuView(){
	}
 
 	public LuqufenshuView(LuqufenshuEntity luqufenshuEntity){
 	try {
			BeanUtils.copyProperties(this, luqufenshuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
