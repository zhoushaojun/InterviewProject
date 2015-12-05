package com.netease.java.cocurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {
    private static Map<String, Object> cacheData = new HashMap<String, Object>();// 构造缓存对象
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();// 构造读写锁

    public static void main(String[] args) {
        CacheDemo demo = new CacheDemo();
        demo.getData("zhou");
        
   
    }


    public Object getData(String key) {
        Object value = null;
        try {
            rwl.readLock().lock();// 当线程开始读时，首先开始加上读锁
            value = cacheData.get(key);// 获取值
            if (value == null) {// 判断是否存在值
                try {
                    rwl.readLock().unlock();// 在开始写之前，首先要释放写锁，否则写锁无法拿到
                    rwl.writeLock().lock();// 获取写锁开始写数据
                    /*
                     * 再次判断该值是否为空，因为如果两个写线程如果都阻塞在这里，当一个线程 被唤醒后value的值不为null，当另外一个线程也被唤醒如果不判断就会执行两次写
                     */
                    if (value == null) {
                        value = "queryDB";
                        cacheData.put(key, value);
                    }
                    rwl.readLock().lock();// 读完之后重入降级为读锁
                } finally {
                    rwl.writeLock().unlock();// 最后释放写锁
                }
            }
        } finally {
            rwl.readLock().unlock();// 释放读锁
        }
        
        return value;
    }
}
