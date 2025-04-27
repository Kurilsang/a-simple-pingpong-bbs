package com.easyjava.test.controller;

import java.util.List;

import com.easyjava.test.entity.query.PostsQuery;
import com.easyjava.test.entity.po.Posts;
import com.easyjava.test.entity.vo.ResponseVO;
import com.easyjava.test.service.PostsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("postsController")
@RequestMapping("/posts")
public class PostsController extends ABaseController{

	@Resource
	private PostsService postsService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(PostsQuery query){
		return getSuccessResponseVO(postsService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(@RequestBody 	 Posts bean) {
		System.out.println(bean.toString());
		System.out.println(bean.toString());
		System.out.println(bean.toString());
		postsService.add(bean);

		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Posts> listBean) {
		postsService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Posts> listBean) {
		postsService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据PostId查询对象
	 */
	@RequestMapping("/getPostsByPostId/{postId}")
	public ResponseVO getPostsByPostId(@PathVariable Integer postId) {
		return getSuccessResponseVO(postsService.getPostsByPostId(postId));
	}

	/**
	 * 根据PostId修改对象
	 */
	@RequestMapping("/updatePostsByPostId")
	public ResponseVO updatePostsByPostId(Posts bean,Integer postId) {
		postsService.updatePostsByPostId(bean,postId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据PostId删除
	 */
	@RequestMapping("/deletePostsByPostId")
	public ResponseVO deletePostsByPostId(Integer postId) {
		postsService.deletePostsByPostId(postId);
		return getSuccessResponseVO(null);
	}


}