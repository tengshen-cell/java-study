package com.yin.thread_demos.mutithread.basic.create;

import com.yin.util.Print;
import com.yin.util.ThreadUtil;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/12/3 9:04
 */
public class CreateDemo4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.execute(new DemoThread());

        pool.execute(new Runnable() {
            @Override
            public void run() {
                for (int j = 1; j < MAX_TURN; j++) {
                    Print.cfo(ThreadUtil.getCurThreadName() + ", 轮次：" + j);
                    ThreadUtil.sleepMilliSeconds(10);
                }
            }
        });

        Future<Long> future = pool.submit(new ReturnableTask());
        Long result = future.get();
        Print.cfo("");
        ThreadUtil.sleepSeconds(Integer.MAX_VALUE);
    }
    static class DemoThread implements Runnable {
        @Override
        public void run() {
            for (int j = 1; j < MAX_TURN; j++) {
                Print.cfo(ThreadUtil.getCurThreadName() + ", 轮次：" + j);
                ThreadUtil.sleepMilliSeconds(10);
            }
        }
    }

    public static final int MAX_TURN = 5;
    public static final int COMPUTE_TIMES = 100000000;

    static class ReturnableTask implements Callable<Long> {

        @Override
        public Long call() throws Exception {
            Long startTime = System.currentTimeMillis();
            Print.cfo(ThreadUtil.getCurThreadName() + "线程运行开始.");
            for (int j = 0; j < MAX_TURN; j++) {
                Print.cfo(ThreadUtil.getCurThreadName() + " 线程运行开始.");
            }
            Long used = System.currentTimeMillis() - startTime;
            Print.cfo(ThreadUtil.getCurThreadName() + " 线程运行结束.");
            return used;
        }
    }

}
