package com.easyjava.test.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class ForumsQuery extends BaseParam {


	/**
	 * 板块ID，唯一标识板块
	 */
	private Integer forumId;

	/**
	 * 板块名称，如技术交流、赛事资讯等
	 */
	private String forumName;

	private String forumNameFuzzy;

	/**
	 * 板块描述，介绍板块内容
	 */
	private String description;

	private String descriptionFuzzy;

	/**
	 * 板块创建时间
	 */
	private String createdAt;

	private String createdAtStart;

	private String createdAtEnd;

	private String updatedAt;


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

	public void setForumNameFuzzy(String forumNameFuzzy){
		this.forumNameFuzzy = forumNameFuzzy;
	}

	public String getForumNameFuzzy(){
		return this.forumNameFuzzy;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}

	public void setDescriptionFuzzy(String descriptionFuzzy){
		this.descriptionFuzzy = descriptionFuzzy;
	}

	public String getDescriptionFuzzy(){
		return this.descriptionFuzzy;
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

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
