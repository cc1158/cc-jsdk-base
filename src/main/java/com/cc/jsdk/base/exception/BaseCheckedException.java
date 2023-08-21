package com.cc.jsdk.base.exception;

/**
 * All rights reserved, copyright@cc.hu
 *
 * @author cc
 * @version 1.0
 * @date 2019/7/19 23:05
 **/
public class BaseCheckedException extends RuntimeException {

    enum ErrorCode {

        /**
         * 业务异常
         */
        BusinessError(560, "业务异常"),

        /**
         * 参数异常
         */
        InvalidParam(400, "参数异常"),

        /**
         * 非法token异常
         */
        InvalidToken(490, "非法token异常"),

        /**
         * rt过期
         */
        RefreshTokenExpired(492, "rt过期异常"),

        /**
         * 会话过期
         */
        SessionExpired(499, "会话过期"),

        /**
         * at过期异常
         */
        AccessTokenExpired(491, "at过期异常"),

        /**
         * 无权限异常
         */
        UnauthorizedError(401, "无权限异常"),

        /**
         * 服务端异常
         */
        UnknownServerError(500, "服务端异常"),
        ;

        private final int code;

        private final String desc;

        ErrorCode(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }

    static final int MAX_GROUP_ID = 9;

    static final int MAX_SERVICE_ID = 999;

    static final int MAX_CODE_ID = 999;

    private int code;

    private String defaultMessage;

    private String i18nCode;

    private Object[] args;

    private String i18nMessage;

    static int combineErrorCode(int groupId, int serviceId, int code) {
        if (groupId <= 0 || groupId > MAX_GROUP_ID) {
            throw new IllegalArgumentException("组织代号越界");
        }
        if (serviceId <= 0 || serviceId > MAX_SERVICE_ID) {
            throw new IllegalArgumentException("服务编号越界");
        }
        if (code <= 0 || code > MAX_CODE_ID) {
            throw new IllegalArgumentException("错误编号越界");
        }
        return groupId * 1000000 + serviceId * 1000 + code;
    }

    public BaseCheckedException(int groupId, int serviceId, int codeId) {
        super("");
        this.code = combineErrorCode(groupId, serviceId, codeId);
    }

    public BaseCheckedException(int groupId, int serviceId, int codeId, String defaultMessage) {
        super(defaultMessage);
        this.code = combineErrorCode(groupId, serviceId, codeId);
        this.defaultMessage = defaultMessage;
    }

    public BaseCheckedException(int groupId, int serviceId, int codeId, String defaultMessage, String i18nCode) {
        super(defaultMessage);
        this.code = combineErrorCode(groupId, serviceId, codeId);
        this.defaultMessage = defaultMessage;
        this.i18nCode = i18nCode;
    }

    public BaseCheckedException(int groupId, int serviceId, int codeId, String defaultMessage, String i18nCode, Object[] args) {
        super(defaultMessage);
        this.code = combineErrorCode(groupId, serviceId, codeId);
        this.defaultMessage = defaultMessage;
        this.i18nCode = i18nCode;
        this.args = args;
    }

    public BaseCheckedException(int groupId, int serviceId, int codeId, String defaultMessage, String i18nCode, Throwable e) {
        super(defaultMessage, e);
        this.code = combineErrorCode(groupId, serviceId, codeId);
        this.defaultMessage = defaultMessage;
        this.i18nCode = i18nCode;
    }

    protected BaseCheckedException(int code, String defaultMessage, String i18nCode, Throwable e) {
        super(defaultMessage, e);
        this.code = code;
        this.defaultMessage = defaultMessage;
        this.i18nCode = i18nCode;
    }

    public int getCode() {
        return code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public String getI18nCode() {
        return i18nCode;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getI18nMessage() {
        return i18nMessage;
    }

    public void setI18nMessage(String i18nMessage) {
        this.i18nMessage = i18nMessage;
    }
}
