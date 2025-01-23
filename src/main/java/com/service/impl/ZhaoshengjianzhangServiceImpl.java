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


import com.dao.ZhaoshengjianzhangDao;
import com.entity.ZhaoshengjianzhangEntity;
import com.service.ZhaoshengjianzhangService;
import com.entity.vo.ZhaoshengjianzhangVO;
import com.entity.view.ZhaoshengjianzhangView;

@Service("zhaoshengjianzhangService")
public class ZhaoshengjianzhangServiceImpl extends ServiceImpl<ZhaoshengjianzhangDao, ZhaoshengjianzhangEntity> implements ZhaoshengjianzhangService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaoshengjianzhangEntity> page = this.selectPage(
                new Query<ZhaoshengjianzhangEntity>(params).getPage(),
                new EntityWrapper<ZhaoshengjianzhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaoshengjianzhangEntity> wrapper) {
		  Page<ZhaoshengjianzhangView> page =new Query<ZhaoshengjianzhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhaoshengjianzhangVO> selectListVO(Wrapper<ZhaoshengjianzhangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhaoshengjianzhangVO selectVO(Wrapper<ZhaoshengjianzhangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhaoshengjianzhangView> selectListView(Wrapper<ZhaoshengjianzhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhaoshengjianzhangView selectView(Wrapper<ZhaoshengjianzhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
