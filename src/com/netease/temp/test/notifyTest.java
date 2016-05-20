package com.netease.temp.test;

public class notifyTest {

    public String string = "str";

    public void printf(int i) {
        System.out.println(Thread.currentThread().getName());
        if (i == 0) {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
            }
System.out.println("notify");
           synchronized (string) {
            string.notifyAll();
        }
        }
    }

    public void thread(int i) throws Exception {
        if (i != 0) {
            System.out.println(Thread.currentThread().getName()+"wait");
            synchronized (string) {
                string.wait();
            }
            
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws Exception {
        final notifyTest dd = new notifyTest();
        new Thread(new Runnable() {

            @Override
            public void run() {
                dd.printf(0);
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    dd.thread(1);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    dd.thread(2);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();


        Thread.sleep(30000);
    }
}
