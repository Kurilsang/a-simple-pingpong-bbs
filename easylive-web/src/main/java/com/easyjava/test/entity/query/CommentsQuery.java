package com.easyjava.test.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class CommentsQuery extends BaseParam {


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
	private Integer userId;

	/**
	 * 父评论ID，用于回复评论，关联comments表的comment_id
	 */
	private Integer parentCommentId;

	/**
	 * 评论内容
	 */
	private String content;

	private String contentFuzzy;

	/**
	 * 评论创建时间
	 */
	private String createdAt;

	private String createdAtStart;

	private String createdAtEnd;
  	private String lastChange;

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

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
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

    public String getLastChange() {
        return lastChange;
    }

    public void setLastChange(String lastChange) {
        this.lastChange = lastChange;
    }
}
