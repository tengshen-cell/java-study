package com.yin.thread_demos.plus;

public class NotSafePlus {

    private Integer amount = 0;
    public void selfPlus() {
        amount++;
    }

    public Integer getAmount() {
        return  amount;
    }
}
