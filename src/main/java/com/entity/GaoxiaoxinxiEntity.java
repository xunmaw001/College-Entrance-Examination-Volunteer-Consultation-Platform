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
 * 高校信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-10 20:47:20
 */
@TableName("gaoxiaoxinxi")
public class GaoxiaoxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GaoxiaoxinxiEntity() {
		
	}
	
	public GaoxiaoxinxiEntity(T t) {
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
	 * 高校地址
	 */
					
	private String gaoxiaodizhi;
	
	/**
	 * 院校类型
	 */
					
	private String yuanxiaoleixing;
	
	/**
	 * 官方网址
	 */
					
	private String guanfangwangzhi;
	
	/**
	 * 办学类型
	 */
					
	private String banxueleixing;
	
	/**
	 * 封面图片
	 */
					
	private String fengmiantupian;
	
	/**
	 * 学校概况
	 */
					
	private String xuexiaogaikuang;
	
	/**
	 * 师资队伍
	 */
					
	private String shiziduiwu;
	
	/**
	 * 环境介绍
	 */
					
	private String huanjingjieshao;
	
	/**
	 * 历年分数线
	 */
					
	private String linianfenshuxian;
	
	/**
	 * 人才培养
	 */
					
	private String rencaipeiyang;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	
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
	 * 设置：院校类型
	 */
	public void setYuanxiaoleixing(String yuanxiaoleixing) {
		this.yuanxiaoleixing = yuanxiaoleixing;
	}
	/**
	 * 获取：院校类型
	 */
	public String getYuanxiaoleixing() {
		return yuanxiaoleixing;
	}
	/**
	 * 设置：官方网址
	 */
	public void setGuanfangwangzhi(String guanfangwangzhi) {
		this.guanfangwangzhi = guanfangwangzhi;
	}
	/**
	 * 获取：官方网址
	 */
	public String getGuanfangwangzhi() {
		return guanfangwangzhi;
	}
	/**
	 * 设置：办学类型
	 */
	public void setBanxueleixing(String banxueleixing) {
		this.banxueleixing = banxueleixing;
	}
	/**
	 * 获取：办学类型
	 */
	public String getBanxueleixing() {
		return banxueleixing;
	}
	/**
	 * 设置：封面图片
	 */
	public void setFengmiantupian(String fengmiantupian) {
		this.fengmiantupian = fengmiantupian;
	}
	/**
	 * 获取：封面图片
	 */
	public String getFengmiantupian() {
		return fengmiantupian;
	}
	/**
	 * 设置：学校概况
	 */
	public void setXuexiaogaikuang(String xuexiaogaikuang) {
		this.xuexiaogaikuang = xuexiaogaikuang;
	}
	/**
	 * 获取：学校概况
	 */
	public String getXuexiaogaikuang() {
		return xuexiaogaikuang;
	}
	/**
	 * 设置：师资队伍
	 */
	public void setShiziduiwu(String shiziduiwu) {
		this.shiziduiwu = shiziduiwu;
	}
	/**
	 * 获取：师资队伍
	 */
	public String getShiziduiwu() {
		return shiziduiwu;
	}
	/**
	 * 设置：环境介绍
	 */
	public void setHuanjingjieshao(String huanjingjieshao) {
		this.huanjingjieshao = huanjingjieshao;
	}
	/**
	 * 获取：环境介绍
	 */
	public String getHuanjingjieshao() {
		return huanjingjieshao;
	}
	/**
	 * 设置：历年分数线
	 */
	public void setLinianfenshuxian(String linianfenshuxian) {
		this.linianfenshuxian = linianfenshuxian;
	}
	/**
	 * 获取：历年分数线
	 */
	public String getLinianfenshuxian() {
		return linianfenshuxian;
	}
	/**
	 * 设置：人才培养
	 */
	public void setRencaipeiyang(String rencaipeiyang) {
		this.rencaipeiyang = rencaipeiyang;
	}
	/**
	 * 获取：人才培养
	 */
	public String getRencaipeiyang() {
		return rencaipeiyang;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}

}
