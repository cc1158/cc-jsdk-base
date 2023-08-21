package com.cc.jsdk.base.exception;

/**
 * All rights reserved, copyright@cc.hu
 * refreshtoken 过期异常
 * @author cc
 * @version 1.0
 * @date 2021/2/8 13:36
 **/
public class RefreshTokenExpiredException extends BaseCheckedException {

    public RefreshTokenExpiredException(String defaultMessage, String i18nCode, Throwable e) {
        super(ErrorCode.RefreshTokenExpired.getCode(), defaultMessage, i18nCode, e);
    }
}
