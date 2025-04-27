package com.easyjava.test.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class UsersQuery extends BaseParam {


	/**
	 * 用户ID，唯一标识用户
	 */
	private Integer userId;

	/**
	 * 用户名，用于登录和显示
	 */
	private String username;

	private String usernameFuzzy;

	/**
	 * 用户密码，加密存储
	 */
	private String password;

	private String passwordFuzzy;

	/**
	 * 用户邮箱，用于注册和找回密码
	 */
	private String email;

	private String emailFuzzy;

	/**
	 * 用户资料，如个人简介等
	 */
	private String profile;

	private String profileFuzzy;

	/**
	 * 用户角色，1-普通用户，2-版主，3-管理员
	 */
	private Integer role;

	/**
	 * 用户注册时间
	 */
	private String createdAt;

	private String createdAtStart;

	private String createdAtEnd;


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

	public void setUsernameFuzzy(String usernameFuzzy){
		this.usernameFuzzy = usernameFuzzy;
	}

	public String getUsernameFuzzy(){
		return this.usernameFuzzy;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return this.password;
	}

	public void setPasswordFuzzy(String passwordFuzzy){
		this.passwordFuzzy = passwordFuzzy;
	}

	public String getPasswordFuzzy(){
		return this.passwordFuzzy;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmailFuzzy(String emailFuzzy){
		this.emailFuzzy = emailFuzzy;
	}

	public String getEmailFuzzy(){
		return this.emailFuzzy;
	}

	public void setProfile(String profile){
		this.profile = profile;
	}

	public String getProfile(){
		return this.profile;
	}

	public void setProfileFuzzy(String profileFuzzy){
		this.profileFuzzy = profileFuzzy;
	}

	public String getProfileFuzzy(){
		return this.profileFuzzy;
	}

	public void setRole(Integer role){
		this.role = role;
	}

	public Integer getRole(){
		return this.role;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return this.createdAt;
	}

	public void setCreatedAtStart(String createdAtStart){
		this.createdAtStart = createdAtStart;
	}

	public String getCreatedAtStart(){
		return this.createdAtStart;
	}
	public void setCreatedAtEnd(String createdAtEnd){
		this.createdAtEnd = createdAtEnd;
	}

	public String getCreatedAtEnd(){
		return this.createdAtEnd;
	}

}
