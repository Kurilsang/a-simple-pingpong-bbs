package com.easyjava.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyjava.test.entity.enums.PageSize;
import com.easyjava.test.entity.query.AnnouncementsQuery;
import com.easyjava.test.entity.po.Announcements;
import com.easyjava.test.entity.vo.PaginationResultVO;
import com.easyjava.test.entity.query.SimplePage;
import com.easyjava.test.mappers.AnnouncementsMapper;
import com.easyjava.test.service.AnnouncementsService;
import com.easyjava.test.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("announcementsService")
public class AnnouncementsServiceImpl implements AnnouncementsService {

	@Resource
	private AnnouncementsMapper<Announcements, AnnouncementsQuery> announcementsMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Announcements> findListByParam(AnnouncementsQuery param) {
		return this.announcementsMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(AnnouncementsQuery param) {
		return this.announcementsMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Announcements> findListByPage(AnnouncementsQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Announcements> list = this.findListByParam(param);
		PaginationResultVO<Announcements> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Announcements bean) {
		return this.announcementsMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Announcements> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.announcementsMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Announcements> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.announcementsMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Announcements bean, AnnouncementsQuery param) {
		StringTools.checkParam(param);
		return this.announcementsMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(AnnouncementsQuery param) {
		StringTools.checkParam(param);
		return this.announcementsMapper.deleteByParam(param);
	}

	/**
	 * 根据AnnouncementId获取对象
	 */
	@Override
	public Announcements getAnnouncementsByAnnouncementId(Integer announcementId) {
		return this.announcementsMapper.selectByAnnouncementId(announcementId);
	}

	/**
	 * 根据AnnouncementId修改
	 */
	@Override
	public Integer updateAnnouncementsByAnnouncementId(Announcements bean, Integer announcementId) {
		return this.announcementsMapper.updateByAnnouncementId(bean, announcementId);
	}

	/**
	 * 根据AnnouncementId删除
	 */
	@Override
	public Integer deleteAnnouncementsByAnnouncementId(Integer announcementId) {
		return this.announcementsMapper.deleteByAnnouncementId(announcementId);
	}
}