package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuanxiaoleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuanxiaoleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuanxiaoleixingView;


/**
 * 院校类型
 *
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface YuanxiaoleixingService extends IService<YuanxiaoleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuanxiaoleixingVO> selectListVO(Wrapper<YuanxiaoleixingEntity> wrapper);
   	
   	YuanxiaoleixingVO selectVO(@Param("ew") Wrapper<YuanxiaoleixingEntity> wrapper);
   	
   	List<YuanxiaoleixingView> selectListView(Wrapper<YuanxiaoleixingEntity> wrapper);
   	
   	YuanxiaoleixingView selectView(@Param("ew") Wrapper<YuanxiaoleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuanxiaoleixingEntity> wrapper);
   	

}

