package com.yin.thread_demos.mutithread.basic.create;

import com.yin.util.Print;
import com.yin.util.ThreadUtil;

public class EmptyThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread();
        Print.cfo("线程名称 ：" + thread.getName());
        Print.cfo("线程 ：" + thread.getId());
        Print.cfo("线程状态：" + thread.getState());
        Print.cfo("线程优先级：" + thread.getPriority());

        thread.start();
        Print.cfo("线程状态：" + thread.getState());

        ThreadUtil.sleepMilliSeconds(10);
    }
}
