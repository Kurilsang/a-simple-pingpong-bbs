package com.easyjava.test.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class ReportsQuery extends BaseParam {


	/**
	 * 举报ID，唯一标识举报记录
	 */
	private Integer reportId;

	/**
	 * 举报者ID，关联users表的user_id
	 */
	private Integer reporterId;

	/**
	 * 被举报帖子ID，关联posts表的post_id
	 */
	private Integer postId;

	/**
	 * 被举报评论ID，关联comments表的comment_id
	 */
	private Integer commentId;

	/**
	 * 举报原因
	 */
	private String reason;

	private String reasonFuzzy;

	/**
	 * 举报处理状态，0-未处理，1-已处理
	 */
	private Integer status;

	/**
	 * 举报时间
	 */
	private String createdAt;

	private String createdAtStart;

	private String createdAtEnd;


	public void setReportId(Integer reportId){
		this.reportId = reportId;
	}

	public Integer getReportId(){
		return this.reportId;
	}

	public void setReporterId(Integer reporterId){
		this.reporterId = reporterId;
	}

	public Integer getReporterId(){
		return this.reporterId;
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

	public void setReason(String reason){
		this.reason = reason;
	}

	public String getReason(){
		return this.reason;
	}

	public void setReasonFuzzy(String reasonFuzzy){
		this.reasonFuzzy = reasonFuzzy;
	}

	public String getReasonFuzzy(){
		return this.reasonFuzzy;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
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
