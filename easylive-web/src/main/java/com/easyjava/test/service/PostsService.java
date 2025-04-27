package com.easyjava.test.service;

import java.util.List;

import com.easyjava.test.entity.query.PostsQuery;
import com.easyjava.test.entity.po.Posts;
import com.easyjava.test.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface PostsService {

	/**
	 * 根据条件查询列表
	 */
	List<Posts> findListByParam(PostsQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(PostsQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Posts> findListByPage(PostsQuery param);

	/**
	 * 新增
	 */
	Integer add(Posts bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Posts> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Posts> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Posts bean,PostsQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(PostsQuery param);

	/**
	 * 根据PostId查询对象
	 */
	Posts getPostsByPostId(Integer postId);


	/**
	 * 根据PostId修改
	 */
	Integer updatePostsByPostId(Posts bean,Integer postId);


	/**
	 * 根据PostId删除
	 */
	Integer deletePostsByPostId(Integer postId);

}