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
public class Posts implements Serializable {


	/**
	 * 帖子ID，唯一标识帖子
	 */
	private Integer postId;

	/**
	 * 发帖用户ID，关联users表的user_id
	 */
	private String userId;

	/**
	 * 所属板块ID，关联forums表的forum_id
	 */
	private Integer forumId;

	/**
	 * 帖子标题
	 */
	private String title;

	/**
	 * 帖子内容
	 */
	private String content;

	/**
	 * 是否为精华帖，0-否，1-是
	 */
	private Integer isEssence;

	/**
	 * 是否置顶，0-否，1-是
	 */
	private Integer isSticky;

	/**
	 * 帖子创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;

	/**
	 * 帖子更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedAt;


	public void setPostId(Integer postId){
		this.postId = postId;
	}

	public Integer getPostId(){
		return this.postId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return this.userId;
	}

	public void setForumId(Integer forumId){
		this.forumId = forumId;
	}

	public Integer getForumId(){
		return this.forumId;
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

	public void setIsEssence(Integer isEssence){
		this.isEssence = isEssence;
	}

	public Integer getIsEssence(){
		return this.isEssence;
	}

	public void setIsSticky(Integer isSticky){
		this.isSticky = isSticky;
	}

	public Integer getIsSticky(){
		return this.isSticky;
	}

	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	public Date getCreatedAt(){
		return this.createdAt;
	}

	public void setUpdatedAt(Date updatedAt){
		this.updatedAt = updatedAt;
	}

	public Date getUpdatedAt(){
		return this.updatedAt;
	}

	@Override
	public String toString (){
		return "帖子ID，唯一标识帖子:"+(postId == null ? "空" : postId)+"，发帖用户ID，关联users表的user_id:"+(userId == null ? "空" : userId)+"，所属板块ID，关联forums表的forum_id:"+(forumId == null ? "空" : forumId)+"，帖子标题:"+(title == null ? "空" : title)+"，帖子内容:"+(content == null ? "空" : content)+"，是否为精华帖，0-否，1-是:"+(isEssence == null ? "空" : isEssence)+"，是否置顶，0-否，1-是:"+(isSticky == null ? "空" : isSticky)+"，帖子创建时间:"+(createdAt == null ? "空" : DateUtil.format(createdAt, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，帖子更新时间:"+(updatedAt == null ? "空" : DateUtil.format(updatedAt, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
