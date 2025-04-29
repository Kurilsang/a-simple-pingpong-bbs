package com.easyjava.test.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.easyjava.test.component.RedisComponent;
import com.easyjava.test.constants.Constants;
import com.easyjava.test.dto.TokenUserInfoDto;
import com.easyjava.test.entity.enums.LoginedEnum;
import com.easyjava.test.entity.query.UserInfoQuery;
import com.easyjava.test.entity.po.UserInfo;
import com.easyjava.test.entity.vo.ResponseVO;
import com.easyjava.test.exception.BusinessException;
import com.easyjava.test.service.UserInfoService;
import com.easyjava.test.service.UsersService;
import com.easyjava.test.utils.MinioUtils;
import com.wf.captcha.ArithmeticCaptcha;
import io.minio.errors.*;
import org.apache.catalina.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 用户信息 Controller
 */
@RestController("userInfoController")
@RequestMapping("/account")
@Validated
public class AccountController extends ABaseController {

	@Resource
	private UserInfoService userInfoService;
	@Autowired
	private RedisComponent redisComponent;

	@RequestMapping("/checkCode")
	public ResponseVO checkCode() {
		ArithmeticCaptcha captcha = new ArithmeticCaptcha(100, 42);
		String code = captcha.text();
		String checkCodeKey = redisComponent.setCheckCode(code);

		String checkCodeBase64 = captcha.toBase64();

		Map<String, String> result = new HashMap<>();
		result.put("checkCode", checkCodeBase64);
		result.put("checkCodeKey", checkCodeKey);

		return getSuccessResponseVO(result);
	}
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public ResponseVO register( @NotEmpty @Email @Size(max = 150) String email,
							    @NotEmpty @Size(max = 20) String nickName,
							    @NotEmpty @Pattern(regexp = Constants.REGEX_PASSWORD) String registerPassword,
							    @NotEmpty String checkCodeKey,
							    @NotEmpty String checkCode) {
		try {
			if (!checkCode.equalsIgnoreCase(redisComponent.getCheckCode(checkCodeKey))) {
				throw new BusinessException("图片验证码错误");
			}
			userInfoService.register(email, nickName, registerPassword);

		} finally {
			redisComponent.cleanCheckCode(checkCodeKey);
		}

		return getSuccessResponseVO(null);

	}


	@RequestMapping("/login")
	public ResponseVO login(HttpServletResponse response, HttpServletRequest request,
							@NotEmpty @Email String email,
							@NotEmpty String password,
							@NotEmpty String checkCode,
							@NotEmpty String checkCodeKey)
	{
		try {
			if (!checkCode.equalsIgnoreCase(redisComponent.getCheckCode(checkCodeKey))) {
				throw new BusinessException("图片验证码错误");
			}
			String ip = getIpAddr();
			TokenUserInfoDto tokenUserInfoDto= userInfoService.login(email,password,ip);

			// TODO 设置 粉丝数 硬币数 关注数

			return getSuccessResponseVO(tokenUserInfoDto);


		} finally {
			redisComponent.cleanCheckCode(checkCodeKey);





		}
	}
	@RequestMapping("/loginCheck")
	public ResponseVO loginCheck(HttpServletRequest request)
	{
		String token = (String)request.getHeader("token");
		if(null==token)
		{
			return getSuccessResponseVO(LoginedEnum.NOTLOGIN);
		}
		Integer result = userInfoService.loginCheck(token);
		return getSuccessResponseVO(result);
	}
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(UserInfoQuery userInfoQuery)
	{
		return getSuccessResponseVO(userInfoService.findListByPage(userInfoQuery));
	}
	@RequestMapping("/adminAdd")
	public ResponseVO adminAdd(@RequestBody UserInfo userInfo)
	{
		userInfoService.adminAdd(userInfo);
		return getSuccessResponseVO(null);
	}
	@RequestMapping("/adminDelete")
	public ResponseVO adminDelete(String userId)
	{
		userInfoService.deleteUserInfoByUserId(userId);
		return getSuccessResponseVO(null);
	}
	@RequestMapping("/updateUserInfoByUserId/{userId}")
	public ResponseVO updateUserInfoByUserId(@RequestBody UserInfo userInfo,
											 @PathVariable String userId)
	{
		userInfoService.adminUpdate(userInfo,userId);
		return getSuccessResponseVO(null);
	}

	@RequestMapping("/getProfiles/{id}")
	public ResponseVO getProfiles(@PathVariable String id)
	{
		return getSuccessResponseVO(userInfoService.getUserInfoByUserId(id));
	}
	@RequestMapping("/updateProfile")
	public ResponseVO updateProfile(UserInfo userInfo)
	{
		System.out.println("标记"+userInfo.toString());
		System.out.println(userInfo.getAvatar());
		String userId = userInfo.getUserId();
		userInfoService.updateUserInfoByUserId(userInfo,userId);

		return getSuccessResponseVO("保存成功");
	}
	@Autowired
	MinioUtils aliOSSUtils;

	@PostMapping("/upload")
	public ResponseVO upload(@RequestParam("image") MultipartFile file) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

		String url = aliOSSUtils.upload(file);

		return getSuccessResponseVO(url);
	}
}