package com.dao;

import com.entity.ZhaoshengjianzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhaoshengjianzhangVO;
import com.entity.view.ZhaoshengjianzhangView;


/**
 * 招生简章
 * 
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface ZhaoshengjianzhangDao extends BaseMapper<ZhaoshengjianzhangEntity> {
	
	List<ZhaoshengjianzhangVO> selectListVO(@Param("ew") Wrapper<ZhaoshengjianzhangEntity> wrapper);
	
	ZhaoshengjianzhangVO selectVO(@Param("ew") Wrapper<ZhaoshengjianzhangEntity> wrapper);
	
	List<ZhaoshengjianzhangView> selectListView(@Param("ew") Wrapper<ZhaoshengjianzhangEntity> wrapper);

	List<ZhaoshengjianzhangView> selectListView(Pagination page,@Param("ew") Wrapper<ZhaoshengjianzhangEntity> wrapper);
	
	ZhaoshengjianzhangView selectView(@Param("ew") Wrapper<ZhaoshengjianzhangEntity> wrapper);
	

}
