package com.easyjava.test.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class AnnouncementsQuery extends BaseParam {


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

	private String titleFuzzy;

	/**
	 * 公告内容
	 */
	private String content;

	private String contentFuzzy;

	/**
	 * 公告发布时间
	 */
	private String createdAt;

	private String createdAtStart;

	private String createdAtEnd;


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

	public void setTitleFuzzy(String titleFuzzy){
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy(){
		return this.titleFuzzy;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return this.content;
	}

	public void setContentFuzzy(String contentFuzzy){
		this.contentFuzzy = contentFuzzy;
	}

	public String getContentFuzzy(){
		return this.contentFuzzy;
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
