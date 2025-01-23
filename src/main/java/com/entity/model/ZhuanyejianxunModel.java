package com.entity.model;

import com.entity.ZhuanyejianxunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 专业简讯
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public class ZhuanyejianxunModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 专业名称
	 */
	
	private String zhuanyemingcheng;
		
	/**
	 * 专业封面
	 */
	
	private String zhuanyefengmian;
		
	/**
	 * 高校地址
	 */
	
	private String gaoxiaodizhi;
		
	/**
	 * 成立日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date chengliriqi;
		
	/**
	 * 成员人数
	 */
	
	private Integer chengyuanrenshu;
		
	/**
	 * 研究方向
	 */
	
	private String yanjiufangxiang;
		
	/**
	 * 专业内容
	 */
	
	private String zhuanyeneirong;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
				
	
	/**
	 * 设置：专业名称
	 */
	 
	public void setZhuanyemingcheng(String zhuanyemingcheng) {
		this.zhuanyemingcheng = zhuanyemingcheng;
	}
	
	/**
	 * 获取：专业名称
	 */
	public String getZhuanyemingcheng() {
		return zhuanyemingcheng;
	}
				
	
	/**
	 * 设置：专业封面
	 */
	 
	public void setZhuanyefengmian(String zhuanyefengmian) {
		this.zhuanyefengmian = zhuanyefengmian;
	}
	
	/**
	 * 获取：专业封面
	 */
	public String getZhuanyefengmian() {
		return zhuanyefengmian;
	}
				
	
	/**
	 * 设置：高校地址
	 */
	 
	public void setGaoxiaodizhi(String gaoxiaodizhi) {
		this.gaoxiaodizhi = gaoxiaodizhi;
	}
	
	/**
	 * 获取：高校地址
	 */
	public String getGaoxiaodizhi() {
		return gaoxiaodizhi;
	}
				
	
	/**
	 * 设置：成立日期
	 */
	 
	public void setChengliriqi(Date chengliriqi) {
		this.chengliriqi = chengliriqi;
	}
	
	/**
	 * 获取：成立日期
	 */
	public Date getChengliriqi() {
		return chengliriqi;
	}
				
	
	/**
	 * 设置：成员人数
	 */
	 
	public void setChengyuanrenshu(Integer chengyuanrenshu) {
		this.chengyuanrenshu = chengyuanrenshu;
	}
	
	/**
	 * 获取：成员人数
	 */
	public Integer getChengyuanrenshu() {
		return chengyuanrenshu;
	}
				
	
	/**
	 * 设置：研究方向
	 */
	 
	public void setYanjiufangxiang(String yanjiufangxiang) {
		this.yanjiufangxiang = yanjiufangxiang;
	}
	
	/**
	 * 获取：研究方向
	 */
	public String getYanjiufangxiang() {
		return yanjiufangxiang;
	}
				
	
	/**
	 * 设置：专业内容
	 */
	 
	public void setZhuanyeneirong(String zhuanyeneirong) {
		this.zhuanyeneirong = zhuanyeneirong;
	}
	
	/**
	 * 获取：专业内容
	 */
	public String getZhuanyeneirong() {
		return zhuanyeneirong;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
			
}
