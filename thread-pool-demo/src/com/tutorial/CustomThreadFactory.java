package com.tutorial;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
    static volatile int i;

    @Override
    public synchronized Thread newThread(Runnable r) {
        i++;
        return new Thread(r, "pool-1-thread-" + i);
    }
}
