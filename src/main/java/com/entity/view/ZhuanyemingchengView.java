package com.entity.view;

import com.entity.ZhuanyemingchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 专业名称
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
@TableName("zhuanyemingcheng")
public class ZhuanyemingchengView  extends ZhuanyemingchengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhuanyemingchengView(){
	}
 
 	public ZhuanyemingchengView(ZhuanyemingchengEntity zhuanyemingchengEntity){
 	try {
			BeanUtils.copyProperties(this, zhuanyemingchengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
