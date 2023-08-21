package com.cc.jsdk.base.date;

import java.util.TimeZone;

/**
 * All rights reserved, copyright@cc.hu
 *
 * @author cc
 * @date 2019/7/19 23:05
 **/
public class DateTimeConstant {

    private DateTimeConstant() {}

    /**
     * 月日时分秒毫秒格式
     */
    public static String MM_DD_HH_MM_SS = "MMddHHmmss";

    /**
     * 当前默认时区
     */
    public static TimeZone DEFAULT_TIME_ZONE = TimeZone.getDefault();
}
