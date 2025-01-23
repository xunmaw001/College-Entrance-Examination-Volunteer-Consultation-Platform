package com.dao;

import com.entity.LuqufenshuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LuqufenshuVO;
import com.entity.view.LuqufenshuView;


/**
 * 录取分数
 * 
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface LuqufenshuDao extends BaseMapper<LuqufenshuEntity> {
	
	List<LuqufenshuVO> selectListVO(@Param("ew") Wrapper<LuqufenshuEntity> wrapper);
	
	LuqufenshuVO selectVO(@Param("ew") Wrapper<LuqufenshuEntity> wrapper);
	
	List<LuqufenshuView> selectListView(@Param("ew") Wrapper<LuqufenshuEntity> wrapper);

	List<LuqufenshuView> selectListView(Pagination page,@Param("ew") Wrapper<LuqufenshuEntity> wrapper);
	
	LuqufenshuView selectView(@Param("ew") Wrapper<LuqufenshuEntity> wrapper);
	

}
