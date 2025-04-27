package com.easyjava.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyjava.test.entity.enums.PageSize;
import com.easyjava.test.entity.query.PrivateMessagesQuery;
import com.easyjava.test.entity.po.PrivateMessages;
import com.easyjava.test.entity.vo.PaginationResultVO;
import com.easyjava.test.entity.query.SimplePage;
import com.easyjava.test.mappers.PrivateMessagesMapper;
import com.easyjava.test.service.PrivateMessagesService;
import com.easyjava.test.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("privateMessagesService")
public class PrivateMessagesServiceImpl implements PrivateMessagesService {

	@Resource
	private PrivateMessagesMapper<PrivateMessages, PrivateMessagesQuery> privateMessagesMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<PrivateMessages> findListByParam(PrivateMessagesQuery param) {
		return this.privateMessagesMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(PrivateMessagesQuery param) {
		return this.privateMessagesMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<PrivateMessages> findListByPage(PrivateMessagesQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<PrivateMessages> list = this.findListByParam(param);
		PaginationResultVO<PrivateMessages> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(PrivateMessages bean) {
		return this.privateMessagesMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<PrivateMessages> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.privateMessagesMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<PrivateMessages> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.privateMessagesMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(PrivateMessages bean, PrivateMessagesQuery param) {
		StringTools.checkParam(param);
		return this.privateMessagesMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(PrivateMessagesQuery param) {
		StringTools.checkParam(param);
		return this.privateMessagesMapper.deleteByParam(param);
	}

	/**
	 * 根据MessageId获取对象
	 */
	@Override
	public PrivateMessages getPrivateMessagesByMessageId(Integer messageId) {
		return this.privateMessagesMapper.selectByMessageId(messageId);
	}

	/**
	 * 根据MessageId修改
	 */
	@Override
	public Integer updatePrivateMessagesByMessageId(PrivateMessages bean, Integer messageId) {
		return this.privateMessagesMapper.updateByMessageId(bean, messageId);
	}

	/**
	 * 根据MessageId删除
	 */
	@Override
	public Integer deletePrivateMessagesByMessageId(Integer messageId) {
		return this.privateMessagesMapper.deleteByMessageId(messageId);
	}
}