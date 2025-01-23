package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuanyejianxunEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhuanyejianxunVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuanyejianxunView;


/**
 * 专业简讯
 *
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface ZhuanyejianxunService extends IService<ZhuanyejianxunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuanyejianxunVO> selectListVO(Wrapper<ZhuanyejianxunEntity> wrapper);
   	
   	ZhuanyejianxunVO selectVO(@Param("ew") Wrapper<ZhuanyejianxunEntity> wrapper);
   	
   	List<ZhuanyejianxunView> selectListView(Wrapper<ZhuanyejianxunEntity> wrapper);
   	
   	ZhuanyejianxunView selectView(@Param("ew") Wrapper<ZhuanyejianxunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhuanyejianxunEntity> wrapper);
   	

}

