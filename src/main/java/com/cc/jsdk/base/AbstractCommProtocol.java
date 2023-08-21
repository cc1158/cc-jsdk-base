package com.cc.jsdk.base;

import java.util.Date;

/**
 * All rights reserved, copyright@cc.hu
 * 网络通信的协议基础接口
 *
 * @author cc
 * @version 1.0
 * @date 2020/3/14 16:28
 **/
public abstract class AbstractCommProtocol<T> {

    /**
     * 写入字节类型
     *
     * @param b 字节
     */
    protected abstract void writeByte(byte b);

    /**
     * 写入字符
     *
     * @param ch 字符
     */
    protected abstract void writeCharacter(char ch);

    /**
     * 写入字符串
     *
     * @param str 字符串
     */
    protected abstract void writeString(String str);

    /**
     * 写入布尔值
     *
     * @param bool 布尔
     */
    protected abstract void writeBoolean(boolean bool);

    /**
     * 写入int 16位
     *
     * @param i16 int
     */
    protected abstract void writeInt16(short i16);

    /**
     * 写入int 32位
     *
     * @param i32 int
     */
    protected abstract void writeInt32(int i32);

    /**
     * 写入64位int
     *
     * @param i64 64位int
     */
    protected abstract void writeInt64(long i64);

    /**
     * 写入双精度
     *
     * @param dou 双精度值
     */
    protected abstract void writeDouble(double dou);

    /**
     * 写入日期
     *
     * @param date 日期值
     */
    protected abstract void writeDate(Date date);

    /**
     * 读取一个字节
     *
     * @return 字节
     */
    protected abstract byte readByte();

    /**
     * 读取包装字符
     *
     * @return 字符
     */
    protected abstract char readCharacter();

    /**
     * 读取字符串
     *
     * @return 字符串
     */
    protected abstract String readString();

    /**
     * 读取bool
     *
     * @return boolean
     */
    protected abstract boolean readBoolean();

    /**
     * 读取16位整型
     *
     * @return int值
     */
    protected abstract short readInt16();

    /**
     * 读取32位整型
     *
     * @return 32int值
     */
    protected abstract int readInt32();

    /**
     * 读取长整型
     *
     * @return 64int
     */
    protected abstract long readInt64();

    /**
     * 读取一个双精度
     *
     * @return double
     */
    protected abstract double readDouble();

    /**
     * 读取日期
     *
     * @return 日期
     */
    protected abstract Date readDate();

    /**
     * 写入消息
     *
     * @param msg 消息
     */
    public abstract void writeMsg(T msg);

    /**
     * 读取一条消息
     *
     * @return 读取一条消息
     */
    public abstract T readMsg();
}
