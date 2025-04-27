package com.easyjava.test.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class PrivateMessagesQuery extends BaseParam {


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

	private String contentFuzzy;

	/**
	 * 私信发送时间
	 */
	private String createdAt;

	private String createdAtStart;

	private String createdAtEnd;

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

	public void setIsRead(Integer isRead){
		this.isRead = isRead;
	}

	public Integer getIsRead(){
		return this.isRead;
	}

}
