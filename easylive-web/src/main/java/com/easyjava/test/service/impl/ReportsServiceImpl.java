package com.easyjava.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyjava.test.entity.enums.PageSize;
import com.easyjava.test.entity.query.ReportsQuery;
import com.easyjava.test.entity.po.Reports;
import com.easyjava.test.entity.vo.PaginationResultVO;
import com.easyjava.test.entity.query.SimplePage;
import com.easyjava.test.mappers.ReportsMapper;
import com.easyjava.test.service.ReportsService;
import com.easyjava.test.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("reportsService")
public class ReportsServiceImpl implements ReportsService {

	@Resource
	private ReportsMapper<Reports, ReportsQuery> reportsMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Reports> findListByParam(ReportsQuery param) {
		return this.reportsMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(ReportsQuery param) {
		return this.reportsMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Reports> findListByPage(ReportsQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Reports> list = this.findListByParam(param);
		PaginationResultVO<Reports> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Reports bean) {
		return this.reportsMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Reports> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.reportsMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Reports> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.reportsMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Reports bean, ReportsQuery param) {
		StringTools.checkParam(param);
		return this.reportsMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(ReportsQuery param) {
		StringTools.checkParam(param);
		return this.reportsMapper.deleteByParam(param);
	}

	/**
	 * 根据ReportId获取对象
	 */
	@Override
	public Reports getReportsByReportId(Integer reportId) {
		return this.reportsMapper.selectByReportId(reportId);
	}

	/**
	 * 根据ReportId修改
	 */
	@Override
	public Integer updateReportsByReportId(Reports bean, Integer reportId) {
		return this.reportsMapper.updateByReportId(bean, reportId);
	}

	/**
	 * 根据ReportId删除
	 */
	@Override
	public Integer deleteReportsByReportId(Integer reportId) {
		return this.reportsMapper.deleteByReportId(reportId);
	}
}