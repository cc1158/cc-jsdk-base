package com.cc.jsdk.base.exception;

/**
 * 未知的服务器异常
 *
 * @author cc
 * @version 1.0
 * @date 2019/7/19 23:05
 */
public class UnknownServerException extends BaseCheckedException {

    public UnknownServerException(String defaultMessage, String i18nCode, Throwable e) {
        super(ErrorCode.UnknownServerError.getCode(), defaultMessage, i18nCode, e);
    }
}
