package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GaoxiaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GaoxiaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GaoxiaoxinxiView;


/**
 * 高校信息
 *
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface GaoxiaoxinxiService extends IService<GaoxiaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GaoxiaoxinxiVO> selectListVO(Wrapper<GaoxiaoxinxiEntity> wrapper);
   	
   	GaoxiaoxinxiVO selectVO(@Param("ew") Wrapper<GaoxiaoxinxiEntity> wrapper);
   	
   	List<GaoxiaoxinxiView> selectListView(Wrapper<GaoxiaoxinxiEntity> wrapper);
   	
   	GaoxiaoxinxiView selectView(@Param("ew") Wrapper<GaoxiaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GaoxiaoxinxiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<GaoxiaoxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<GaoxiaoxinxiEntity> wrapper);
    
    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<GaoxiaoxinxiEntity> wrapper);



}

