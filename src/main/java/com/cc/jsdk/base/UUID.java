package com.cc.jsdk.base;

import com.cc.jsdk.base.date.DateTimeConstant;
import com.cc.jsdk.base.date.ThreadSafeDateFormatter;

import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * All rights reserved, copyright@cc.hu
 *
 * @author cc
 * @date 2019/7/19 23:05
 **/
public class UUID {

    /**
     * 随机数uuId
     *
     * @return
     */
    public static String randomUuId() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 根据日期字符串生成20位uuId
     *
     * @return
     */
    public static String uuId() {
        return uuId("");
    }

    /**
     * 根据前缀生成20位id
     *
     * @param prefix  前缀字符
     * @return  uuid
     */
    public static String uuId(String prefix) {
        return uuId(prefix, DateTimeConstant.MM_DD_HH_MM_SS, 20);
    }

    /**
     * 根据日期生成指定长度字符串
     *
     * @param prefix 前缀
     * @param pattern 日期格式
     * @param length 长度
     * @return uuid字符串
     */
    public static String uuId(String prefix, String pattern, int length) {
        return UUID_INSTANCE.gen(prefix, pattern, length);
    }

    private static final UUID UUID_INSTANCE = new UUID();

    private static AtomicLong SERIAL_COUNT = new AtomicLong(0);

    private final Long SERIAL_COUNT_MAX = 9999L;

    private final Random RANDOM = new Random();

    private UUID() {}

    private String gen(String prefix, String pattern, int len) {
        /*日期部分*/
        String datePartStr = new ThreadSafeDateFormatter(pattern).format(new Date());
        if (datePartStr.length() >= len) {
            return datePartStr.substring(0, len);
        }
        /*序列部分*/
        int serialPartLen = Math.min(len - datePartStr.length(), 4);
        String serialPartStr = genSerialPart(serialPartLen);
        int randomPartLen = len - datePartStr.length() - serialPartLen;
        if (randomPartLen == 0) {
            return datePartStr + serialPartStr;
        }
        /*随机部分*/
        String randomPartStr = genRandomPart(randomPartLen);
        return prefix + datePartStr + serialPartStr + randomPartStr;
    }

    private String genSerialPart(int len) {
        if (len <= 0) {
            return "";
        }
        if (SERIAL_COUNT.get() > SERIAL_COUNT_MAX) {
            SERIAL_COUNT.set(0);
        }
        String serialStr = String.valueOf(SERIAL_COUNT.addAndGet(1));
        if (serialStr.length() >= len) {
            return serialStr.substring(0, len);
        }
        char[] filled = fill(serialStr, '0', len, false);
        return new String(filled);
    }

    private String genRandomPart(int len) {
        if (len <= 0) {
            return "";
        }
        int pow;
        while (true) {
            pow = RANDOM.nextInt(len);
            if (pow > 0) {
                break;
            }
        }
        int rndInt = (int) (Math.random() * Math.pow(10, pow));
        char[] filled = fill(String.valueOf(rndInt), null, len, true);
        return new String(filled);
    }

    private char[] fill(String original, Character fillChar, int len, boolean suffixFill) {
        if (original.length() >= len) {
            return original.substring(0, len).toCharArray();
        }
        char[] originalChars = original.toCharArray();
        char[] ret = new char[len];
        int copyFrom, fillFrom, fillEnd;
        if (suffixFill) {
            copyFrom = 0;
            fillFrom = originalChars.length;
            fillEnd = ret.length;
        } else {
            copyFrom = len - originalChars.length;
            fillFrom = 0;
            fillEnd = len - originalChars.length;
        }
        System.arraycopy(originalChars, 0, ret, copyFrom, originalChars.length);
        for (int i = fillFrom; i < fillEnd; i++) {
            ret[i] = getFillCharacter(fillChar);
        }
        return ret;
    }

    private char getFillCharacter(Character fillChar) {
        if (Objects.nonNull(fillChar)) {
            return fillChar;
        }
        return BaseConstant.DECIMAL_DIGITAL[RANDOM.nextInt(BaseConstant.DECIMAL_DIGITAL.length)];
    }
}
