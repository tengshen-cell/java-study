package com.yin.thread_demos.mutithread.basic.use;

import com.yin.util.JvmUtil;
import com.yin.util.Logger;
import com.yin.util.Print;
import com.yin.util.ThreadUtil;
import org.junit.Test;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/12/3 13:46
 */
public class SleepDemo {
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
                for (int i = 0; i < MAX_TURN; i++) {
                    Print.tco(getName() + ", 睡眠轮次：" + i);
                    Thread.sleep(SLEEP_GAP);
                }
            } catch (InterruptedException e) {
                Print.tco(getName() + " 发生异常被中断.");
            }

            Print.tco(getName() + " 运行结束。");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new SleepThread();
            thread.start();
        }
        Print.tco(ThreadUtil.getCurThreadName() + " 运行结束.");
    }

    @Test
    public void sleepForever() {
        Logger.cfo("进程ID=" + JvmUtil.getProcessID());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
