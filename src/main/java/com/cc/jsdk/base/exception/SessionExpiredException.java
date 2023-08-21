package com.cc.jsdk.base.exception;

/**
 * All rights reserved, copyright@cc.hu
 * session过期
 *
 * @author cc
 * @version 1.0
 * @date 2021/2/8 13:34
 **/
public class SessionExpiredException extends BaseCheckedException {

    public SessionExpiredException(String defaultMessage, String i18nCode, Throwable e) {
        super(ErrorCode.SessionExpired.getCode(), defaultMessage, i18nCode, e);
    }
}
