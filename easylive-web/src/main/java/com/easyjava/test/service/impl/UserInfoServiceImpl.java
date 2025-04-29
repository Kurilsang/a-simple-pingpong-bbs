package com.easyjava.test.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

import com.easyjava.test.component.RedisComponent;
import com.easyjava.test.constants.Constants;
import com.easyjava.test.dto.TokenUserInfoDto;
import com.easyjava.test.entity.enums.LoginedEnum;
import com.easyjava.test.entity.enums.UserSexEnum;
import com.easyjava.test.entity.enums.UserStatusEnum;
import com.easyjava.test.exception.BusinessException;
import com.easyjava.test.utils.CopyTools;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyjava.test.entity.enums.PageSize;
import com.easyjava.test.entity.query.UserInfoQuery;
import com.easyjava.test.entity.po.UserInfo;
import com.easyjava.test.entity.vo.PaginationResultVO;
import com.easyjava.test.entity.query.SimplePage;
import com.easyjava.test.mappers.UserInfoMapper;
import com.easyjava.test.service.UserInfoService;
import com.easyjava.test.utils.StringTools;


/**
 * 用户信息 业务接口实现
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoMapper<UserInfo, UserInfoQuery> userInfoMapper;
    @Autowired
    private RedisComponent redisComponent;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<UserInfo> findListByParam(UserInfoQuery param) {
		return this.userInfoMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(UserInfoQuery param) {
		return this.userInfoMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<UserInfo> findListByPage(UserInfoQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<UserInfo> list = this.findListByParam(param);
		PaginationResultVO<UserInfo> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(UserInfo bean) {
		return this.userInfoMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<UserInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.userInfoMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<UserInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.userInfoMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(UserInfo bean, UserInfoQuery param) {
		StringTools.checkParam(param);
		return this.userInfoMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(UserInfoQuery param) {
		StringTools.checkParam(param);
		return this.userInfoMapper.deleteByParam(param);
	}

	/**
	 * 根据UserId获取对象
	 */
	@Override
	public UserInfo getUserInfoByUserId(String userId) {
		return this.userInfoMapper.selectByUserId(userId);
	}

	/**
	 * 根据UserId修改
	 */
	@Override
	public Integer updateUserInfoByUserId(UserInfo bean, String userId) {
		return this.userInfoMapper.updateByUserId(bean, userId);
	}

	/**
	 * 根据UserId删除
	 */
	@Override
	public Integer deleteUserInfoByUserId(String userId) {
		return this.userInfoMapper.deleteByUserId(userId);
	}

	/**
	 * 根据Email获取对象
	 */
	@Override
	public UserInfo getUserInfoByEmail(String email) {
		return this.userInfoMapper.selectByEmail(email);
	}

	/**
	 * 根据Email修改
	 */
	@Override
	public Integer updateUserInfoByEmail(UserInfo bean, String email) {
		return this.userInfoMapper.updateByEmail(bean, email);
	}

	/**
	 * 根据Email删除
	 */
	@Override
	public Integer deleteUserInfoByEmail(String email) {
		return this.userInfoMapper.deleteByEmail(email);
	}

	/**
	 * 根据NickName获取对象
	 */
	@Override
	public UserInfo getUserInfoByNickName(String nickName) {
		return this.userInfoMapper.selectByNickName(nickName);
	}

	/**
	 * 根据NickName修改
	 */
	@Override
	public Integer updateUserInfoByNickName(UserInfo bean, String nickName) {
		return this.userInfoMapper.updateByNickName(bean, nickName);
	}

	/**
	 * 根据NickName删除
	 */
	@Override
	public Integer deleteUserInfoByNickName(String nickName) {
		return this.userInfoMapper.deleteByNickName(nickName);
	}

	@Override
	public void register(String email, String nickName, String registerPassword) {
		UserInfo userInfo = userInfoMapper.selectByEmail(email);
		if(null != userInfo) {throw new BusinessException("邮箱已存在");
		}
		userInfo = userInfoMapper.selectByNickName(nickName);
		if(null!=userInfo)
		{
			throw new BusinessException("昵称已存在");
		}
		userInfo = new UserInfo();
		String userId = StringTools.getRandomNumber(Constants.LENGTH_10);
		userInfo.setUserId(userId);
		userInfo.setNickName(nickName);
		userInfo.setEmail(email);
		userInfo.setPassword(StringTools.encodeByMd5(registerPassword));
		userInfo.setJoinTime(new Date());
		userInfo.setStatus(UserStatusEnum.ENABLE.getStatus());
		userInfo.setSex(UserSexEnum.SECREACY.getType());
		userInfo.setTheme(Constants.ONE);

		userInfo.setTotalCoinCount(10);
		userInfo.setCurrentCoinCount(10);

		this.userInfoMapper.insert(userInfo);

	}

	@Override
	public TokenUserInfoDto login(String email, String password, String ip) {
		UserInfo userInfo = userInfoMapper.selectByEmail(email);
		System.out.println("这是标记"+StringTools.encodeByMd5(password)+"为输入"+userInfo.getPassword());
		if(null == userInfo||(!userInfo.getPassword().equals(StringTools.encodeByMd5(password)))) {
			throw new BusinessException("账号或密码错误");
		}


		if(userInfo.getStatus()==UserStatusEnum.DISABLED.getStatus()) {
			throw new BusinessException("账号已被禁用");
		}
		UserInfo updateUserInfo = new UserInfo();
		updateUserInfo.setLastLoginTime(new Date());
		updateUserInfo.setLastLoginIp(ip);
		userInfoMapper.updateByUserId(updateUserInfo,userInfo.getUserId());

		TokenUserInfoDto tokenUserInfoDto = CopyTools.copy(userInfo, TokenUserInfoDto.class);

		redisComponent.saveTokenInfo(tokenUserInfoDto);
		return tokenUserInfoDto;
	}

	@Override
	public Integer loginCheck(String token) {
		TokenUserInfoDto tokenUserInfoDto= redisComponent.getTokenInfo(token);
		if(null!=tokenUserInfoDto) {
			return LoginedEnum.LOGINED.getIsLogined();
		}
		else{
			return LoginedEnum.NOTLOGIN.getIsLogined();
		}
	}

	@Override
	public void adminAdd(UserInfo userInfo) {
		UserInfo u = userInfoMapper.selectByEmail(userInfo.getEmail());
		if(null != u) {throw new BusinessException("邮箱已存在");
		}
		u = userInfoMapper.selectByNickName(userInfo.getNickName());
		if(null!=u)
		{
			throw new BusinessException("昵称已存在");
		}
		String userId = StringTools.getRandomNumber(Constants.LENGTH_10);
		userInfo.setUserId(userId);
		String passwordMd5 = StringTools.encodeByMd5(userInfo.getPassword());
		userInfo.setPassword(passwordMd5);
		userInfo.setJoinTime(new Date());
		userInfo.setStatus(UserStatusEnum.ENABLE.getStatus());
		userInfo.setSex(UserSexEnum.SECREACY.getType());
		userInfo.setTheme(Constants.ONE);

		userInfo.setCurrentCoinCount(10);
		userInfo.setTotalCoinCount(10);
		userInfoMapper.insert(userInfo);
	}

	@Override
	public void adminUpdate(UserInfo userInfo, String userId) {
//		userInfo.setPassword(StringTools.encodeByMd5(StringTools.encodeByMd5(userInfo.getPassword())));
		String passwordMd5 = StringTools.encodeByMd5(userInfo.getPassword());
		userInfo.setPassword(passwordMd5);
		userInfoMapper.updateByUserId(userInfo,userId);
	}

}