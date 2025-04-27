package com.easyjava.test.component;

import com.easyjava.test.constants.Constants;
import com.easyjava.test.dto.TokenUserInfoDto;
import com.easyjava.test.redis.RedisUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class RedisComponent {
    @Resource
    private RedisUtils redisUtils;

    public String setCheckCode(String code)
    {
        String checkCodekey = UUID.randomUUID().toString();
        redisUtils.setex(Constants.REDIS_KEY_CHECK_CODE+checkCodekey, code, Constants.REDIS_KEY_EXPIRE_ONE_MIN*10);
        return checkCodekey;
    }

    public String getCheckCode(String checkCodeKey)
    {
        return (String)redisUtils.get(Constants.REDIS_KEY_CHECK_CODE+checkCodeKey);
    }

    public void cleanCheckCode(String checkCodeKey)
    {
        redisUtils.delete(Constants.REDIS_KEY_CHECK_CODE+checkCodeKey);
    }

    public void saveTokenInfo(TokenUserInfoDto tokenUserInfoDto)
    {
        String token = UUID.randomUUID().toString();
        tokenUserInfoDto.setExpireAt(System.currentTimeMillis()+Constants.REDIS_KEY_EXPIRE_ONE_DAY*7);
        tokenUserInfoDto.setToken(token);

        redisUtils.setex(Constants.TOKEN_WEB+token,tokenUserInfoDto,Constants.REDIS_KEY_EXPIRE_ONE_DAY*7);

    }

    public void cleanToken(String token) {
        redisUtils.delete(Constants.TOKEN_WEB+token);
    }
    public TokenUserInfoDto getTokenInfo(String token)
    {
        return (TokenUserInfoDto) redisUtils.get(Constants.TOKEN_WEB+token);
    }
}
