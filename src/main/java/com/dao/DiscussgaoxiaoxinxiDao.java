package com.dao;

import com.entity.DiscussgaoxiaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussgaoxiaoxinxiVO;
import com.entity.view.DiscussgaoxiaoxinxiView;


/**
 * 高校信息评论表
 * 
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface DiscussgaoxiaoxinxiDao extends BaseMapper<DiscussgaoxiaoxinxiEntity> {
	
	List<DiscussgaoxiaoxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussgaoxiaoxinxiEntity> wrapper);
	
	DiscussgaoxiaoxinxiVO selectVO(@Param("ew") Wrapper<DiscussgaoxiaoxinxiEntity> wrapper);
	
	List<DiscussgaoxiaoxinxiView> selectListView(@Param("ew") Wrapper<DiscussgaoxiaoxinxiEntity> wrapper);

	List<DiscussgaoxiaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussgaoxiaoxinxiEntity> wrapper);
	
	DiscussgaoxiaoxinxiView selectView(@Param("ew") Wrapper<DiscussgaoxiaoxinxiEntity> wrapper);
	

}
