package com.dao;

import com.entity.ZhuanyejianxunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhuanyejianxunVO;
import com.entity.view.ZhuanyejianxunView;


/**
 * 专业简讯
 * 
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface ZhuanyejianxunDao extends BaseMapper<ZhuanyejianxunEntity> {
	
	List<ZhuanyejianxunVO> selectListVO(@Param("ew") Wrapper<ZhuanyejianxunEntity> wrapper);
	
	ZhuanyejianxunVO selectVO(@Param("ew") Wrapper<ZhuanyejianxunEntity> wrapper);
	
	List<ZhuanyejianxunView> selectListView(@Param("ew") Wrapper<ZhuanyejianxunEntity> wrapper);

	List<ZhuanyejianxunView> selectListView(Pagination page,@Param("ew") Wrapper<ZhuanyejianxunEntity> wrapper);
	
	ZhuanyejianxunView selectView(@Param("ew") Wrapper<ZhuanyejianxunEntity> wrapper);
	

}
