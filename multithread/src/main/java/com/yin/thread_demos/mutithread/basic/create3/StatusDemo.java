package com.yin.thread_demos.mutithread.basic.create3;

import com.yin.util.Print;
import com.yin.util.ThreadUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/12/3 10:01
 */
public class StatusDemo {

    public static final long MAX_TURN = 5;

    static int threadSeqNumber = 0;

    static List<Thread> threadList = new ArrayList<>();

    private static void printThreadStatus() {
        for (Thread thread : threadList) {
            Print.cfo(thread.getName() + " 状态为 " + thread.getState());
        }
    }

    private static void addStatusThread(Thread thread) {
        threadList.add(thread);
    }

    static class StatusDemoThread extends Thread {
        public StatusDemoThread() {
            super("statusPrintThread" + (++threadSeqNumber));
            addStatusThread(this);
        }

        public void run() {
            Print.tco(getName() + "，状态为" + getState());
            for (int turn = 0; turn < MAX_TURN; turn++) {
                ThreadUtil.sleepMilliSeconds(500);
                printThreadStatus();
            }
            Print.tco(getName() + "- 运行结束.");
        }
    }

    public static void main(String[] args) {
        addStatusThread(Thread.currentThread());

        Thread sThread1 = new StatusDemoThread();
        Print.cfo(sThread1.getName() + "- 状态为" + sThread1.getState());

        Thread sThread2 = new StatusDemoThread();
        Print.cfo(sThread2.getName() + "- 状态为" + sThread2.getState());

        Thread sThread3 = new StatusDemoThread();
        Print.cfo(sThread2.getName() + "- 状态为" + sThread3.getState());

        sThread1.start();

        ThreadUtil.sleepMilliSeconds(500);
        sThread2.start();

        ThreadUtil.sleepMilliSeconds(500);
        sThread3.start();

        ThreadUtil.sleepSeconds(100);
    }

    @Test
    public void testTimedWaiting() {
        final Object lock = new Object();
        synchronized (lock) {
            try {
                lock.wait(30 * 1000);
            } catch (InterruptedException e) {

            }

        }
    }
}
