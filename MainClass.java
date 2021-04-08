package com.Assignment2.ThreadPool;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;


public class MainClass {
    public static void rejectionHandle(){
        System.out.println("\nHandle the Rejection:::");
        int csize=1;
        int msize=3;
        int kalive=10;
        int qsize=2;
        ThreadFactory threadFactory=Executors.defaultThreadFactory();
        ThreadPoolExecutor executorService=new ThreadPoolExecutor(csize,msize,kalive,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(qsize),threadFactory,new RejectionHandler());
        for(int i=0;i<10;i++){
            Runnable r=new ThreadPool(i);
            executorService.execute(r);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){}
    }
    public static void runnable(){
        System.out.println("\nRunnable:::");
        ThreadPoolExecutor executorService= (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        //ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(2,4,10);
        for(int i=0;i<10;i++){
            Runnable r=new ThreadPool(i);
            executorService.execute(r);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println("Active Thread Count-->"+executorService.getActiveCount());
            System.out.println("Pool Size-->"+executorService.getPoolSize());
            System.out.println("Task Count-->"+executorService.getTaskCount());
            System.out.println();
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){}
    }
    public static void callable() throws ExecutionException, InterruptedException {
        System.out.println("\nCallable:::");
        ThreadPoolExecutor executorService1= (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        ArrayList<ThreadPoolUsingCallable> li=new ArrayList<ThreadPoolUsingCallable>();
        li.add(new ThreadPoolUsingCallable(4,5));
        li.add(new ThreadPoolUsingCallable(19,32));
        li.add(new ThreadPoolUsingCallable(199,150));
        li.add(new ThreadPoolUsingCallable(38,22));
        li.add(new ThreadPoolUsingCallable(128,127));
        li.add(new ThreadPoolUsingCallable(777,999));
        for(ThreadPoolUsingCallable i:li){
            Future f=executorService1.submit(i);
            System.out.println(f.get());
        }
        executorService1.shutdown();
        while (!executorService1.isTerminated()){}
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        rejectionHandle();
        runnable();
        callable();
//        Properties p=System.getProperties();
//        System.out.println(p);
        System.out.println("\n<---All Thread Runned Sucessfully--->\n");
    }
}
