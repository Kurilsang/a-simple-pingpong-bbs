package com.easyjava.test.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class LikesDislikesQuery extends BaseParam {


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
	private String createdAt;

	private String createdAtStart;

	private String createdAtEnd;


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
