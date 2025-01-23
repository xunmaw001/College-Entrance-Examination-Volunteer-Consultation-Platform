package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussluquxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussluquxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussluquxinxiView;


/**
 * 录取信息评论表
 *
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface DiscussluquxinxiService extends IService<DiscussluquxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussluquxinxiVO> selectListVO(Wrapper<DiscussluquxinxiEntity> wrapper);
   	
   	DiscussluquxinxiVO selectVO(@Param("ew") Wrapper<DiscussluquxinxiEntity> wrapper);
   	
   	List<DiscussluquxinxiView> selectListView(Wrapper<DiscussluquxinxiEntity> wrapper);
   	
   	DiscussluquxinxiView selectView(@Param("ew") Wrapper<DiscussluquxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussluquxinxiEntity> wrapper);
   	

}

