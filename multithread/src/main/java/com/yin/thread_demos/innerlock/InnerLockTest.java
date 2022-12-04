package com.yin.thread_demos.innerlock;

import com.yin.util.Print;
import org.junit.Test;
import org.openjdk.jol.vm.VM;

import java.util.concurrent.CountDownLatch;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/12/4 20:07
 */
public class InnerLockTest {
    final int MAX_TREAD = 10;
    final int MAX_TURN = 1000;

    CountDownLatch latch = new CountDownLatch(MAX_TREAD);

    @Test
    public void showNoLockObject() {
        Print.fo(VM.current().details());

        ObjectLock objectLock = new ObjectLock();
        Print.fo("object status: ");

        objectLock.printSelf();
    }

    static class MyOrder {

    }
}
