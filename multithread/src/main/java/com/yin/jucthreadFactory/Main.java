package com.yin.jucthreadFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {
    public static void main(String[] args) {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadFactory.newThread(new Printer("Good!")).start();
        //threadFactory.newThread(new Printer("Nice")).start();
        for (int i = 0; i < 10000; i++) {
            System.out.print("Nice!");
        }
    }
}
