package com.easyjava.test.controller;

import java.util.List;

import com.easyjava.test.entity.query.LikesDislikesQuery;
import com.easyjava.test.entity.po.LikesDislikes;
import com.easyjava.test.entity.vo.ResponseVO;
import com.easyjava.test.service.LikesDislikesService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("likesDislikesController")
@RequestMapping("/likesDislikes")
public class LikesDislikesController extends ABaseController{

	@Resource
	private LikesDislikesService likesDislikesService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(LikesDislikesQuery query){
		return getSuccessResponseVO(likesDislikesService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(LikesDislikes bean) {
		likesDislikesService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<LikesDislikes> listBean) {
		likesDislikesService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<LikesDislikes> listBean) {
		likesDislikesService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getLikesDislikesById")
	public ResponseVO getLikesDislikesById(Integer id) {
		return getSuccessResponseVO(likesDislikesService.getLikesDislikesById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateLikesDislikesById")
	public ResponseVO updateLikesDislikesById(LikesDislikes bean,Integer id) {
		likesDislikesService.updateLikesDislikesById(bean,id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteLikesDislikesById")
	public ResponseVO deleteLikesDislikesById(Integer id) {
		likesDislikesService.deleteLikesDislikesById(id);
		return getSuccessResponseVO(null);
	}
}