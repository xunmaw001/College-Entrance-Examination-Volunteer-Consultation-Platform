package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LuqufenshuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LuqufenshuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LuqufenshuView;


/**
 * 录取分数
 *
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface LuqufenshuService extends IService<LuqufenshuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LuqufenshuVO> selectListVO(Wrapper<LuqufenshuEntity> wrapper);
   	
   	LuqufenshuVO selectVO(@Param("ew") Wrapper<LuqufenshuEntity> wrapper);
   	
   	List<LuqufenshuView> selectListView(Wrapper<LuqufenshuEntity> wrapper);
   	
   	LuqufenshuView selectView(@Param("ew") Wrapper<LuqufenshuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LuqufenshuEntity> wrapper);
   	

}

