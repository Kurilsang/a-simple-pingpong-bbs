package com.easyjava.test.controller;

import java.util.List;

import com.easyjava.test.entity.query.UsersQuery;
import com.easyjava.test.entity.po.Users;
import com.easyjava.test.entity.vo.ResponseVO;
import com.easyjava.test.service.UsersService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("usersController")
@RequestMapping("/users")
public class UsersController extends ABaseController{

	@Resource
	private UsersService usersService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(UsersQuery query){
		return getSuccessResponseVO(usersService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(Users bean) {
		usersService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Users> listBean) {
		usersService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Users> listBean) {
		usersService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据UserId查询对象
	 */
	@RequestMapping("/getUsersByUserId")
	public ResponseVO getUsersByUserId(Integer userId) {
		return getSuccessResponseVO(usersService.getUsersByUserId(userId));
	}

	/**
	 * 根据UserId修改对象
	 */
	@RequestMapping("/updateUsersByUserId")
	public ResponseVO updateUsersByUserId(Users bean,Integer userId) {
		usersService.updateUsersByUserId(bean,userId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据UserId删除
	 */
	@RequestMapping("/deleteUsersByUserId")
	public ResponseVO deleteUsersByUserId(Integer userId) {
		usersService.deleteUsersByUserId(userId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Username查询对象
	 */
	@RequestMapping("/getUsersByUsername")
	public ResponseVO getUsersByUsername(String username) {
		return getSuccessResponseVO(usersService.getUsersByUsername(username));
	}

	/**
	 * 根据Username修改对象
	 */
	@RequestMapping("/updateUsersByUsername")
	public ResponseVO updateUsersByUsername(Users bean,String username) {
		usersService.updateUsersByUsername(bean,username);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Username删除
	 */
	@RequestMapping("/deleteUsersByUsername")
	public ResponseVO deleteUsersByUsername(String username) {
		usersService.deleteUsersByUsername(username);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Email查询对象
	 */
	@RequestMapping("/getUsersByEmail")
	public ResponseVO getUsersByEmail(String email) {
		return getSuccessResponseVO(usersService.getUsersByEmail(email));
	}

	/**
	 * 根据Email修改对象
	 */
	@RequestMapping("/updateUsersByEmail")
	public ResponseVO updateUsersByEmail(Users bean,String email) {
		usersService.updateUsersByEmail(bean,email);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Email删除
	 */
	@RequestMapping("/deleteUsersByEmail")
	public ResponseVO deleteUsersByEmail(String email) {
		usersService.deleteUsersByEmail(email);
		return getSuccessResponseVO(null);
	}
}