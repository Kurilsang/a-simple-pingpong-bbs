package com.easyjava.test.service;

import java.util.List;

import com.easyjava.test.entity.query.LikesDislikesQuery;
import com.easyjava.test.entity.po.LikesDislikes;
import com.easyjava.test.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface LikesDislikesService {

	/**
	 * 根据条件查询列表
	 */
	List<LikesDislikes> findListByParam(LikesDislikesQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(LikesDislikesQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<LikesDislikes> findListByPage(LikesDislikesQuery param);

	/**
	 * 新增
	 */
	Integer add(LikesDislikes bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<LikesDislikes> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<LikesDislikes> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(LikesDislikes bean,LikesDislikesQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(LikesDislikesQuery param);

	/**
	 * 根据Id查询对象
	 */
	LikesDislikes getLikesDislikesById(Integer id);


	/**
	 * 根据Id修改
	 */
	Integer updateLikesDislikesById(LikesDislikes bean,Integer id);


	/**
	 * 根据Id删除
	 */
	Integer deleteLikesDislikesById(Integer id);

}