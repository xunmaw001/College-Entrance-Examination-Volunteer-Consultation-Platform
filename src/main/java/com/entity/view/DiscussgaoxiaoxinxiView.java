package com.entity.view;

import com.entity.DiscussgaoxiaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 高校信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
@TableName("discussgaoxiaoxinxi")
public class DiscussgaoxiaoxinxiView  extends DiscussgaoxiaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussgaoxiaoxinxiView(){
	}
 
 	public DiscussgaoxiaoxinxiView(DiscussgaoxiaoxinxiEntity discussgaoxiaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussgaoxiaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
