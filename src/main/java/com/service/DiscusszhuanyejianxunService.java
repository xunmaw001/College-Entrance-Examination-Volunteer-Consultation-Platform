package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszhuanyejianxunEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszhuanyejianxunVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszhuanyejianxunView;


/**
 * 专业简讯评论表
 *
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface DiscusszhuanyejianxunService extends IService<DiscusszhuanyejianxunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhuanyejianxunVO> selectListVO(Wrapper<DiscusszhuanyejianxunEntity> wrapper);
   	
   	DiscusszhuanyejianxunVO selectVO(@Param("ew") Wrapper<DiscusszhuanyejianxunEntity> wrapper);
   	
   	List<DiscusszhuanyejianxunView> selectListView(Wrapper<DiscusszhuanyejianxunEntity> wrapper);
   	
   	DiscusszhuanyejianxunView selectView(@Param("ew") Wrapper<DiscusszhuanyejianxunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhuanyejianxunEntity> wrapper);
   	

}

