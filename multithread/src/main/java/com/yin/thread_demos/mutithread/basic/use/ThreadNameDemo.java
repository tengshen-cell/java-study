package com.yin.thread_demos.mutithread.basic.use;

import com.yin.util.Print;
import com.yin.util.ThreadUtil;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/12/3 10:57
 */
public class ThreadNameDemo {
    private static final int MAX_TURN = 3;

    static class RunTarget implements Runnable {

        @Override
        public void run() {
            for (int turn = 0; turn < MAX_TURN; turn++) {
                ThreadUtil.sleepMilliSeconds(500);
                Print.tco("线程执行轮次：" + turn);
            }
        }
    }
    public static void main(String[] args) {
        RunTarget target = new RunTarget();
        new Thread(target).start();
        new Thread(target).start();
        new Thread(target).start();

        new Thread(target, "唐翠-A").start();
        new Thread(target, "唐翠-B").start();

        ThreadUtil.sleepSeconds(Integer.MAX_VALUE);
    }
}
