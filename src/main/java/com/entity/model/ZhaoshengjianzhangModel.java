package com.entity.model;

import com.entity.ZhaoshengjianzhangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 招生简章
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
public class ZhaoshengjianzhangModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 招生标题
	 */
	
	private String zhaoshengbiaoti;
		
	/**
	 * 招生封面
	 */
	
	private String zhaoshengfengmian;
		
	/**
	 * 高校地址
	 */
	
	private String gaoxiaodizhi;
		
	/**
	 * 总则
	 */
	
	private String zongze;
		
	/**
	 * 组织机构
	 */
	
	private String zuzhijigou;
		
	/**
	 * 学历学位证书
	 */
	
	private String xuelixueweizhengshu;
		
	/**
	 * 收费及其它
	 */
	
	private String shoufeijiqita;
		
	/**
	 * 招生计划
	 */
	
	private String zhaoshengjihua;
		
	/**
	 * 录取原则
	 */
	
	private String luquyuanze;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
				
	
	/**
	 * 设置：招生标题
	 */
	 
	public void setZhaoshengbiaoti(String zhaoshengbiaoti) {
		this.zhaoshengbiaoti = zhaoshengbiaoti;
	}
	
	/**
	 * 获取：招生标题
	 */
	public String getZhaoshengbiaoti() {
		return zhaoshengbiaoti;
	}
				
	
	/**
	 * 设置：招生封面
	 */
	 
	public void setZhaoshengfengmian(String zhaoshengfengmian) {
		this.zhaoshengfengmian = zhaoshengfengmian;
	}
	
	/**
	 * 获取：招生封面
	 */
	public String getZhaoshengfengmian() {
		return zhaoshengfengmian;
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
	 * 设置：总则
	 */
	 
	public void setZongze(String zongze) {
		this.zongze = zongze;
	}
	
	/**
	 * 获取：总则
	 */
	public String getZongze() {
		return zongze;
	}
				
	
	/**
	 * 设置：组织机构
	 */
	 
	public void setZuzhijigou(String zuzhijigou) {
		this.zuzhijigou = zuzhijigou;
	}
	
	/**
	 * 获取：组织机构
	 */
	public String getZuzhijigou() {
		return zuzhijigou;
	}
				
	
	/**
	 * 设置：学历学位证书
	 */
	 
	public void setXuelixueweizhengshu(String xuelixueweizhengshu) {
		this.xuelixueweizhengshu = xuelixueweizhengshu;
	}
	
	/**
	 * 获取：学历学位证书
	 */
	public String getXuelixueweizhengshu() {
		return xuelixueweizhengshu;
	}
				
	
	/**
	 * 设置：收费及其它
	 */
	 
	public void setShoufeijiqita(String shoufeijiqita) {
		this.shoufeijiqita = shoufeijiqita;
	}
	
	/**
	 * 获取：收费及其它
	 */
	public String getShoufeijiqita() {
		return shoufeijiqita;
	}
				
	
	/**
	 * 设置：招生计划
	 */
	 
	public void setZhaoshengjihua(String zhaoshengjihua) {
		this.zhaoshengjihua = zhaoshengjihua;
	}
	
	/**
	 * 获取：招生计划
	 */
	public String getZhaoshengjihua() {
		return zhaoshengjihua;
	}
				
	
	/**
	 * 设置：录取原则
	 */
	 
	public void setLuquyuanze(String luquyuanze) {
		this.luquyuanze = luquyuanze;
	}
	
	/**
	 * 获取：录取原则
	 */
	public String getLuquyuanze() {
		return luquyuanze;
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
