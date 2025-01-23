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


import com.dao.DiscussluquxinxiDao;
import com.entity.DiscussluquxinxiEntity;
import com.service.DiscussluquxinxiService;
import com.entity.vo.DiscussluquxinxiVO;
import com.entity.view.DiscussluquxinxiView;

@Service("discussluquxinxiService")
public class DiscussluquxinxiServiceImpl extends ServiceImpl<DiscussluquxinxiDao, DiscussluquxinxiEntity> implements DiscussluquxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussluquxinxiEntity> page = this.selectPage(
                new Query<DiscussluquxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussluquxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussluquxinxiEntity> wrapper) {
		  Page<DiscussluquxinxiView> page =new Query<DiscussluquxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussluquxinxiVO> selectListVO(Wrapper<DiscussluquxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussluquxinxiVO selectVO(Wrapper<DiscussluquxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussluquxinxiView> selectListView(Wrapper<DiscussluquxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussluquxinxiView selectView(Wrapper<DiscussluquxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
