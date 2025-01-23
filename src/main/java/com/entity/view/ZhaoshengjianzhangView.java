package com.entity.view;

import com.entity.ZhaoshengjianzhangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 招生简章
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
@TableName("zhaoshengjianzhang")
public class ZhaoshengjianzhangView  extends ZhaoshengjianzhangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhaoshengjianzhangView(){
	}
 
 	public ZhaoshengjianzhangView(ZhaoshengjianzhangEntity zhaoshengjianzhangEntity){
 	try {
			BeanUtils.copyProperties(this, zhaoshengjianzhangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
