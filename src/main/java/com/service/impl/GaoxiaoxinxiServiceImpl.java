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


import com.dao.GaoxiaoxinxiDao;
import com.entity.GaoxiaoxinxiEntity;
import com.service.GaoxiaoxinxiService;
import com.entity.vo.GaoxiaoxinxiVO;
import com.entity.view.GaoxiaoxinxiView;

@Service("gaoxiaoxinxiService")
public class GaoxiaoxinxiServiceImpl extends ServiceImpl<GaoxiaoxinxiDao, GaoxiaoxinxiEntity> implements GaoxiaoxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GaoxiaoxinxiEntity> page = this.selectPage(
                new Query<GaoxiaoxinxiEntity>(params).getPage(),
                new EntityWrapper<GaoxiaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GaoxiaoxinxiEntity> wrapper) {
		  Page<GaoxiaoxinxiView> page =new Query<GaoxiaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GaoxiaoxinxiVO> selectListVO(Wrapper<GaoxiaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GaoxiaoxinxiVO selectVO(Wrapper<GaoxiaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GaoxiaoxinxiView> selectListView(Wrapper<GaoxiaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GaoxiaoxinxiView selectView(Wrapper<GaoxiaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<GaoxiaoxinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<GaoxiaoxinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }
    
    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<GaoxiaoxinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
