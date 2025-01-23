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


import com.dao.ZhuanyemingchengDao;
import com.entity.ZhuanyemingchengEntity;
import com.service.ZhuanyemingchengService;
import com.entity.vo.ZhuanyemingchengVO;
import com.entity.view.ZhuanyemingchengView;

@Service("zhuanyemingchengService")
public class ZhuanyemingchengServiceImpl extends ServiceImpl<ZhuanyemingchengDao, ZhuanyemingchengEntity> implements ZhuanyemingchengService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuanyemingchengEntity> page = this.selectPage(
                new Query<ZhuanyemingchengEntity>(params).getPage(),
                new EntityWrapper<ZhuanyemingchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuanyemingchengEntity> wrapper) {
		  Page<ZhuanyemingchengView> page =new Query<ZhuanyemingchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhuanyemingchengVO> selectListVO(Wrapper<ZhuanyemingchengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuanyemingchengVO selectVO(Wrapper<ZhuanyemingchengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuanyemingchengView> selectListView(Wrapper<ZhuanyemingchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuanyemingchengView selectView(Wrapper<ZhuanyemingchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
