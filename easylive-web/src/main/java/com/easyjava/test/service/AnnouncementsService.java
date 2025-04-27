package com.easyjava.test.service;

import java.util.List;

import com.easyjava.test.entity.query.AnnouncementsQuery;
import com.easyjava.test.entity.po.Announcements;
import com.easyjava.test.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface AnnouncementsService {

	/**
	 * 根据条件查询列表
	 */
	List<Announcements> findListByParam(AnnouncementsQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(AnnouncementsQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Announcements> findListByPage(AnnouncementsQuery param);

	/**
	 * 新增
	 */
	Integer add(Announcements bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Announcements> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Announcements> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Announcements bean,AnnouncementsQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(AnnouncementsQuery param);

	/**
	 * 根据AnnouncementId查询对象
	 */
	Announcements getAnnouncementsByAnnouncementId(Integer announcementId);


	/**
	 * 根据AnnouncementId修改
	 */
	Integer updateAnnouncementsByAnnouncementId(Announcements bean,Integer announcementId);


	/**
	 * 根据AnnouncementId删除
	 */
	Integer deleteAnnouncementsByAnnouncementId(Integer announcementId);

}