package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhaoshengjianzhangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhaoshengjianzhangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhaoshengjianzhangView;


/**
 * 招生简章
 *
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface ZhaoshengjianzhangService extends IService<ZhaoshengjianzhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhaoshengjianzhangVO> selectListVO(Wrapper<ZhaoshengjianzhangEntity> wrapper);
   	
   	ZhaoshengjianzhangVO selectVO(@Param("ew") Wrapper<ZhaoshengjianzhangEntity> wrapper);
   	
   	List<ZhaoshengjianzhangView> selectListView(Wrapper<ZhaoshengjianzhangEntity> wrapper);
   	
   	ZhaoshengjianzhangView selectView(@Param("ew") Wrapper<ZhaoshengjianzhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhaoshengjianzhangEntity> wrapper);
   	

}

