package com.easyjava.test.service;

import java.util.List;

import com.easyjava.test.entity.query.PrivateMessagesQuery;
import com.easyjava.test.entity.po.PrivateMessages;
import com.easyjava.test.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface PrivateMessagesService {

	/**
	 * 根据条件查询列表
	 */
	List<PrivateMessages> findListByParam(PrivateMessagesQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(PrivateMessagesQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<PrivateMessages> findListByPage(PrivateMessagesQuery param);

	/**
	 * 新增
	 */
	Integer add(PrivateMessages bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<PrivateMessages> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<PrivateMessages> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(PrivateMessages bean,PrivateMessagesQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(PrivateMessagesQuery param);

	/**
	 * 根据MessageId查询对象
	 */
	PrivateMessages getPrivateMessagesByMessageId(Integer messageId);


	/**
	 * 根据MessageId修改
	 */
	Integer updatePrivateMessagesByMessageId(PrivateMessages bean,Integer messageId);


	/**
	 * 根据MessageId删除
	 */
	Integer deletePrivateMessagesByMessageId(Integer messageId);

}