package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussgaoxiaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussgaoxiaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussgaoxiaoxinxiView;


/**
 * 高校信息评论表
 *
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public interface DiscussgaoxiaoxinxiService extends IService<DiscussgaoxiaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussgaoxiaoxinxiVO> selectListVO(Wrapper<DiscussgaoxiaoxinxiEntity> wrapper);
   	
   	DiscussgaoxiaoxinxiVO selectVO(@Param("ew") Wrapper<DiscussgaoxiaoxinxiEntity> wrapper);
   	
   	List<DiscussgaoxiaoxinxiView> selectListView(Wrapper<DiscussgaoxiaoxinxiEntity> wrapper);
   	
   	DiscussgaoxiaoxinxiView selectView(@Param("ew") Wrapper<DiscussgaoxiaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussgaoxiaoxinxiEntity> wrapper);
   	

}

