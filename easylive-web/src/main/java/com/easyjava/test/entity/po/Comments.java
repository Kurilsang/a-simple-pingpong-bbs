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
public class Comments implements Serializable {


	/**
	 * 评论ID，唯一标识评论
	 */
	private Integer commentId;

	/**
	 * 所属帖子ID，关联posts表的post_id
	 */
	private Integer postId;

	/**
	 * 评论用户ID，关联users表的user_id
	 */
	private String userId;

	/**
	 * 父评论ID，用于回复评论，关联comments表的comment_id
	 */
	private Integer parentCommentId;

	/**
	 * 评论内容
	 */
	private String content;

	/**
	 * 评论创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastChange;

	public void setCommentId(Integer commentId){
		this.commentId = commentId;
	}

	public Integer getCommentId(){
		return this.commentId;
	}

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

	public void setParentCommentId(Integer parentCommentId){
		this.parentCommentId = parentCommentId;
	}

	public Integer getParentCommentId(){
		return this.parentCommentId;
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
		return "评论ID，唯一标识评论:"+(commentId == null ? "空" : commentId)+"，所属帖子ID，关联posts表的post_id:"+(postId == null ? "空" : postId)+"，评论用户ID，关联users表的user_id:"+(userId == null ? "空" : userId)+"，父评论ID，用于回复评论，关联comments表的comment_id:"+(parentCommentId == null ? "空" : parentCommentId)+"，评论内容:"+(content == null ? "空" : content)+"，评论创建时间:"+(createdAt == null ? "空" : DateUtil.format(createdAt, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }
}
