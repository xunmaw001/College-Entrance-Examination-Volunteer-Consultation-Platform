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


import com.dao.LuqufenshuDao;
import com.entity.LuqufenshuEntity;
import com.service.LuqufenshuService;
import com.entity.vo.LuqufenshuVO;
import com.entity.view.LuqufenshuView;

@Service("luqufenshuService")
public class LuqufenshuServiceImpl extends ServiceImpl<LuqufenshuDao, LuqufenshuEntity> implements LuqufenshuService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LuqufenshuEntity> page = this.selectPage(
                new Query<LuqufenshuEntity>(params).getPage(),
                new EntityWrapper<LuqufenshuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LuqufenshuEntity> wrapper) {
		  Page<LuqufenshuView> page =new Query<LuqufenshuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LuqufenshuVO> selectListVO(Wrapper<LuqufenshuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LuqufenshuVO selectVO(Wrapper<LuqufenshuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LuqufenshuView> selectListView(Wrapper<LuqufenshuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LuqufenshuView selectView(Wrapper<LuqufenshuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
