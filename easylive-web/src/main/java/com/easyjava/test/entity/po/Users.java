package com.easyjava.test.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import com.easyjava.test.entity.enums.DateTimePatternEnum;
import com.easyjava.test.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * 
 */
public class Users implements Serializable {


	/**
	 * 用户ID，唯一标识用户
	 */
	private Integer userId;

	/**
	 * 用户名，用于登录和显示
	 */
	private String username;

	/**
	 * 用户密码，加密存储
	 */
	private String password;

	/**
	 * 用户邮箱，用于注册和找回密码
	 */
	private String email;

	/**
	 * 用户资料，如个人简介等
	 */
	private String profile;

	/**
	 * 用户角色，1-普通用户，2-版主，3-管理员
	 */
	private Integer role;

	/**
	 * 用户注册时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;


	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return this.username;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return this.password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return this.email;
	}

	public void setProfile(String profile){
		this.profile = profile;
	}

	public String getProfile(){
		return this.profile;
	}

	public void setRole(Integer role){
		this.role = role;
	}

	public Integer getRole(){
		return this.role;
	}

	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	public Date getCreatedAt(){
		return this.createdAt;
	}

	@Override
	public String toString (){
		return "用户ID，唯一标识用户:"+(userId == null ? "空" : userId)+"，用户名，用于登录和显示:"+(username == null ? "空" : username)+"，用户密码，加密存储:"+(password == null ? "空" : password)+"，用户邮箱，用于注册和找回密码:"+(email == null ? "空" : email)+"，用户资料，如个人简介等:"+(profile == null ? "空" : profile)+"，用户角色，1-普通用户，2-版主，3-管理员:"+(role == null ? "空" : role)+"，用户注册时间:"+(createdAt == null ? "空" : DateUtil.format(createdAt, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
