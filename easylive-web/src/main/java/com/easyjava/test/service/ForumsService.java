package com.easyjava.test.service;

import java.util.List;

import com.easyjava.test.entity.query.ForumsQuery;
import com.easyjava.test.entity.po.Forums;
import com.easyjava.test.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface ForumsService {

	/**
	 * 根据条件查询列表
	 */
	List<Forums> findListByParam(ForumsQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(ForumsQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Forums> findListByPage(ForumsQuery param);

	/**
	 * 新增
	 */
	Integer add(Forums bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Forums> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Forums> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Forums bean,ForumsQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(ForumsQuery param);

	/**
	 * 根据ForumId查询对象
	 */
	Forums getForumsByForumId(Integer forumId);


	/**
	 * 根据ForumId修改
	 */
	Integer updateForumsByForumId(Forums bean,Integer forumId);


	/**
	 * 根据ForumId删除
	 */
	Integer deleteForumsByForumId(Integer forumId);


	/**
	 * 根据ForumName查询对象
	 */
	Forums getForumsByForumName(String forumName);


	/**
	 * 根据ForumName修改
	 */
	Integer updateForumsByForumName(Forums bean,String forumName);


	/**
	 * 根据ForumName删除
	 */
	Integer deleteForumsByForumName(String forumName);

}