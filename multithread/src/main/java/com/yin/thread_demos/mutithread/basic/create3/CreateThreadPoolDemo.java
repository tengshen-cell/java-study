package com.yin.thread_demos.mutithread.basic.create3;

import com.yin.util.Print;
import com.yin.util.ThreadUtil;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/12/3 14:44
 */
public class CreateThreadPoolDemo {

    public static final int SLEEP_GAP = 500;
    public static final int MAX_TURN = 5;

    // 异步的执行目标类
    public static class TargetTask implements Runnable {

        static AtomicInteger taskNo = new AtomicInteger(1);
        protected String taskName;

        public TargetTask() {
            taskName = "task-" + taskNo.get();
            taskNo.incrementAndGet();
        }

        @Override
        public void run() {
            Print.tco("任务：" + taskName + " doing");
            ThreadUtil.sleepMilliSeconds(SLEEP_GAP);
            Print.tco(taskName + " 运行结束。");
        }

        public String toString() {
            return "TargetTask{" + taskName + '}';
        }
    }

    static class TargetTaskWithError extends TargetTask {
        @Override
        public void run() {
            super.run();
            throw new RuntimeException("Error from" + taskName);
        }
    }

    @Test
    public void testSingleThreadExecutor() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            pool.execute(new TargetTask());
            pool.submit(new TargetTask());
        }

        ThreadUtil.sleepSeconds(1000);
        pool.shutdown();
    }

    @Test
    public void testNewCacheThreadPool() {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            pool.execute(new TargetTask());
            pool.submit(new TargetTask());
        }

        ThreadUtil.sleepSeconds(1000);
        pool.shutdown();
    }

    @Test
    public void testNewScheduledThreadPool() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < 2; i++) {
            scheduledExecutorService.scheduleAtFixedRate(new TargetTask(),
                    0, 500, TimeUnit.MILLISECONDS);
        }
        ThreadUtil.sleepSeconds(1000);
        scheduledExecutorService.shutdown();
    }

    @Test
    public void testNewScheduledThreadPool2() {
        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(0);
        for (int i = 0; i < 2; i++) {
            scheduled.scheduleAtFixedRate(new TargetTask(),
                    0, 500, TimeUnit.MILLISECONDS);
            //以上的参数中：
            // 0表示首次执行任务的延迟时间，500表示每次执行任务的间隔时间
            //TimeUnit.MILLISECONDS所设置的时间的计时单位为毫秒
        }
        ThreadUtil.sleepSeconds(1000);
        //关闭线程池
        scheduled.shutdown();
    }

    @Test
    public void testThreadPoolExecutor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                100,
                100,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(100)
        );

        for (int i = 0; i < 5; i++) {
            final  int taskIndex = i;
            executor.execute(() -> {
                Print.tco("taskIndex = " + taskIndex);
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        while (true) {
            Print.tco("- activeCount:" + executor.getActiveCount() +
                    " - taskCount:" + executor.getTaskCount());
            ThreadUtil.sleepSeconds(1);
        }
    }

    // 一个简单的线程工厂
    static public class SimpleThreadFactory implements ThreadFactory {
        static AtomicInteger threadNo = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            String threadName = "simpleThread-" + threadNo.get();
            Print.tco("创建一条线程，名称为：" + threadName);
            threadNo.incrementAndGet();
            Thread thread = new Thread(r, threadName);
            //设置为守护线程
            thread.setDaemon(true);
            return thread;
        }
    }

    @Test
    public void testThreadFactory() {
        ExecutorService pool = Executors.newFixedThreadPool(2, new SimpleThreadFactory());
        for (int i = 0; i < 5; i++) {
            pool.submit(new TargetTask());
        }

        ThreadUtil.sleepSeconds(10);
        Print.tco("关闭线程池");
        pool.shutdown();

    }

    @Test
    public void testSubmit() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        // pool.execute(new Ta);
    }

    private static final ThreadLocal<Long> START_TIME = new ThreadLocal<>();

    @Test
    public void testHooks() {
        ExecutorService pool = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2)){
                    protected void terminated() {
                        Print.tco("调度器已经终止！");
                    }
                    @Override
                    protected void beforeExecute(Thread t, Runnable target) {
                        Print.tco(target + "前钩子被执行");
                        START_TIME.set(System.currentTimeMillis());
                        super.beforeExecute(t, target);
                    }

                    protected void afterExecute(Runnable target, Throwable t) {
                        super.afterExecute(target, t);

                        long time = System.currentTimeMillis() - START_TIME.get();
                        Print.tco(target + " 后沟子被执行，任务执行时长 (ms) :" + time);
                        START_TIME.remove();
                    }
                };
        pool.execute(new TargetTask());
        ThreadUtil.sleepSeconds(10);
        Print.tco("关闭线程池");
        pool.shutdown();
    }
}
