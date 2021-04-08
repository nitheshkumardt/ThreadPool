package com.Assignment2.ThreadPool;

import java.util.concurrent.Callable;

public class ThreadPoolUsingCallable implements Callable {
    private int n1;
    private int n2;

    public ThreadPoolUsingCallable(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public Object call() throws Exception {
        int op;
        System.out.println(Thread.currentThread().getName());
        if(n1>n2){
            op=n1+n2;
            System.out.println("Addition of two numbers using Thread");
        }
        else{
            op=n2-n1;
            System.out.println("Subration of two numbers using Thread");
        }
        return op;
    }
}
