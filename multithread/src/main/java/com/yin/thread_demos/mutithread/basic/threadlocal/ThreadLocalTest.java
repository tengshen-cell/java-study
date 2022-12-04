package com.yin.thread_demos.mutithread.basic.threadlocal;

import com.yin.util.Print;
import com.yin.util.ThreadUtil;
import lombok.Data;
import org.junit.Test;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/12/3 18:47
 */
public class ThreadLocalTest {
    @Data
    static class Foo {
        // total number of instances
        static final AtomicInteger AMOUNT = new AtomicInteger(0);
        //
        int index = 0;
        int bar = 10;

        //constructor
        public Foo() {
            index = AMOUNT.incrementAndGet();
        }

        public String toString() {
            return index + "@Too{bar=" + bar + '}';
        }
    }

    // define thread local variables
    private static final ThreadLocal<Foo> LOCAL_FOO = new ThreadLocal<Foo>();

    @Test
    public void testThreadLocal() {
        //
        ThreadPoolExecutor threadPool = ThreadUtil.getMixedTargetThreadPool();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    if (LOCAL_FOO.get() == null) {
                        LOCAL_FOO.set(new Foo());
                    }

                    Print.tco("初始的本地值" + LOCAL_FOO.get());
                    for (int i = 0; i < 10; i++) {
                        Foo foo = LOCAL_FOO.get();
                        foo.setBar(foo.getBar() + 1);
                        ThreadUtil.sleepSeconds(10);
                    }

                    Print.tco("累加10次之后的本地值：" + LOCAL_FOO.get());
                    LOCAL_FOO.remove();
                }
            });
        }
        ThreadUtil.sleepMilliSeconds(Integer.MAX_VALUE);
    }



}
