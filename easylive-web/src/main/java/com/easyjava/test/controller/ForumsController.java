package com.easyjava.test.controller;

import java.util.List;

import com.easyjava.test.entity.query.ForumsQuery;
import com.easyjava.test.entity.po.Forums;
import com.easyjava.test.entity.vo.ResponseVO;
import com.easyjava.test.service.ForumsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("forumsController")
@RequestMapping("/forums")
public class ForumsController extends ABaseController{

	@Resource
	private ForumsService forumsService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(ForumsQuery query){
		return getSuccessResponseVO(forumsService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(Forums bean) {
		forumsService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Forums> listBean) {
		forumsService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Forums> listBean) {
		forumsService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据ForumId查询对象
	 */
	@RequestMapping("/getForumsByForumId")
	public ResponseVO getForumsByForumId(Integer forumId) {
		return getSuccessResponseVO(forumsService.getForumsByForumId(forumId));
	}

	/**
	 * 根据ForumId修改对象
	 */
	@RequestMapping("/updateForumsByForumId")
	public ResponseVO updateForumsByForumId(Forums bean,Integer forumId) {
		forumsService.updateForumsByForumId(bean,forumId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据ForumId删除
	 */
	@RequestMapping("/deleteForumsByForumId")
	public ResponseVO deleteForumsByForumId(Integer forumId) {
		forumsService.deleteForumsByForumId(forumId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据ForumName查询对象
	 */
	@RequestMapping("/getForumsByForumName")
	public ResponseVO getForumsByForumName(String forumName) {
		return getSuccessResponseVO(forumsService.getForumsByForumName(forumName));
	}

	/**
	 * 根据ForumName修改对象
	 */
	@RequestMapping("/updateForumsByForumName")
	public ResponseVO updateForumsByForumName(Forums bean,String forumName) {
		forumsService.updateForumsByForumName(bean,forumName);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据ForumName删除
	 */
	@RequestMapping("/deleteForumsByForumName")
	public ResponseVO deleteForumsByForumName(String forumName) {
		forumsService.deleteForumsByForumName(forumName);
		return getSuccessResponseVO(null);
	}
}