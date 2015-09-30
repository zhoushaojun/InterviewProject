package com.netease.java.cocurrent;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportUsage {

    private static LockSupportUsage lockSupport = new LockSupportUsage();

    public static void testLockSupport() throws NoSuchFieldException, SecurityException, InterruptedException, IllegalArgumentException,
            IllegalAccessException {
        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("blocker");
                LockSupport.park(lockSupport);
                System.out.println("wakeup now!");
            }
        });

        t.start(); // 启动读取线程
        Thread.sleep(150);
        synchronized (lockSupport) {
            Field field = Thread.class.getDeclaredField("parkBlocker");
            field.setAccessible(true);
            Object fBlocker = field.get(t);
            System.out.println(lockSupport == fBlocker);
            Thread.sleep(100);
            System.out.println("notifyAll");
            lockSupport.notifyAll();
            LockSupport.unpark(t);
        }
    }

    public static void testLockSupportInteruptpark() throws NoSuchFieldException, SecurityException, InterruptedException, IllegalArgumentException,
            IllegalAccessException {
        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("blocker");
                LockSupport.parkNanos(lockSupport, TimeUnit.SECONDS.toNanos(5));
                System.out.println("wakeup now!");
            }
        });

        t.start(); // 启动读取线程
        Thread.sleep(2000);
        t.interrupt();
    }

    public static void testLockSupportInteruptUnpark() throws NoSuchFieldException, SecurityException, InterruptedException, IllegalArgumentException,
            IllegalAccessException {
        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("blocker");
                LockSupport.park(lockSupport);
                System.out.println("wakeup now!");
            }
        });

        t.start(); // 启动读取线程
        Thread.sleep(2000);
        LockSupport.unpark(t);
        //t.interrupt();
    }

    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
            InterruptedException {
        // testLockSupport();
        //testLockSupportInterupt();
        testLockSupportInteruptUnpark();
    }
}
