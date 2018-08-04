package com.java.maven.test.example;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorTest {

    /**
     * 我们获取四次次线程，观察4个线程地址
     * @param args
     */
    public static  void main(String[]args)
    {
        //ExecutorService executor = Executors.newCachedThreadPool();
        int core=2;
        int mix=4;
        //ExecutorService executor  = new ThreadPoolExecutor(core, mix,
        ThreadPoolExecutor executor  = new ThreadPoolExecutor(core, mix,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        System.out.println("****************************ThreadPoolExecutor*******************************");

        try {
            for(int i=0;i<8;i++)
            {
                final int index=i;
                ThreadExecutorTest test=new ThreadExecutorTest();
                executor.execute(test.new MyTask(index));
                System.out.println("PoolSize: " + executor.getPoolSize() +
                        ", Queue：" + executor.getQueue().size() +
                        ", Active：" + executor.getActiveCount() +
                        ", Task：" + executor.getTaskCount() +
                        ", Completed：" + executor.getCompletedTaskCount());
            }
        }
        finally{executor.shutdown();}

    }

    class MyTask implements Runnable{
        private Integer index;
        public  MyTask(Integer index)
        {
            this.index=index;
        }
        @Override
        public void run() {
            try {
                System.out.println("Enter Thread "+ index + " " + Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("Exit Thread："+ index + " " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
