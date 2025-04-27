package com.easyjava.test.controller;

import java.util.List;

import com.easyjava.test.entity.query.AnnouncementsQuery;
import com.easyjava.test.entity.po.Announcements;
import com.easyjava.test.entity.vo.ResponseVO;
import com.easyjava.test.service.AnnouncementsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("announcementsController")
@RequestMapping("/announcements")
public class AnnouncementsController extends ABaseController{

	@Resource
	private AnnouncementsService announcementsService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(AnnouncementsQuery query){
		return getSuccessResponseVO(announcementsService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(Announcements bean) {
		announcementsService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Announcements> listBean) {
		announcementsService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Announcements> listBean) {
		announcementsService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据AnnouncementId查询对象
	 */
	@RequestMapping("/getAnnouncementsByAnnouncementId")
	public ResponseVO getAnnouncementsByAnnouncementId(Integer announcementId) {
		return getSuccessResponseVO(announcementsService.getAnnouncementsByAnnouncementId(announcementId));
	}

	/**
	 * 根据AnnouncementId修改对象
	 */
	@RequestMapping("/updateAnnouncementsByAnnouncementId")
	public ResponseVO updateAnnouncementsByAnnouncementId(Announcements bean,Integer announcementId) {
		announcementsService.updateAnnouncementsByAnnouncementId(bean,announcementId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据AnnouncementId删除
	 */
	@RequestMapping("/deleteAnnouncementsByAnnouncementId")
	public ResponseVO deleteAnnouncementsByAnnouncementId(Integer announcementId) {
		announcementsService.deleteAnnouncementsByAnnouncementId(announcementId);
		return getSuccessResponseVO(null);
	}
}