package com.cc.jsdk.base;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * All rights reserved, copyright@cc.hu
 * 线程工厂
 *
 * @author cc
 * @version 1.0
 * @date 2020/4/27 22:33
 **/
public final class SimpleThreadFactory implements ThreadFactory {

    /**
     * 线程前缀名称
     */
    private String threadNamePrefix;

    /**
     * 是否为守护线程
     */
    private boolean daemon;

    /**
     * 线程组
     */
    private ThreadGroup threadGroup;

    /**
     * 线程计数器
     */
    private AtomicInteger threadCounter = new AtomicInteger(1);

    public SimpleThreadFactory(String threadNamePrefix) {
        this(threadNamePrefix, false);
    }

    public SimpleThreadFactory(String threadNamePrefix, boolean daemon) {
        this(threadNamePrefix, daemon, null);
    }

    public SimpleThreadFactory(String threadNamePrefix, boolean daemon, ThreadGroup threadGroup) {
        if (Objects.isNull(threadNamePrefix)) {
            throw new IllegalArgumentException("threadNamePrefix不能为空");
        }
        this.threadNamePrefix = threadNamePrefix;
        this.daemon = daemon;
        this.threadGroup = Objects.isNull(threadGroup) ? getThreadGroup() : threadGroup;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.threadGroup, runnable, this.threadNamePrefix + "-" + threadCounter.getAndIncrement());
        thread.setDaemon(daemon);
        return thread;
    }

    private ThreadGroup getThreadGroup() {
        SecurityManager sm = System.getSecurityManager();
        return Objects.nonNull(sm) ? sm.getThreadGroup() : Thread.currentThread().getThreadGroup();
    }
}
