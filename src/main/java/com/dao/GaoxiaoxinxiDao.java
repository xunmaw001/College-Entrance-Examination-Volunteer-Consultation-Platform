package com.dao;

import com.entity.GaoxiaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GaoxiaoxinxiVO;
import com.entity.view.GaoxiaoxinxiView;


/**
 * 高校信息
 * 
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface GaoxiaoxinxiDao extends BaseMapper<GaoxiaoxinxiEntity> {
	
	List<GaoxiaoxinxiVO> selectListVO(@Param("ew") Wrapper<GaoxiaoxinxiEntity> wrapper);
	
	GaoxiaoxinxiVO selectVO(@Param("ew") Wrapper<GaoxiaoxinxiEntity> wrapper);
	
	List<GaoxiaoxinxiView> selectListView(@Param("ew") Wrapper<GaoxiaoxinxiEntity> wrapper);

	List<GaoxiaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<GaoxiaoxinxiEntity> wrapper);
	
	GaoxiaoxinxiView selectView(@Param("ew") Wrapper<GaoxiaoxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GaoxiaoxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GaoxiaoxinxiEntity> wrapper);
    
    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GaoxiaoxinxiEntity> wrapper);



}
