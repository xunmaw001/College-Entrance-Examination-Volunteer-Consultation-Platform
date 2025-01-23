package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussgaoxiaoxinxiDao;
import com.entity.DiscussgaoxiaoxinxiEntity;
import com.service.DiscussgaoxiaoxinxiService;
import com.entity.vo.DiscussgaoxiaoxinxiVO;
import com.entity.view.DiscussgaoxiaoxinxiView;

@Service("discussgaoxiaoxinxiService")
public class DiscussgaoxiaoxinxiServiceImpl extends ServiceImpl<DiscussgaoxiaoxinxiDao, DiscussgaoxiaoxinxiEntity> implements DiscussgaoxiaoxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussgaoxiaoxinxiEntity> page = this.selectPage(
                new Query<DiscussgaoxiaoxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussgaoxiaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussgaoxiaoxinxiEntity> wrapper) {
		  Page<DiscussgaoxiaoxinxiView> page =new Query<DiscussgaoxiaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussgaoxiaoxinxiVO> selectListVO(Wrapper<DiscussgaoxiaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussgaoxiaoxinxiVO selectVO(Wrapper<DiscussgaoxiaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussgaoxiaoxinxiView> selectListView(Wrapper<DiscussgaoxiaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussgaoxiaoxinxiView selectView(Wrapper<DiscussgaoxiaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
