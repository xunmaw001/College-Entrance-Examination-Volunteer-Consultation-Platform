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


import com.dao.YuanxiaoleixingDao;
import com.entity.YuanxiaoleixingEntity;
import com.service.YuanxiaoleixingService;
import com.entity.vo.YuanxiaoleixingVO;
import com.entity.view.YuanxiaoleixingView;

@Service("yuanxiaoleixingService")
public class YuanxiaoleixingServiceImpl extends ServiceImpl<YuanxiaoleixingDao, YuanxiaoleixingEntity> implements YuanxiaoleixingService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuanxiaoleixingEntity> page = this.selectPage(
                new Query<YuanxiaoleixingEntity>(params).getPage(),
                new EntityWrapper<YuanxiaoleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuanxiaoleixingEntity> wrapper) {
		  Page<YuanxiaoleixingView> page =new Query<YuanxiaoleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuanxiaoleixingVO> selectListVO(Wrapper<YuanxiaoleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuanxiaoleixingVO selectVO(Wrapper<YuanxiaoleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuanxiaoleixingView> selectListView(Wrapper<YuanxiaoleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuanxiaoleixingView selectView(Wrapper<YuanxiaoleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
