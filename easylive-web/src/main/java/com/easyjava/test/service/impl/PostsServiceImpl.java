package com.easyjava.test.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyjava.test.entity.enums.PageSize;
import com.easyjava.test.entity.query.PostsQuery;
import com.easyjava.test.entity.po.Posts;
import com.easyjava.test.entity.vo.PaginationResultVO;
import com.easyjava.test.entity.query.SimplePage;
import com.easyjava.test.mappers.PostsMapper;
import com.easyjava.test.service.PostsService;
import com.easyjava.test.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("postsService")
public class PostsServiceImpl implements PostsService {

	@Resource
	private PostsMapper<Posts, PostsQuery> postsMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Posts> findListByParam(PostsQuery param) {
		return this.postsMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(PostsQuery param) {
		return this.postsMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Posts> findListByPage(PostsQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Posts> list = this.findListByParam(param);
		PaginationResultVO<Posts> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Posts bean) {
		bean.setCreatedAt(new Date());
		bean.setUpdatedAt(new Date());
		return this.postsMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Posts> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.postsMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Posts> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.postsMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Posts bean, PostsQuery param) {
		StringTools.checkParam(param);
		return this.postsMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(PostsQuery param) {
		StringTools.checkParam(param);
		return this.postsMapper.deleteByParam(param);
	}

	/**
	 * 根据PostId获取对象
	 */
	@Override
	public Posts getPostsByPostId(Integer postId) {
		return this.postsMapper.selectByPostId(postId);
	}

	/**
	 * 根据PostId修改
	 */
	@Override
	public Integer updatePostsByPostId(Posts bean, Integer postId) {
		return this.postsMapper.updateByPostId(bean, postId);
	}

	/**
	 * 根据PostId删除
	 */
	@Override
	public Integer deletePostsByPostId(Integer postId) {
		return this.postsMapper.deleteByPostId(postId);
	}
}