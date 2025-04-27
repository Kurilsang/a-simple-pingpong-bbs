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
public class Announcements implements Serializable {


	/**
	 * 公告ID，唯一标识公告
	 */
	private Integer announcementId;

	/**
	 * 发布者ID，关联users表的user_id
	 */
	private Integer userId;

	/**
	 * 公告标题
	 */
	private String title;

	/**
	 * 公告内容
	 */
	private String content;

	/**
	 * 公告发布时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;


	public void setAnnouncementId(Integer announcementId){
		this.announcementId = announcementId;
	}

	public Integer getAnnouncementId(){
		return this.announcementId;
	}

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return this.content;
	}

	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	public Date getCreatedAt(){
		return this.createdAt;
	}

	@Override
	public String toString (){
		return "公告ID，唯一标识公告:"+(announcementId == null ? "空" : announcementId)+"，发布者ID，关联users表的user_id:"+(userId == null ? "空" : userId)+"，公告标题:"+(title == null ? "空" : title)+"，公告内容:"+(content == null ? "空" : content)+"，公告发布时间:"+(createdAt == null ? "空" : DateUtil.format(createdAt, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
