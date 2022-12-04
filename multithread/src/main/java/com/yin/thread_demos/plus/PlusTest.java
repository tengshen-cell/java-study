package com.yin.thread_demos.plus;

import com.yin.util.Print;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class PlusTest {
    final int MAX_TREAD = 10;
    final int MAX_TURN = 1000;

    CountDownLatch latch = new CountDownLatch(MAX_TREAD);

    @Test
    public void testNotSafePlus() throws InterruptedException {
        NotSafePlus counter = new NotSafePlus();
        Runnable runnable = () -> {
            for (int i = 0; i < MAX_TURN; i++) {
                counter.selfPlus();
            }
            latch.countDown();
        };

        for (int i = 0; i < MAX_TREAD; i++) {
            new Thread(runnable).start();
        }
        latch.await();

        Print.tcfo("理论结果：" + MAX_TURN * MAX_TREAD);
        Print.tcfo("实际结果：" + counter.getAmount());
        Print.tcfo("差距是：" + (MAX_TURN * MAX_TREAD -counter.getAmount()));

    }

    @Test
    public void testSafePlus() throws InterruptedException {
        SafePlus counter = new SafePlus();
        Runnable runnable = () -> {
            for (int i = 0; i < MAX_TURN; i++) {
                counter.selfPlus();
            }
            latch.countDown();
        };
        for (int i = 0; i < MAX_TREAD; i++) {
            new Thread(runnable).start();
        }

        latch.await();
        Print.tcfo("理论结果：" + MAX_TURN * MAX_TREAD);
        Print.tcfo("实际结果：" + counter.getAmount());
        Print.tcfo("差距是：" + (MAX_TURN * MAX_TREAD -counter.getAmount()));

    }
}
