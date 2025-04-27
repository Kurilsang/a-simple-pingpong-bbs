package com.easyjava.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyjava.test.entity.enums.PageSize;
import com.easyjava.test.entity.query.ForumsQuery;
import com.easyjava.test.entity.po.Forums;
import com.easyjava.test.entity.vo.PaginationResultVO;
import com.easyjava.test.entity.query.SimplePage;
import com.easyjava.test.mappers.ForumsMapper;
import com.easyjava.test.service.ForumsService;
import com.easyjava.test.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("forumsService")
public class ForumsServiceImpl implements ForumsService {

	@Resource
	private ForumsMapper<Forums, ForumsQuery> forumsMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Forums> findListByParam(ForumsQuery param) {
		return this.forumsMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(ForumsQuery param) {
		return this.forumsMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Forums> findListByPage(ForumsQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Forums> list = this.findListByParam(param);
		PaginationResultVO<Forums> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Forums bean) {
		return this.forumsMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Forums> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.forumsMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Forums> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.forumsMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Forums bean, ForumsQuery param) {
		StringTools.checkParam(param);
		return this.forumsMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(ForumsQuery param) {
		StringTools.checkParam(param);
		return this.forumsMapper.deleteByParam(param);
	}

	/**
	 * 根据ForumId获取对象
	 */
	@Override
	public Forums getForumsByForumId(Integer forumId) {
		return this.forumsMapper.selectByForumId(forumId);
	}

	/**
	 * 根据ForumId修改
	 */
	@Override
	public Integer updateForumsByForumId(Forums bean, Integer forumId) {
		return this.forumsMapper.updateByForumId(bean, forumId);
	}

	/**
	 * 根据ForumId删除
	 */
	@Override
	public Integer deleteForumsByForumId(Integer forumId) {
		return this.forumsMapper.deleteByForumId(forumId);
	}

	/**
	 * 根据ForumName获取对象
	 */
	@Override
	public Forums getForumsByForumName(String forumName) {
		return this.forumsMapper.selectByForumName(forumName);
	}

	/**
	 * 根据ForumName修改
	 */
	@Override
	public Integer updateForumsByForumName(Forums bean, String forumName) {
		return this.forumsMapper.updateByForumName(bean, forumName);
	}

	/**
	 * 根据ForumName删除
	 */
	@Override
	public Integer deleteForumsByForumName(String forumName) {
		return this.forumsMapper.deleteByForumName(forumName);
	}
}