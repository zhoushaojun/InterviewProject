package com.netease.module.programma;
/**
 * "��"������ ����ģʽ
 * ʹ��ģ��T����ͬ�������ܲ�ͬ�Ĳ������й���
 * ���˹��� ���ܲ���Long��Ů�˹������ܲ���String �ֱ���й���
 * ������Person�ӿڽ��з���
 * 
 * ManBuildFactory WomenBuildFactory
 * 
 * @author zhoushaojun
 *
 * @param <T>
 */
public interface PersonBuildFactory<T> {
	
	public Person build(T t);

}
