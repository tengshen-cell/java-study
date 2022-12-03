package com.yin.thread_demos.mutithread.basic.use;

import com.yin.util.Print;
import com.yin.util.ThreadUtil;
import org.junit.Test;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/12/3 14:13
 */
public class InterruptDemo {
    public static final int SLEEP_GAP = 5000;
    public static final int MAX_TURN = 50;

    static class SleepThread extends Thread {
        static int threadSeqNumber = 1;

        public SleepThread() {
            super("sleepThread-" + threadSeqNumber);
            threadSeqNumber++;
        }

        public void run() {
            try {
                Print.tco(getName() + "进入睡眠.");
                Thread.sleep(SLEEP_GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Print.tco(getName() + " 发生被异常打断.");
                return;
            }
            Print.tco(getName() + " 运行结束.");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new SleepThread();
        thread1.start();

        Thread thread2 = new SleepThread();
        thread2.start();

        // 打断线程
        thread1.interrupt();
        ThreadUtil.sleepSeconds(5);
        thread2.interrupt();
        ThreadUtil.sleepSeconds(1);
        Print.tco("程序运行结束.");
    }

    @Test
    public void testInterrupted2() {
        Thread thread = new Thread() {
            public void run() {
                Print.tco("线程启动了");
                while (true) {
                    Print.tco(isInterrupted());
                    ThreadUtil.sleepMilliSeconds(SLEEP_GAP);

                    if (isInterrupted()) {
                        Print.tco("线程结束了");
                        return;
                    }
                }
            }
        };
        thread.start();
        ThreadUtil.sleepSeconds(2);
        thread.interrupt();
        ThreadUtil.sleepSeconds(2);
        thread.interrupt();
    }
}
