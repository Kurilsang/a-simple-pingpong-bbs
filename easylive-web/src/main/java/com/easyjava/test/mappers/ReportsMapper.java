package com.easyjava.test.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *  数据库操作接口
 */
public interface ReportsMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据ReportId更新
	 */
	 Integer updateByReportId(@Param("bean") T t,@Param("reportId") Integer reportId);


	/**
	 * 根据ReportId删除
	 */
	 Integer deleteByReportId(@Param("reportId") Integer reportId);


	/**
	 * 根据ReportId获取对象
	 */
	 T selectByReportId(@Param("reportId") Integer reportId);


}
