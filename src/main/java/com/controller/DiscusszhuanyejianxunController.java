package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscusszhuanyejianxunEntity;
import com.entity.view.DiscusszhuanyejianxunView;

import com.service.DiscusszhuanyejianxunService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 专业简讯评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
@RestController
@RequestMapping("/discusszhuanyejianxun")
public class DiscusszhuanyejianxunController {
    @Autowired
    private DiscusszhuanyejianxunService discusszhuanyejianxunService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusszhuanyejianxunEntity discusszhuanyejianxun, 
		HttpServletRequest request){

        EntityWrapper<DiscusszhuanyejianxunEntity> ew = new EntityWrapper<DiscusszhuanyejianxunEntity>();

    	PageUtils page = discusszhuanyejianxunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhuanyejianxun), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusszhuanyejianxunEntity discusszhuanyejianxun, 
		HttpServletRequest request){
        EntityWrapper<DiscusszhuanyejianxunEntity> ew = new EntityWrapper<DiscusszhuanyejianxunEntity>();

    	PageUtils page = discusszhuanyejianxunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhuanyejianxun), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusszhuanyejianxunEntity discusszhuanyejianxun){
       	EntityWrapper<DiscusszhuanyejianxunEntity> ew = new EntityWrapper<DiscusszhuanyejianxunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusszhuanyejianxun, "discusszhuanyejianxun")); 
        return R.ok().put("data", discusszhuanyejianxunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusszhuanyejianxunEntity discusszhuanyejianxun){
        EntityWrapper< DiscusszhuanyejianxunEntity> ew = new EntityWrapper< DiscusszhuanyejianxunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusszhuanyejianxun, "discusszhuanyejianxun")); 
		DiscusszhuanyejianxunView discusszhuanyejianxunView =  discusszhuanyejianxunService.selectView(ew);
		return R.ok("查询专业简讯评论表成功").put("data", discusszhuanyejianxunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusszhuanyejianxunEntity discusszhuanyejianxun = discusszhuanyejianxunService.selectById(id);
        return R.ok().put("data", discusszhuanyejianxun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusszhuanyejianxunEntity discusszhuanyejianxun = discusszhuanyejianxunService.selectById(id);
        return R.ok().put("data", discusszhuanyejianxun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusszhuanyejianxunEntity discusszhuanyejianxun, HttpServletRequest request){
    	discusszhuanyejianxun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhuanyejianxun);

        discusszhuanyejianxunService.insert(discusszhuanyejianxun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusszhuanyejianxunEntity discusszhuanyejianxun, HttpServletRequest request){
    	discusszhuanyejianxun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhuanyejianxun);

        discusszhuanyejianxunService.insert(discusszhuanyejianxun);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscusszhuanyejianxunEntity discusszhuanyejianxun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszhuanyejianxun);
        discusszhuanyejianxunService.updateById(discusszhuanyejianxun);//全部更新
        return R.ok();
    }

    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusszhuanyejianxunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscusszhuanyejianxunEntity> wrapper = new EntityWrapper<DiscusszhuanyejianxunEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discusszhuanyejianxunService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	








}
