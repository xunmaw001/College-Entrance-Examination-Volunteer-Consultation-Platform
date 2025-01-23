package com.entity.view;

import com.entity.ZhuanyejianxunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 专业简讯
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
@TableName("zhuanyejianxun")
public class ZhuanyejianxunView  extends ZhuanyejianxunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhuanyejianxunView(){
	}
 
 	public ZhuanyejianxunView(ZhuanyejianxunEntity zhuanyejianxunEntity){
 	try {
			BeanUtils.copyProperties(this, zhuanyejianxunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
