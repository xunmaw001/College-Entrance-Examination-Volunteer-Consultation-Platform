package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 专业简讯
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
@TableName("zhuanyejianxun")
public class ZhuanyejianxunEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhuanyejianxunEntity() {
		
	}
	
	public ZhuanyejianxunEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 高校名称
	 */
					
	private String gaoxiaomingcheng;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：高校名称
	 */
	public void setGaoxiaomingcheng(String gaoxiaomingcheng) {
		this.gaoxiaomingcheng = gaoxiaomingcheng;
	}
	/**
	 * 获取：高校名称
	 */
	public String getGaoxiaomingcheng() {
		return gaoxiaomingcheng;
	}
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
