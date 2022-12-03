package com.yin.thread_demos.mutithread.basic.create;

import com.yin.util.Print;
import com.yin.util.ThreadUtil;

public class CreateDemo2 {

    public static final int MAX_TURN = 5;

    static int threadNo = 1;
    static class RunTarget implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < MAX_TURN; i++) {
                Print.cfo(ThreadUtil.getCurThreadName() + ", 轮次 ：" + i);
            }
            Print.cfo(ThreadUtil.getCurThreadName() + " 运行结束.");
        }
    }

    public static void main(String[] args) {
        Thread thread = null;

        for (int i = 0; i < 2; i++) {
            RunTarget target = new RunTarget();
            thread = new Thread(target, "RunnableThread" + threadNo++);
            thread.start();
        }

        for (int i = 0; i < 2; i++) {
            // 匿名内部类
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j < MAX_TURN; j++) {
                        Print.cfo(ThreadUtil.getCurThreadName() + ", 轮次 :" + j);
                    }
                    Print.cfo(ThreadUtil.getCurThreadName() + " 运行结束.");
                }
            }, "RunnableThread" + threadNo++);
            thread.start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() ->{
                for (int j = 1; j < MAX_TURN; j++) {
                    Print.cfo(ThreadUtil.getCurThreadName() + ", 轮次 ：" + j);
                }
                Print.cfo(ThreadUtil.getCurThreadName() + " 运行结束.");
            }, "RunnableThread" + threadNo++);
            thread.start();
        }
        Print.cfo(ThreadUtil.getCurThreadName() + " 运行结束.");
    }
}
