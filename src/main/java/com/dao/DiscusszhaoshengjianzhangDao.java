package com.dao;

import com.entity.DiscusszhaoshengjianzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhaoshengjianzhangVO;
import com.entity.view.DiscusszhaoshengjianzhangView;


/**
 * 招生简章评论表
 * 
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface DiscusszhaoshengjianzhangDao extends BaseMapper<DiscusszhaoshengjianzhangEntity> {
	
	List<DiscusszhaoshengjianzhangVO> selectListVO(@Param("ew") Wrapper<DiscusszhaoshengjianzhangEntity> wrapper);
	
	DiscusszhaoshengjianzhangVO selectVO(@Param("ew") Wrapper<DiscusszhaoshengjianzhangEntity> wrapper);
	
	List<DiscusszhaoshengjianzhangView> selectListView(@Param("ew") Wrapper<DiscusszhaoshengjianzhangEntity> wrapper);

	List<DiscusszhaoshengjianzhangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhaoshengjianzhangEntity> wrapper);
	
	DiscusszhaoshengjianzhangView selectView(@Param("ew") Wrapper<DiscusszhaoshengjianzhangEntity> wrapper);
	

}
