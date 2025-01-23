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

import com.entity.GaoxiaoxinxiEntity;
import com.entity.view.GaoxiaoxinxiView;

import com.service.GaoxiaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 高校信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
@RestController
@RequestMapping("/gaoxiaoxinxi")
public class GaoxiaoxinxiController {
    @Autowired
    private GaoxiaoxinxiService gaoxiaoxinxiService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GaoxiaoxinxiEntity gaoxiaoxinxi, 
		HttpServletRequest request){

        EntityWrapper<GaoxiaoxinxiEntity> ew = new EntityWrapper<GaoxiaoxinxiEntity>();

    	PageUtils page = gaoxiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gaoxiaoxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GaoxiaoxinxiEntity gaoxiaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<GaoxiaoxinxiEntity> ew = new EntityWrapper<GaoxiaoxinxiEntity>();

    	PageUtils page = gaoxiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gaoxiaoxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GaoxiaoxinxiEntity gaoxiaoxinxi){
       	EntityWrapper<GaoxiaoxinxiEntity> ew = new EntityWrapper<GaoxiaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gaoxiaoxinxi, "gaoxiaoxinxi")); 
        return R.ok().put("data", gaoxiaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GaoxiaoxinxiEntity gaoxiaoxinxi){
        EntityWrapper< GaoxiaoxinxiEntity> ew = new EntityWrapper< GaoxiaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gaoxiaoxinxi, "gaoxiaoxinxi")); 
		GaoxiaoxinxiView gaoxiaoxinxiView =  gaoxiaoxinxiService.selectView(ew);
		return R.ok("查询高校信息成功").put("data", gaoxiaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GaoxiaoxinxiEntity gaoxiaoxinxi = gaoxiaoxinxiService.selectById(id);
		gaoxiaoxinxi.setClicktime(new Date());
		gaoxiaoxinxiService.updateById(gaoxiaoxinxi);
        return R.ok().put("data", gaoxiaoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GaoxiaoxinxiEntity gaoxiaoxinxi = gaoxiaoxinxiService.selectById(id);
		gaoxiaoxinxi.setClicktime(new Date());
		gaoxiaoxinxiService.updateById(gaoxiaoxinxi);
        return R.ok().put("data", gaoxiaoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GaoxiaoxinxiEntity gaoxiaoxinxi, HttpServletRequest request){
    	gaoxiaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gaoxiaoxinxi);

        gaoxiaoxinxiService.insert(gaoxiaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GaoxiaoxinxiEntity gaoxiaoxinxi, HttpServletRequest request){
    	gaoxiaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gaoxiaoxinxi);

        gaoxiaoxinxiService.insert(gaoxiaoxinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GaoxiaoxinxiEntity gaoxiaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gaoxiaoxinxi);
        gaoxiaoxinxiService.updateById(gaoxiaoxinxi);//全部更新
        return R.ok();
    }

    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gaoxiaoxinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GaoxiaoxinxiEntity> wrapper = new EntityWrapper<GaoxiaoxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = gaoxiaoxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,GaoxiaoxinxiEntity gaoxiaoxinxi, HttpServletRequest request,String pre){
        EntityWrapper<GaoxiaoxinxiEntity> ew = new EntityWrapper<GaoxiaoxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = gaoxiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gaoxiaoxinxi), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,GaoxiaoxinxiEntity gaoxiaoxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "yuanxiaoleixing";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "gaoxiaoxinxi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<GaoxiaoxinxiEntity> gaoxiaoxinxiList = new ArrayList<GaoxiaoxinxiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                gaoxiaoxinxiList.addAll(gaoxiaoxinxiService.selectList(new EntityWrapper<GaoxiaoxinxiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<GaoxiaoxinxiEntity> ew = new EntityWrapper<GaoxiaoxinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = gaoxiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gaoxiaoxinxi), params), params));
        List<GaoxiaoxinxiEntity> pageList = (List<GaoxiaoxinxiEntity>)page.getList();
        if(gaoxiaoxinxiList.size()<limit) {
            int toAddNum = (limit-gaoxiaoxinxiList.size())<=pageList.size()?(limit-gaoxiaoxinxiList.size()):pageList.size();
            for(GaoxiaoxinxiEntity o1 : pageList) {
                boolean addFlag = true;
                for(GaoxiaoxinxiEntity o2 : gaoxiaoxinxiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    gaoxiaoxinxiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(gaoxiaoxinxiList.size()>limit) {
            gaoxiaoxinxiList = gaoxiaoxinxiList.subList(0, limit);
        }
        page.setList(gaoxiaoxinxiList);
        return R.ok().put("data", page);
    }




    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<GaoxiaoxinxiEntity> ew = new EntityWrapper<GaoxiaoxinxiEntity>();
        List<Map<String, Object>> result = gaoxiaoxinxiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<GaoxiaoxinxiEntity> ew = new EntityWrapper<GaoxiaoxinxiEntity>();
        List<Map<String, Object>> result = gaoxiaoxinxiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }
    
    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<GaoxiaoxinxiEntity> ew = new EntityWrapper<GaoxiaoxinxiEntity>();
        List<Map<String, Object>> result = gaoxiaoxinxiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,GaoxiaoxinxiEntity gaoxiaoxinxi, HttpServletRequest request){
        EntityWrapper<GaoxiaoxinxiEntity> ew = new EntityWrapper<GaoxiaoxinxiEntity>();
        int count = gaoxiaoxinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gaoxiaoxinxi), params), params));
        return R.ok().put("data", count);
    }


}
