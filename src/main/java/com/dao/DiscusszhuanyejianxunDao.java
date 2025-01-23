package com.dao;

import com.entity.DiscusszhuanyejianxunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhuanyejianxunVO;
import com.entity.view.DiscusszhuanyejianxunView;


/**
 * 专业简讯评论表
 * 
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface DiscusszhuanyejianxunDao extends BaseMapper<DiscusszhuanyejianxunEntity> {
	
	List<DiscusszhuanyejianxunVO> selectListVO(@Param("ew") Wrapper<DiscusszhuanyejianxunEntity> wrapper);
	
	DiscusszhuanyejianxunVO selectVO(@Param("ew") Wrapper<DiscusszhuanyejianxunEntity> wrapper);
	
	List<DiscusszhuanyejianxunView> selectListView(@Param("ew") Wrapper<DiscusszhuanyejianxunEntity> wrapper);

	List<DiscusszhuanyejianxunView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhuanyejianxunEntity> wrapper);
	
	DiscusszhuanyejianxunView selectView(@Param("ew") Wrapper<DiscusszhuanyejianxunEntity> wrapper);
	

}
