package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LuquxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LuquxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LuquxinxiView;


/**
 * 录取信息
 *
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface LuquxinxiService extends IService<LuquxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LuquxinxiVO> selectListVO(Wrapper<LuquxinxiEntity> wrapper);
   	
   	LuquxinxiVO selectVO(@Param("ew") Wrapper<LuquxinxiEntity> wrapper);
   	
   	List<LuquxinxiView> selectListView(Wrapper<LuquxinxiEntity> wrapper);
   	
   	LuquxinxiView selectView(@Param("ew") Wrapper<LuquxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LuquxinxiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<LuquxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<LuquxinxiEntity> wrapper);
    
    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<LuquxinxiEntity> wrapper);



}

