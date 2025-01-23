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

import com.entity.DiscussgaoxiaoxinxiEntity;
import com.entity.view.DiscussgaoxiaoxinxiView;

import com.service.DiscussgaoxiaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 高校信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
@RestController
@RequestMapping("/discussgaoxiaoxinxi")
public class DiscussgaoxiaoxinxiController {
    @Autowired
    private DiscussgaoxiaoxinxiService discussgaoxiaoxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussgaoxiaoxinxiEntity discussgaoxiaoxinxi, 
		HttpServletRequest request){

        EntityWrapper<DiscussgaoxiaoxinxiEntity> ew = new EntityWrapper<DiscussgaoxiaoxinxiEntity>();

    	PageUtils page = discussgaoxiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussgaoxiaoxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussgaoxiaoxinxiEntity discussgaoxiaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussgaoxiaoxinxiEntity> ew = new EntityWrapper<DiscussgaoxiaoxinxiEntity>();

    	PageUtils page = discussgaoxiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussgaoxiaoxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussgaoxiaoxinxiEntity discussgaoxiaoxinxi){
       	EntityWrapper<DiscussgaoxiaoxinxiEntity> ew = new EntityWrapper<DiscussgaoxiaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussgaoxiaoxinxi, "discussgaoxiaoxinxi")); 
        return R.ok().put("data", discussgaoxiaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussgaoxiaoxinxiEntity discussgaoxiaoxinxi){
        EntityWrapper< DiscussgaoxiaoxinxiEntity> ew = new EntityWrapper< DiscussgaoxiaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussgaoxiaoxinxi, "discussgaoxiaoxinxi")); 
		DiscussgaoxiaoxinxiView discussgaoxiaoxinxiView =  discussgaoxiaoxinxiService.selectView(ew);
		return R.ok("查询高校信息评论表成功").put("data", discussgaoxiaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussgaoxiaoxinxiEntity discussgaoxiaoxinxi = discussgaoxiaoxinxiService.selectById(id);
        return R.ok().put("data", discussgaoxiaoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussgaoxiaoxinxiEntity discussgaoxiaoxinxi = discussgaoxiaoxinxiService.selectById(id);
        return R.ok().put("data", discussgaoxiaoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussgaoxiaoxinxiEntity discussgaoxiaoxinxi, HttpServletRequest request){
    	discussgaoxiaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussgaoxiaoxinxi);

        discussgaoxiaoxinxiService.insert(discussgaoxiaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussgaoxiaoxinxiEntity discussgaoxiaoxinxi, HttpServletRequest request){
    	discussgaoxiaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussgaoxiaoxinxi);

        discussgaoxiaoxinxiService.insert(discussgaoxiaoxinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussgaoxiaoxinxiEntity discussgaoxiaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussgaoxiaoxinxi);
        discussgaoxiaoxinxiService.updateById(discussgaoxiaoxinxi);//全部更新
        return R.ok();
    }

    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussgaoxiaoxinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscussgaoxiaoxinxiEntity> wrapper = new EntityWrapper<DiscussgaoxiaoxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussgaoxiaoxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	








}
