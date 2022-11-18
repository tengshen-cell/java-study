package com.yin.thread_demos.mutithread.basic.create;

import com.yin.util.Print;
import com.yin.util.ThreadUtil;

public class CreateDemo {

    public static final int MAX_TURN = 5;

    static int threadNo = 1;

    static class DemoThread extends Thread {
        public DemoThread() {
            super("Mall-" + threadNo++);
        }

        public void run() {
            for (int i = 1; i < MAX_TURN; i++) {
                Print.cfo(getName() + ", 轮次：" + i);
            }
            Print.cfo(getName() + " 运行结束.");
        }
    }

    public static void main(String args[]) {
        Thread thread = null;

        for (int i = 0; i < 2; i++) {
            thread = new DemoThread();
            thread.start();
        }

        Print.cfo(ThreadUtil.getCurThreadName() + " 运行结束.");
    }
}
