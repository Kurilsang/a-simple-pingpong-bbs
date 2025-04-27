package com.easyjava.test.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *  数据库操作接口
 */
public interface AnnouncementsMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据AnnouncementId更新
	 */
	 Integer updateByAnnouncementId(@Param("bean") T t,@Param("announcementId") Integer announcementId);


	/**
	 * 根据AnnouncementId删除
	 */
	 Integer deleteByAnnouncementId(@Param("announcementId") Integer announcementId);


	/**
	 * 根据AnnouncementId获取对象
	 */
	 T selectByAnnouncementId(@Param("announcementId") Integer announcementId);


}
