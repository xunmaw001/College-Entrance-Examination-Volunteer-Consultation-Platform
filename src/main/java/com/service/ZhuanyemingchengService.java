package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuanyemingchengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhuanyemingchengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuanyemingchengView;


/**
 * 专业名称
 *
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface ZhuanyemingchengService extends IService<ZhuanyemingchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuanyemingchengVO> selectListVO(Wrapper<ZhuanyemingchengEntity> wrapper);
   	
   	ZhuanyemingchengVO selectVO(@Param("ew") Wrapper<ZhuanyemingchengEntity> wrapper);
   	
   	List<ZhuanyemingchengView> selectListView(Wrapper<ZhuanyemingchengEntity> wrapper);
   	
   	ZhuanyemingchengView selectView(@Param("ew") Wrapper<ZhuanyemingchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhuanyemingchengEntity> wrapper);
   	

}

