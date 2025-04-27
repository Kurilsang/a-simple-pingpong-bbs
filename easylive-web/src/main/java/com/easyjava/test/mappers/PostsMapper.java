package com.easyjava.test.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *  数据库操作接口
 */
public interface PostsMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据PostId更新
	 */
	 Integer updateByPostId(@Param("bean") T t,@Param("postId") Integer postId);


	/**
	 * 根据PostId删除
	 */
	 Integer deleteByPostId(@Param("postId") Integer postId);


	/**
	 * 根据PostId获取对象
	 */
	 T selectByPostId(@Param("postId") Integer postId);


}
