package com.easyjava.test.controller;

import java.util.List;

import com.easyjava.test.entity.query.ReportsQuery;
import com.easyjava.test.entity.po.Reports;
import com.easyjava.test.entity.vo.ResponseVO;
import com.easyjava.test.service.ReportsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("reportsController")
@RequestMapping("/reports")
public class ReportsController extends ABaseController{

	@Resource
	private ReportsService reportsService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(ReportsQuery query){
		return getSuccessResponseVO(reportsService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public ResponseVO add(Reports bean) {
		reportsService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Reports> listBean) {
		reportsService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增/修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Reports> listBean) {
		reportsService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据ReportId查询对象
	 */
	@RequestMapping("/getReportsByReportId")
	public ResponseVO getReportsByReportId(Integer reportId) {
		return getSuccessResponseVO(reportsService.getReportsByReportId(reportId));
	}

	/**
	 * 根据ReportId修改对象
	 */
	@RequestMapping("/updateReportsByReportId")
	public ResponseVO updateReportsByReportId(Reports bean,Integer reportId) {
		reportsService.updateReportsByReportId(bean,reportId);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据ReportId删除
	 */
	@RequestMapping("/deleteReportsByReportId")
	public ResponseVO deleteReportsByReportId(Integer reportId) {
		reportsService.deleteReportsByReportId(reportId);
		return getSuccessResponseVO(null);
	}
}