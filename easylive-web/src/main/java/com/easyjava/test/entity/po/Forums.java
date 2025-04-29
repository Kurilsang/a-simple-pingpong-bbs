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
public class Forums implements Serializable {


	/**
	 * 板块ID，唯一标识板块
	 */
	private Integer forumId;

	/**
	 * 板块名称，如技术交流、赛事资讯等
	 */
	private String forumName;

	/**
	 * 板块描述，介绍板块内容
	 */
	private String description;

	/**
	 * 板块创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedAt;


	public void setForumId(Integer forumId){
		this.forumId = forumId;
	}

	public Integer getForumId(){
		return this.forumId;
	}

	public void setForumName(String forumName){
		this.forumName = forumName;
	}

	public String getForumName(){
		return this.forumName;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}

	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	public Date getCreatedAt(){
		return this.createdAt;
	}

	@Override
	public String toString (){
		return "板块ID，唯一标识板块:"+(forumId == null ? "空" : forumId)+"，板块名称，如技术交流、赛事资讯等:"+(forumName == null ? "空" : forumName)+"，板块描述，介绍板块内容:"+(description == null ? "空" : description)+"，板块创建时间:"+(createdAt == null ? "空" : DateUtil.format(createdAt, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
