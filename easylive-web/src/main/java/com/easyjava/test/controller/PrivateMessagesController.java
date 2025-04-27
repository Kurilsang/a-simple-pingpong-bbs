package com.easyjava.test.controller;

import java.util.List;

import com.easyjava.test.entity.query.PrivateMessagesQuery;
import com.easyjava.test.entity.po.PrivateMessages;
import com.easyjava.test.entity.vo.ResponseVO;
import com.easyjava.test.service.PrivateMessagesService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("privateMessagesController")
@RequestMapping("/privateMessages")
public class PrivateMessagesController extends ABaseController{

	@Resource
	private PrivateMessagesService privateMessagesService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(PrivateMessagesQuery query){
		return getSuccessResponseVO(privateMessagesService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(PrivateMessages bean) {
		privateMessagesService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<PrivateMessages> listBean) {
		privateMessagesService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<PrivateMessages> listBean) {
		privateMessagesService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据MessageId查询对象
	 */
	@RequestMapping("/getPrivateMessagesByMessageId")
	public ResponseVO getPrivateMessagesByMessageId(Integer messageId) {
		return getSuccessResponseVO(privateMessagesService.getPrivateMessagesByMessageId(messageId));
	}

	/**
	 * 根据MessageId修改对象
	 */
	@RequestMapping("/updatePrivateMessagesByMessageId")
	public ResponseVO updatePrivateMessagesByMessageId(PrivateMessages bean,Integer messageId) {
		privateMessagesService.updatePrivateMessagesByMessageId(bean,messageId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据MessageId删除
	 */
	@RequestMapping("/deletePrivateMessagesByMessageId")
	public ResponseVO deletePrivateMessagesByMessageId(Integer messageId) {
		privateMessagesService.deletePrivateMessagesByMessageId(messageId);
		return getSuccessResponseVO(null);
	}
}