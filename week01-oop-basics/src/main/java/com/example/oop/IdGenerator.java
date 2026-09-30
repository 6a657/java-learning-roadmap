package com.example.oop;

import java.util.concurrent.atomic.AtomicLong;

// static属于类，不是对象，所有实例共享一个nextId
public final class IdGenerator {
    private static final AtomicLong COUNTER = new AtomicLong(0);

    // 私有构造器
    private IdGenerator() {
        throw new AssertionError("utility class");
    }

    public static long nextId() {
        return COUNTER.incrementAndGet();
    }
}