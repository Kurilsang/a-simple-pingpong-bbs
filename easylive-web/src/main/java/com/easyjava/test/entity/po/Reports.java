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
public class Reports implements Serializable {


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

	/**
	 * 举报处理状态，0-未处理，1-已处理
	 */
	private Integer status;

	/**
	 * 举报时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;


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

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	public Date getCreatedAt(){
		return this.createdAt;
	}

	@Override
	public String toString (){
		return "举报ID，唯一标识举报记录:"+(reportId == null ? "空" : reportId)+"，举报者ID，关联users表的user_id:"+(reporterId == null ? "空" : reporterId)+"，被举报帖子ID，关联posts表的post_id:"+(postId == null ? "空" : postId)+"，被举报评论ID，关联comments表的comment_id:"+(commentId == null ? "空" : commentId)+"，举报原因:"+(reason == null ? "空" : reason)+"，举报处理状态，0-未处理，1-已处理:"+(status == null ? "空" : status)+"，举报时间:"+(createdAt == null ? "空" : DateUtil.format(createdAt, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
