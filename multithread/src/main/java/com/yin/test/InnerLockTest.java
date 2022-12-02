package com.yin.test;

import com.yin.util.Print;
import org.openjdk.jol.vm.VM;

import java.util.concurrent.CountDownLatch;

import static com.yin.util.ThreadUtil.sleepMilliSeconds;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/12/2 9:36
 */
public class InnerLockTest {

    @org.junit.Test
    public void showBiasedLock() throws InterruptedException
    {
        Print.tcfo(VM.current().details());
        //JVM延迟偏向锁
        sleepMilliSeconds(5000);

        //ObjectLock counter = new ObjectLock();

        Print.tcfo("抢占锁前, lock的状态: ");
        //lock.printObjectStruct();

       /* sleepMilliSeconds(5000);
        CountDownLatch latch = new CountDownLatch(1);
        Runnable runnable = () ->
        {
            for (int i = 0; i < MAX_TURN; i++)
            {
                synchronized (lock)
                {
                    lock.increase();
                    if (i == MAX_TURN / 2)
                    {
                        Print.tcfo("占有锁, lock的状态: ");
                        lock.printObjectStruct();
                    }
                }
                //每一次循环等待10毫秒
                sleepMilliSeconds(10);
            }
            latch.countDown();
        };
        new Thread(runnable, "biased-demothread").start();
        //等待加锁线程执行完成
        latch.await();
        sleepMilliSeconds(5000);
        Print.tcfo("释放锁后, lock的状态: ");
        lock.printObjectStruct();*/
    }
    // 省略不相干代码
}

