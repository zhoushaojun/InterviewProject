package com.interview.synchronize;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorCompletionService
 * 使用BlockingQueue 进行阻塞，新完成的队列会存放到BlockingQueue
 * 会返回第一个完成的线程数据
 * @author zhoushaojun
 *
 */
public class ExecutorCompletingServiceUsage {
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);
    private static CompletionService completionService = new ExecutorCompletionService(executorService);
    
    public static void completeService() throws InterruptedException, ExecutionException{
        for(int i =0; i< 5;i++){
            completionService.submit(new CompleteCallable(i));
        }
        for(int i =0; i< 5;i++){
            System.out.println("result : "+completionService.take().get());
        }
        executorService.shutdown();
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        completeService();
    }
}
class CompleteCallable implements Callable<String>{
    private int id;
    public CompleteCallable(int id) {
        this.id = id;
    }
    
    public String call() throws Exception {
        if(id <= 3){
            Thread.sleep(10000);
        }else {
            Thread.sleep(1000);
        }
        return "My id "+ id+":complete";
    }
    
}