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


import com.dao.DiscusszhuanyejianxunDao;
import com.entity.DiscusszhuanyejianxunEntity;
import com.service.DiscusszhuanyejianxunService;
import com.entity.vo.DiscusszhuanyejianxunVO;
import com.entity.view.DiscusszhuanyejianxunView;

@Service("discusszhuanyejianxunService")
public class DiscusszhuanyejianxunServiceImpl extends ServiceImpl<DiscusszhuanyejianxunDao, DiscusszhuanyejianxunEntity> implements DiscusszhuanyejianxunService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhuanyejianxunEntity> page = this.selectPage(
                new Query<DiscusszhuanyejianxunEntity>(params).getPage(),
                new EntityWrapper<DiscusszhuanyejianxunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhuanyejianxunEntity> wrapper) {
		  Page<DiscusszhuanyejianxunView> page =new Query<DiscusszhuanyejianxunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszhuanyejianxunVO> selectListVO(Wrapper<DiscusszhuanyejianxunEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhuanyejianxunVO selectVO(Wrapper<DiscusszhuanyejianxunEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhuanyejianxunView> selectListView(Wrapper<DiscusszhuanyejianxunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhuanyejianxunView selectView(Wrapper<DiscusszhuanyejianxunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
