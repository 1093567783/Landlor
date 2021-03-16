package com.lym.model.common;

import java.io.Serializable;

/**
 * @Author LYM
 * @Description 常量类
 * @Date 2021/1/27
 * @Version v1.0.0
 **/
public class Constant implements Serializable {
    /**
     * 可用类型
     */
    public static final Integer AVAILABLE_TRUE = 1;
    public static final Integer AVAILABLE_FALSE = 0;

    public static final String Leave_KEY = "leaveBill";
    public static final String CONTRACT_KEY="CONTRACT";
    public static final String CARD_ID = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
            "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
    public static final String PHONE_PATTERN = "^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$";
    public static final String EMAIL_PATTERN="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
}
