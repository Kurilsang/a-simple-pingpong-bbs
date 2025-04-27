package com.easyjava.test.service;

import java.util.List;

import com.easyjava.test.entity.query.ReportsQuery;
import com.easyjava.test.entity.po.Reports;
import com.easyjava.test.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface ReportsService {

	/**
	 * 根据条件查询列表
	 */
	List<Reports> findListByParam(ReportsQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(ReportsQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Reports> findListByPage(ReportsQuery param);

	/**
	 * 新增
	 */
	Integer add(Reports bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Reports> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<Reports> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(Reports bean,ReportsQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(ReportsQuery param);

	/**
	 * 根据ReportId查询对象
	 */
	Reports getReportsByReportId(Integer reportId);


	/**
	 * 根据ReportId修改
	 */
	Integer updateReportsByReportId(Reports bean,Integer reportId);


	/**
	 * 根据ReportId删除
	 */
	Integer deleteReportsByReportId(Integer reportId);

}