package com.cc.jsdk.base.exception;

/**
 * All rights reserved, copyright@cc.hu
 * 非法token错误
 *
 * @author cc
 * @version 1.0
 * @date 2021/2/8 13:33
 **/
public class InvalidAccessTokenException extends BaseCheckedException {

    public InvalidAccessTokenException(String defaultMessage, String i18nCode, Throwable e) {
        super(ErrorCode.InvalidToken.getCode(), defaultMessage, i18nCode, e);
    }
}
