package com.interview.synchronize;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTaskUsage {
    
    private static FutureTask futureTask = null;

    /**
     *  FutureTask 用于单个线程启动，利用future阻塞等待结果
     * @throws Exception
     */
    public static void futureUsage() throws Exception{
        FutureRunable futureRunable = new FutureRunable("beijing");
        futureTask = new FutureTask<String>(futureRunable);
        new Thread(futureTask).start();
        while(!futureTask.isDone()){
            System.out.println("wait for result.....");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
        System.out.println(futureTask.get());
    }
    public static void main(String[] args) throws Exception {
        futureUsage();
    }
}
class FutureRunable implements Callable<String> {
    private String command;
    
    public FutureRunable(String s){
        this.command=s;
    }
 
    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    public String toString(){
        return this.command;
    }

    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" Start. Time = "+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End. Time = "+new Date());
        return "lengjing";
    }
}
