package com.dao;

import com.entity.ZhuanyemingchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhuanyemingchengVO;
import com.entity.view.ZhuanyemingchengView;


/**
 * 专业名称
 * 
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface ZhuanyemingchengDao extends BaseMapper<ZhuanyemingchengEntity> {
	
	List<ZhuanyemingchengVO> selectListVO(@Param("ew") Wrapper<ZhuanyemingchengEntity> wrapper);
	
	ZhuanyemingchengVO selectVO(@Param("ew") Wrapper<ZhuanyemingchengEntity> wrapper);
	
	List<ZhuanyemingchengView> selectListView(@Param("ew") Wrapper<ZhuanyemingchengEntity> wrapper);

	List<ZhuanyemingchengView> selectListView(Pagination page,@Param("ew") Wrapper<ZhuanyemingchengEntity> wrapper);
	
	ZhuanyemingchengView selectView(@Param("ew") Wrapper<ZhuanyemingchengEntity> wrapper);
	

}
