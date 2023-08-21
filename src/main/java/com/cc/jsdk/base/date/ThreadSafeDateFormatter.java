package com.cc.jsdk.base.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

/**
 * All rights reserved, copyright@cc.hu
 * 线程安全日期格式化
 *
 * @author cc
 * @version 1.0
 * @date 2020/4/27 23:15
 **/
public class ThreadSafeDateFormatter {

    private final ThreadLocal<SimpleDateFormat> THREAD_LOCAL;

    public ThreadSafeDateFormatter(final String pattern) {
        this(pattern, DateTimeConstant.DEFAULT_TIME_ZONE);
    }

    public ThreadSafeDateFormatter(final String pattern, final TimeZone timeZone) {
        this.THREAD_LOCAL = ThreadLocal.withInitial(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setTimeZone(timeZone);
            return sdf;
        });
    }

    /**
     * 格式化时期
     * @param date  日期
     * @return 日期字符串
     */
    public String format(Date date) {
        return this.THREAD_LOCAL.get().format(date);
    }

    /**
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public Date parse(String date) throws ParseException {
        return this.THREAD_LOCAL.get().parse(date);
    }
}
