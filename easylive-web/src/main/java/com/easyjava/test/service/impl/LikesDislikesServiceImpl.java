package com.easyjava.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyjava.test.entity.enums.PageSize;
import com.easyjava.test.entity.query.LikesDislikesQuery;
import com.easyjava.test.entity.po.LikesDislikes;
import com.easyjava.test.entity.vo.PaginationResultVO;
import com.easyjava.test.entity.query.SimplePage;
import com.easyjava.test.mappers.LikesDislikesMapper;
import com.easyjava.test.service.LikesDislikesService;
import com.easyjava.test.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("likesDislikesService")
public class LikesDislikesServiceImpl implements LikesDislikesService {

	@Resource
	private LikesDislikesMapper<LikesDislikes, LikesDislikesQuery> likesDislikesMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<LikesDislikes> findListByParam(LikesDislikesQuery param) {
		return this.likesDislikesMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(LikesDislikesQuery param) {
		return this.likesDislikesMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<LikesDislikes> findListByPage(LikesDislikesQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<LikesDislikes> list = this.findListByParam(param);
		PaginationResultVO<LikesDislikes> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(LikesDislikes bean) {
		return this.likesDislikesMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<LikesDislikes> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.likesDislikesMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<LikesDislikes> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.likesDislikesMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(LikesDislikes bean, LikesDislikesQuery param) {
		StringTools.checkParam(param);
		return this.likesDislikesMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(LikesDislikesQuery param) {
		StringTools.checkParam(param);
		return this.likesDislikesMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public LikesDislikes getLikesDislikesById(Integer id) {
		return this.likesDislikesMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateLikesDislikesById(LikesDislikes bean, Integer id) {
		return this.likesDislikesMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteLikesDislikesById(Integer id) {
		return this.likesDislikesMapper.deleteById(id);
	}
}