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

import com.entity.ZhuanyejianxunEntity;
import com.entity.view.ZhuanyejianxunView;

import com.service.ZhuanyejianxunService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 专业简讯
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
@RestController
@RequestMapping("/zhuanyejianxun")
public class ZhuanyejianxunController {
    @Autowired
    private ZhuanyejianxunService zhuanyejianxunService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhuanyejianxunEntity zhuanyejianxun, 
		HttpServletRequest request){

        EntityWrapper<ZhuanyejianxunEntity> ew = new EntityWrapper<ZhuanyejianxunEntity>();

    	PageUtils page = zhuanyejianxunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuanyejianxun), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhuanyejianxunEntity zhuanyejianxun, 
		HttpServletRequest request){
        EntityWrapper<ZhuanyejianxunEntity> ew = new EntityWrapper<ZhuanyejianxunEntity>();

    	PageUtils page = zhuanyejianxunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuanyejianxun), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhuanyejianxunEntity zhuanyejianxun){
       	EntityWrapper<ZhuanyejianxunEntity> ew = new EntityWrapper<ZhuanyejianxunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhuanyejianxun, "zhuanyejianxun")); 
        return R.ok().put("data", zhuanyejianxunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhuanyejianxunEntity zhuanyejianxun){
        EntityWrapper< ZhuanyejianxunEntity> ew = new EntityWrapper< ZhuanyejianxunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhuanyejianxun, "zhuanyejianxun")); 
		ZhuanyejianxunView zhuanyejianxunView =  zhuanyejianxunService.selectView(ew);
		return R.ok("查询专业简讯成功").put("data", zhuanyejianxunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhuanyejianxunEntity zhuanyejianxun = zhuanyejianxunService.selectById(id);
        return R.ok().put("data", zhuanyejianxun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhuanyejianxunEntity zhuanyejianxun = zhuanyejianxunService.selectById(id);
        return R.ok().put("data", zhuanyejianxun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhuanyejianxunEntity zhuanyejianxun, HttpServletRequest request){
    	zhuanyejianxun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhuanyejianxun);

        zhuanyejianxunService.insert(zhuanyejianxun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhuanyejianxunEntity zhuanyejianxun, HttpServletRequest request){
    	zhuanyejianxun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhuanyejianxun);

        zhuanyejianxunService.insert(zhuanyejianxun);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhuanyejianxunEntity zhuanyejianxun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhuanyejianxun);
        zhuanyejianxunService.updateById(zhuanyejianxun);//全部更新
        return R.ok();
    }

    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhuanyejianxunService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZhuanyejianxunEntity> wrapper = new EntityWrapper<ZhuanyejianxunEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = zhuanyejianxunService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	








}
