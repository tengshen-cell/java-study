package com.yin.thread_demos.plus;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/12/4 10:27
 */
public class SafeStaticMethodPlus {
    private static Integer amount = 0;

    public static synchronized void selfPlus() {
        amount++;
    }

    public Integer getAmount() {
        return amount;
    }
}
