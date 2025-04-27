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
public class PrivateMessages implements Serializable {


	/**
	 * 私信ID，唯一标识私信
	 */
	private Integer messageId;

	/**
	 * 发送者ID，关联users表的user_id
	 */
	private Integer senderId;

	/**
	 * 接收者ID，关联users表的user_id
	 */
	private Integer receiverId;

	/**
	 * 私信内容
	 */
	private String content;

	/**
	 * 私信发送时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;

	/**
	 * 是否已读，0-未读，1-已读
	 */
	private Integer isRead;


	public void setMessageId(Integer messageId){
		this.messageId = messageId;
	}

	public Integer getMessageId(){
		return this.messageId;
	}

	public void setSenderId(Integer senderId){
		this.senderId = senderId;
	}

	public Integer getSenderId(){
		return this.senderId;
	}

	public void setReceiverId(Integer receiverId){
		this.receiverId = receiverId;
	}

	public Integer getReceiverId(){
		return this.receiverId;
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

	public void setIsRead(Integer isRead){
		this.isRead = isRead;
	}

	public Integer getIsRead(){
		return this.isRead;
	}

	@Override
	public String toString (){
		return "私信ID，唯一标识私信:"+(messageId == null ? "空" : messageId)+"，发送者ID，关联users表的user_id:"+(senderId == null ? "空" : senderId)+"，接收者ID，关联users表的user_id:"+(receiverId == null ? "空" : receiverId)+"，私信内容:"+(content == null ? "空" : content)+"，私信发送时间:"+(createdAt == null ? "空" : DateUtil.format(createdAt, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，是否已读，0-未读，1-已读:"+(isRead == null ? "空" : isRead);
	}
}
