package com.easyjava.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.easyjava.test.component.RedisComponent;
import com.easyjava.test.constants.Constants;
import com.easyjava.test.dto.TokenUserInfoDto;
import com.easyjava.test.entity.query.UserInfoQuery;
import com.easyjava.test.entity.po.UserInfo;
import com.easyjava.test.entity.vo.ResponseVO;
import com.easyjava.test.exception.BusinessException;
import com.easyjava.test.service.UserInfoService;
import com.easyjava.test.service.UsersService;
import com.wf.captcha.ArithmeticCaptcha;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
			return getSuccessResponseVO("未登录");
		}
		Integer result = userInfoService.loginCheck(token);
		return getSuccessResponseVO(result);
	}
}