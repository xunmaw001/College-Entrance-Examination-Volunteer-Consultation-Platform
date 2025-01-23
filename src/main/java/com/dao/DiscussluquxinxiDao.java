package com.dao;

import com.entity.DiscussluquxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussluquxinxiVO;
import com.entity.view.DiscussluquxinxiView;


/**
 * 录取信息评论表
 * 
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface DiscussluquxinxiDao extends BaseMapper<DiscussluquxinxiEntity> {
	
	List<DiscussluquxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussluquxinxiEntity> wrapper);
	
	DiscussluquxinxiVO selectVO(@Param("ew") Wrapper<DiscussluquxinxiEntity> wrapper);
	
	List<DiscussluquxinxiView> selectListView(@Param("ew") Wrapper<DiscussluquxinxiEntity> wrapper);

	List<DiscussluquxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussluquxinxiEntity> wrapper);
	
	DiscussluquxinxiView selectView(@Param("ew") Wrapper<DiscussluquxinxiEntity> wrapper);
	

}
