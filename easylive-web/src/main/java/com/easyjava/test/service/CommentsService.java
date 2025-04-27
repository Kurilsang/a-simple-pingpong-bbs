package com.easyjava.test.service;

import java.util.List;

import com.easyjava.test.entity.query.CommentsQuery;
import com.easyjava.test.entity.po.Comments;
import com.easyjava.test.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface CommentsService {

	/**
	 * 根据条件查询列表
	 */
	List<Comments> findListByParam(CommentsQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(CommentsQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Comments> findListByPage(CommentsQuery param);

	PaginationResultVO<Comments> findCommentsListByPage(CommentsQuery param);

	/**
	 * 新增
	 */
	Integer add(Comments bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Comments> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Comments> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Comments bean,CommentsQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(CommentsQuery param);

	/**
	 * 根据CommentId查询对象
	 */
	Comments getCommentsByCommentId(Integer commentId);


	/**
	 * 根据CommentId修改
	 */
	Integer updateCommentsByCommentId(Comments bean,Integer commentId);


	/**
	 * 根据CommentId删除
	 */
	Integer deleteCommentsByCommentId(Integer commentId);

}