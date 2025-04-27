package com.easyjava.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.easyjava.test.dto.CommentDto;
import com.easyjava.test.entity.po.UserInfo;
import com.easyjava.test.mappers.UserInfoMapper;
import com.easyjava.test.utils.CopyTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyjava.test.entity.enums.PageSize;
import com.easyjava.test.entity.query.CommentsQuery;
import com.easyjava.test.entity.po.Comments;
import com.easyjava.test.entity.vo.PaginationResultVO;
import com.easyjava.test.entity.query.SimplePage;
import com.easyjava.test.mappers.CommentsMapper;
import com.easyjava.test.service.CommentsService;
import com.easyjava.test.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {

	@Resource
	private CommentsMapper<Comments, CommentsQuery> commentsMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Comments> findListByParam(CommentsQuery param) {
		return this.commentsMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(CommentsQuery param) {
		return this.commentsMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<Comments> findListByPage(CommentsQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Comments> list = this.findListByParam(param);

		PaginationResultVO<Comments> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	@Override
	public PaginationResultVO<Comments> findCommentsListByPage(CommentsQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<Comments> list = this.findListByParam(param);
		List<CommentDto> commentDtoList = CopyTools.copyList(list, CommentDto.class);
		for(CommentDto commentDto : commentDtoList){
			String userId = commentDto.getUserId();
			UserInfo userInfo = (UserInfo)userInfoMapper.selectByUserId(userId);
			commentDto.setNickName(userInfo.getNickName());
		}
		PaginationResultVO<Comments> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), commentDtoList);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(Comments bean) {
		return this.commentsMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<Comments> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.commentsMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<Comments> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.commentsMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(Comments bean, CommentsQuery param) {
		StringTools.checkParam(param);
		return this.commentsMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(CommentsQuery param) {
		StringTools.checkParam(param);
		return this.commentsMapper.deleteByParam(param);
	}

	/**
	 * 根据CommentId获取对象
	 */
	@Override
	public Comments getCommentsByCommentId(Integer commentId) {
		return this.commentsMapper.selectByCommentId(commentId);
	}

	/**
	 * 根据CommentId修改
	 */
	@Override
	public Integer updateCommentsByCommentId(Comments bean, Integer commentId) {
		return this.commentsMapper.updateByCommentId(bean, commentId);
	}

	/**
	 * 根据CommentId删除
	 */
	@Override
	public Integer deleteCommentsByCommentId(Integer commentId) {
		return this.commentsMapper.deleteByCommentId(commentId);
	}
}