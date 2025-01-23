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


import com.dao.DiscusszhaoshengjianzhangDao;
import com.entity.DiscusszhaoshengjianzhangEntity;
import com.service.DiscusszhaoshengjianzhangService;
import com.entity.vo.DiscusszhaoshengjianzhangVO;
import com.entity.view.DiscusszhaoshengjianzhangView;

@Service("discusszhaoshengjianzhangService")
public class DiscusszhaoshengjianzhangServiceImpl extends ServiceImpl<DiscusszhaoshengjianzhangDao, DiscusszhaoshengjianzhangEntity> implements DiscusszhaoshengjianzhangService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhaoshengjianzhangEntity> page = this.selectPage(
                new Query<DiscusszhaoshengjianzhangEntity>(params).getPage(),
                new EntityWrapper<DiscusszhaoshengjianzhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhaoshengjianzhangEntity> wrapper) {
		  Page<DiscusszhaoshengjianzhangView> page =new Query<DiscusszhaoshengjianzhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszhaoshengjianzhangVO> selectListVO(Wrapper<DiscusszhaoshengjianzhangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhaoshengjianzhangVO selectVO(Wrapper<DiscusszhaoshengjianzhangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhaoshengjianzhangView> selectListView(Wrapper<DiscusszhaoshengjianzhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhaoshengjianzhangView selectView(Wrapper<DiscusszhaoshengjianzhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
