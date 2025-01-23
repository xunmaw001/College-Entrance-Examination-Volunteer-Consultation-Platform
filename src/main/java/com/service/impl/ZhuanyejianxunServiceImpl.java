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


import com.dao.ZhuanyejianxunDao;
import com.entity.ZhuanyejianxunEntity;
import com.service.ZhuanyejianxunService;
import com.entity.vo.ZhuanyejianxunVO;
import com.entity.view.ZhuanyejianxunView;

@Service("zhuanyejianxunService")
public class ZhuanyejianxunServiceImpl extends ServiceImpl<ZhuanyejianxunDao, ZhuanyejianxunEntity> implements ZhuanyejianxunService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuanyejianxunEntity> page = this.selectPage(
                new Query<ZhuanyejianxunEntity>(params).getPage(),
                new EntityWrapper<ZhuanyejianxunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuanyejianxunEntity> wrapper) {
		  Page<ZhuanyejianxunView> page =new Query<ZhuanyejianxunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhuanyejianxunVO> selectListVO(Wrapper<ZhuanyejianxunEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuanyejianxunVO selectVO(Wrapper<ZhuanyejianxunEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuanyejianxunView> selectListView(Wrapper<ZhuanyejianxunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuanyejianxunView selectView(Wrapper<ZhuanyejianxunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
