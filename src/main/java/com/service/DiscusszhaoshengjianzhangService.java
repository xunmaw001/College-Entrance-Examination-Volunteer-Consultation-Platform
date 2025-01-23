package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszhaoshengjianzhangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszhaoshengjianzhangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszhaoshengjianzhangView;


/**
 * 招生简章评论表
 *
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface DiscusszhaoshengjianzhangService extends IService<DiscusszhaoshengjianzhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhaoshengjianzhangVO> selectListVO(Wrapper<DiscusszhaoshengjianzhangEntity> wrapper);
   	
   	DiscusszhaoshengjianzhangVO selectVO(@Param("ew") Wrapper<DiscusszhaoshengjianzhangEntity> wrapper);
   	
   	List<DiscusszhaoshengjianzhangView> selectListView(Wrapper<DiscusszhaoshengjianzhangEntity> wrapper);
   	
   	DiscusszhaoshengjianzhangView selectView(@Param("ew") Wrapper<DiscusszhaoshengjianzhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhaoshengjianzhangEntity> wrapper);
   	

}

