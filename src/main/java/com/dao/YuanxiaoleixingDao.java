package com.dao;

import com.entity.YuanxiaoleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuanxiaoleixingVO;
import com.entity.view.YuanxiaoleixingView;


/**
 * 院校类型
 * 
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface YuanxiaoleixingDao extends BaseMapper<YuanxiaoleixingEntity> {
	
	List<YuanxiaoleixingVO> selectListVO(@Param("ew") Wrapper<YuanxiaoleixingEntity> wrapper);
	
	YuanxiaoleixingVO selectVO(@Param("ew") Wrapper<YuanxiaoleixingEntity> wrapper);
	
	List<YuanxiaoleixingView> selectListView(@Param("ew") Wrapper<YuanxiaoleixingEntity> wrapper);

	List<YuanxiaoleixingView> selectListView(Pagination page,@Param("ew") Wrapper<YuanxiaoleixingEntity> wrapper);
	
	YuanxiaoleixingView selectView(@Param("ew") Wrapper<YuanxiaoleixingEntity> wrapper);
	

}
