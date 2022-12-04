package com.yin.thread_demos.plus;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/12/4 10:10
 */
public class SafePlus {
    private Integer amount = 0;
    public void selfPlus() {
        synchronized (this) {
            amount++;
        }
    }

    public Integer getAmount() {
        return amount;
    }
}
