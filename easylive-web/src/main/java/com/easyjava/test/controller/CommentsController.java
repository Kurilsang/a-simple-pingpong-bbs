package com.easyjava.test.controller;

import java.util.List;

import com.easyjava.test.entity.query.CommentsQuery;
import com.easyjava.test.entity.po.Comments;
import com.easyjava.test.entity.vo.ResponseVO;
import com.easyjava.test.service.CommentsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("commentsController")
@RequestMapping("/comments")
public class CommentsController extends ABaseController{

	@Resource
	private CommentsService commentsService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(CommentsQuery query){
		return getSuccessResponseVO(commentsService.findListByPage(query));
	}
	@RequestMapping("/loadCommentsList")
	public ResponseVO loadCommentsList(CommentsQuery query){
		return getSuccessResponseVO(commentsService.findCommentsListByPage(query));
	}

	/**
	 * 新增
	 */
		@RequestMapping("/add")
	public ResponseVO add(@RequestBody Comments bean) {
		commentsService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Comments> listBean) {
		commentsService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Comments> listBean) {
		commentsService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据CommentId查询对象
	 */
	@RequestMapping("/getCommentsByCommentId")
	public ResponseVO getCommentsByCommentId(Integer commentId) {
		return getSuccessResponseVO(commentsService.getCommentsByCommentId(commentId));
	}

	/**
	 * 根据CommentId修改对象
	 */
	@RequestMapping("/updateCommentsByCommentId/{commentId}")
	public ResponseVO updateCommentsByCommentId(@RequestBody Comments bean,
												@PathVariable Integer commentId) {
		commentsService.updateCommentsByCommentId(bean,commentId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据CommentId删除
	 */
	@RequestMapping("/deleteCommentsByCommentId")
	public ResponseVO deleteCommentsByCommentId(Integer commentId) {
		commentsService.deleteCommentsByCommentId(commentId);
		return getSuccessResponseVO(null);
	}
}