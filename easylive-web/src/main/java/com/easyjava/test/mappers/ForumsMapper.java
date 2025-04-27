package com.easyjava.test.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *  数据库操作接口
 */
public interface ForumsMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据ForumId更新
	 */
	 Integer updateByForumId(@Param("bean") T t,@Param("forumId") Integer forumId);


	/**
	 * 根据ForumId删除
	 */
	 Integer deleteByForumId(@Param("forumId") Integer forumId);


	/**
	 * 根据ForumId获取对象
	 */
	 T selectByForumId(@Param("forumId") Integer forumId);


	/**
	 * 根据ForumName更新
	 */
	 Integer updateByForumName(@Param("bean") T t,@Param("forumName") String forumName);


	/**
	 * 根据ForumName删除
	 */
	 Integer deleteByForumName(@Param("forumName") String forumName);


	/**
	 * 根据ForumName获取对象
	 */
	 T selectByForumName(@Param("forumName") String forumName);


}
