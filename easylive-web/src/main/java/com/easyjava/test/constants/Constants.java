package com.easyjava.test.constants;

public class Constants {
    public static final Integer REDIS_KEY_EXPIRE_ONE_MIN = 60000;
    public static final Integer REDIS_KEY_EXPIRE_ONE_DAY = REDIS_KEY_EXPIRE_ONE_MIN*60*24;
    public static final Integer LENGTH_10 = 10;


    public static final String REGEX_PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$";
    public static final  String REDIS_KEY_PREFIX = "easyjava:";
    public static final  String REDIS_KEY_CHECK_CODE = REDIS_KEY_PREFIX + "checkCode:";
    public static final  String TOKEN_WEB ="token:";

    public static final Integer ONE = 1;
}
