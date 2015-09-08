package com.interview.synchronize;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

public class ScheduleExecutorServiceUsage {

    private static ScheduledExecutorService scheduledExecutorService = null;

    /**
     * �Լ�����
     */
    public static void createScheduledExecutorService(String threadPoolName){
        CustomizableThreadFactory threadFactory = new CustomizableThreadFactory(threadPoolName);
        scheduledExecutorService = new ScheduledThreadPoolExecutor(5, threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
    }
    
    /**
     * �̳߳ط���
     */
    public static void createScheduledExecutorService(){
        scheduledExecutorService = Executors.newScheduledThreadPool(5);
    }
    
    /**
     * Schedule �÷�
     */
    public static void scheduleUsage(){
        System.out.println("currentTime: "+new Date());
        for(int i =0; i<2;i++){
            ScheduleRunable scheduleRunable =  new ScheduleRunable("zhou"+i);
            scheduledExecutorService.schedule(scheduleRunable, 10, TimeUnit.SECONDS);
        }
        scheduledExecutorService.shutdown();
        System.out.println(scheduledExecutorService.isShutdown());
        System.out.println(scheduledExecutorService.isTerminated());
        while(!scheduledExecutorService.isTerminated()){
            
        }
        System.out.println("finish all threads");
    }
    
    /**
     * ScheduleAtFixRate h���ܵ�commandִ��ʱ��Ӱ�졣commandִ����ɺ󣬲Ż�������� period�������ִ��
     */
    public static void scheduleAtFixRate(){
        System.out.println("currentTime: "+new Date());
        for(int i =0; i<2;i++){
            ScheduleRunable scheduleRunable =  new ScheduleRunable("zhou"+i);
            scheduledExecutorService.scheduleAtFixedRate(scheduleRunable, 0, 8, TimeUnit.SECONDS);
        }
    }
    
    /**
     * ScheduleWitFixDelay ���չ̶��ļ��ִ��
     */
    public static void scheduleWithFixDelay(){
        System.out.println("currentTime: "+new Date());
        for(int i =0; i<2;i++){
            ScheduleRunable scheduleRunable =  new ScheduleRunable("zhou"+i);
            scheduledExecutorService.scheduleWithFixedDelay(scheduleRunable, 2, 1, TimeUnit.SECONDS);
        }
    }
    
    
    public static void main(String[] args) {
        createScheduledExecutorService();
        scheduleWithFixDelay();
    }
    
}
class ScheduleRunable implements Runnable {
    private String command;
    
    public ScheduleRunable(String s){
        this.command=s;
    }
 
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Time = "+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End. Time = "+new Date());
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
}
