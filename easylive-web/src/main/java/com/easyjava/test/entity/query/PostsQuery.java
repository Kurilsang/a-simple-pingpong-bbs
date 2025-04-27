package com.easyjava.test.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class PostsQuery extends BaseParam {


	/**
	 * 帖子ID，唯一标识帖子
	 */
	private Integer postId;

	/**
	 * 发帖用户ID，关联users表的user_id
	 */
	private Integer userId;

	/**
	 * 所属板块ID，关联forums表的forum_id
	 */
	private Integer forumId;

	/**
	 * 帖子标题
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 帖子内容
	 */
	private String content;

	private String contentFuzzy;

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
	private String createdAt;

	private String createdAtStart;

	private String createdAtEnd;

	/**
	 * 帖子更新时间
	 */
	private String updatedAt;

	private String updatedAtStart;

	private String updatedAtEnd;


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

	public void setTitleFuzzy(String titleFuzzy){
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy(){
		return this.titleFuzzy;
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

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return this.updatedAt;
	}

	public void setUpdatedAtStart(String updatedAtStart){
		this.updatedAtStart = updatedAtStart;
	}

	public String getUpdatedAtStart(){
		return this.updatedAtStart;
	}
	public void setUpdatedAtEnd(String updatedAtEnd){
		this.updatedAtEnd = updatedAtEnd;
	}

	public String getUpdatedAtEnd(){
		return this.updatedAtEnd;
	}

}
