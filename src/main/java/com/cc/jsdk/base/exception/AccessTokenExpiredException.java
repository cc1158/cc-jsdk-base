package com.cc.jsdk.base.exception;

/**
 * All rights reserved, copyright@cc.hu
 * token过期异常
 *
 * @author cc
 * @version 1.0
 * @date 2021/2/8 13:37
 **/
public class AccessTokenExpiredException extends BaseCheckedException {

    public AccessTokenExpiredException(String defaultMessage, String i18nCode, Throwable e) {
        super(ErrorCode.AccessTokenExpired.getCode(), defaultMessage, i18nCode, e);
    }
}
