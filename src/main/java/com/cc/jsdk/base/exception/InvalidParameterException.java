package com.cc.jsdk.base.exception;

/**
 * @author cc
 * Create at 2023-08-21
 */
public class InvalidParameterException extends BaseCheckedException {

    protected InvalidParameterException(String defaultMessage, String i18nCode) {
        super(ErrorCode.InvalidToken.getCode(), defaultMessage, i18nCode, null);
    }
}
