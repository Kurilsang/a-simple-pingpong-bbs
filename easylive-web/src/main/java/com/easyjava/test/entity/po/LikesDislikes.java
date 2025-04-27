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
public class LikesDislikes implements Serializable {


	/**
	 * 记录ID，唯一标识点赞点踩记录
	 */
	private Integer id;

	/**
	 * 帖子ID，关联posts表的post_id
	 */
	private Integer postId;

	/**
	 * 评论ID，关联comments表的comment_id
	 */
	private Integer commentId;

	/**
	 * 操作用户ID，关联users表的user_id
	 */
	private Integer userId;

	/**
	 * 操作类型，1-点赞，2-点踩
	 */
	private Integer action;

	/**
	 * 操作时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setPostId(Integer postId){
		this.postId = postId;
	}

	public Integer getPostId(){
		return this.postId;
	}

	public void setCommentId(Integer commentId){
		this.commentId = commentId;
	}

	public Integer getCommentId(){
		return this.commentId;
	}

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setAction(Integer action){
		this.action = action;
	}

	public Integer getAction(){
		return this.action;
	}

	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	public Date getCreatedAt(){
		return this.createdAt;
	}

	@Override
	public String toString (){
		return "记录ID，唯一标识点赞点踩记录:"+(id == null ? "空" : id)+"，帖子ID，关联posts表的post_id:"+(postId == null ? "空" : postId)+"，评论ID，关联comments表的comment_id:"+(commentId == null ? "空" : commentId)+"，操作用户ID，关联users表的user_id:"+(userId == null ? "空" : userId)+"，操作类型，1-点赞，2-点踩:"+(action == null ? "空" : action)+"，操作时间:"+(createdAt == null ? "空" : DateUtil.format(createdAt, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
