package com.yin.thread_demos.mutithread.basic.create;

import com.yin.util.Print;
import com.yin.util.ThreadUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/12/3 7:34
 */
public class SalesDemo {
    public static final int MAX_AMOUNT = 5;

    static class StoreGoods extends Thread {
        StoreGoods(String name) {
            super(name);
        }

        private int goodsAmount = MAX_AMOUNT;

        public void run() {
            for (int i = 0; i <= MAX_AMOUNT ; i++) {
                if (this.goodsAmount > 0) {
                    Print.cfo(ThreadUtil.getCurThreadName() + " 卖出一件，还剩："
                            + (--goodsAmount));
                    ThreadUtil.sleepMilliSeconds(10);
                }
            }
            Print.cfo(ThreadUtil.getCurThreadName() + " 运行结束.");
        }
    }

    static class MallGoods implements Runnable {

        private AtomicInteger goodsAmount = new AtomicInteger(MAX_AMOUNT);
        @Override
        public void run() {
            for (int i = 0; i < MAX_AMOUNT; i++) {
                if (this.goodsAmount.get() > 0) {
                    Print.cfo(ThreadUtil.getCurThreadName() + " 卖出一件， 还剩："
                             + (goodsAmount.decrementAndGet()));
                }
            }
            Print.cfo(ThreadUtil.getCurThreadName() + " 运行结束。");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Print.hint("商店版本的销售");
        for (int i = 1; i <= 2 ; i++) {
            Thread thread = null;
            thread = new StoreGoods("店员-" + i);
            thread.start();
        }

        Thread.sleep(1000);
        Print.hint("商店版本的销售");
        MallGoods mallGoods = new MallGoods();
        for (int i = 0; i < 2; i++) {
            Thread thread = null;
            thread = new Thread(mallGoods, "商店销售员-" + i);
            thread.start();
        }

        Print.cfo(ThreadUtil.getCurThreadName() + " 运行结束.");
    }
}
