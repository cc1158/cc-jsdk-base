package com.cc.jsdk.base.exception;

/**
 * All rights reserved, copyright@cc.hu
 * 业务异常
 * @author cc
 * @version 1.0
 * @date 2019/7/19 23:05
 **/
public final class BusinessException extends BaseCheckedException {

    public BusinessException(String defaultMessage, String i18nCode, Throwable e) {
        super(ErrorCode.BusinessError.getCode(), defaultMessage, i18nCode, e);
    }
}
