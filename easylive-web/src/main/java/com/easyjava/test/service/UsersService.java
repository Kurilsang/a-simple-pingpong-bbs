package com.easyjava.test.service;

import java.util.List;

import com.easyjava.test.entity.query.UsersQuery;
import com.easyjava.test.entity.po.Users;
import com.easyjava.test.entity.vo.PaginationResultVO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 *  业务接口
 */
public interface UsersService {

	/**
	 * 根据条件查询列表
	 */
	List<Users> findListByParam(UsersQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(UsersQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Users> findListByPage(UsersQuery param);

	/**
	 * 新增
	 */
	Integer add(Users bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Users> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Users> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Users bean,UsersQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(UsersQuery param);

	/**
	 * 根据UserId查询对象
	 */
	Users getUsersByUserId(Integer userId);


	/**
	 * 根据UserId修改
	 */
	Integer updateUsersByUserId(Users bean,Integer userId);


	/**
	 * 根据UserId删除
	 */
	Integer deleteUsersByUserId(Integer userId);


	/**
	 * 根据Username查询对象
	 */
	Users getUsersByUsername(String username);


	/**
	 * 根据Username修改
	 */
	Integer updateUsersByUsername(Users bean,String username);


	/**
	 * 根据Username删除
	 */
	Integer deleteUsersByUsername(String username);


	/**
	 * 根据Email查询对象
	 */
	Users getUsersByEmail(String email);


	/**
	 * 根据Email修改
	 */
	Integer updateUsersByEmail(Users bean,String email);


	/**
	 * 根据Email删除
	 */
	Integer deleteUsersByEmail(String email);


}