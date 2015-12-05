package com.netease.java.cocurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {
    private static Map<String, Object> cacheData = new HashMap<String, Object>();// ���컺�����
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();// �����д��

    public static void main(String[] args) {
        CacheDemo demo = new CacheDemo();
        demo.getData("zhou");
        
   
    }


    public Object getData(String key) {
        Object value = null;
        try {
            rwl.readLock().lock();// ���߳̿�ʼ��ʱ�����ȿ�ʼ���϶���
            value = cacheData.get(key);// ��ȡֵ
            if (value == null) {// �ж��Ƿ����ֵ
                try {
                    rwl.readLock().unlock();// �ڿ�ʼд֮ǰ������Ҫ�ͷ�д��������д���޷��õ�
                    rwl.writeLock().lock();// ��ȡд����ʼд����
                    /*
                     * �ٴ��жϸ�ֵ�Ƿ�Ϊ�գ���Ϊ�������д�߳�����������������һ���߳� �����Ѻ�value��ֵ��Ϊnull��������һ���߳�Ҳ������������жϾͻ�ִ������д
                     */
                    if (value == null) {
                        value = "queryDB";
                        cacheData.put(key, value);
                    }
                    rwl.readLock().lock();// ����֮�����뽵��Ϊ����
                } finally {
                    rwl.writeLock().unlock();// ����ͷ�д��
                }
            }
        } finally {
            rwl.readLock().unlock();// �ͷŶ���
        }
        
        return value;
    }
}
