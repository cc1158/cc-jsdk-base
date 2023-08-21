package com.cc.jsdk.base.exception;

/**
 * unauthorized exception
 *
 * @author cc
 * @version 1.0
 * @date 2019/7/19 23:05
 */
public class UnauthorizedException extends BaseCheckedException {

    public UnauthorizedException(String defaultMessage, String i18nCode, Throwable e) {
        super(ErrorCode.UnauthorizedError.getCode(), defaultMessage, i18nCode, e);
    }
}
