package com.chinaplane.designmodule;

public class ObserverImpl implements Observer{
	
	private String state;
	
	public ObserverImpl(ObServedConcrete observer) {
		observer.addObserve(this);
	}
	
	public void updatePush(String updateStr) {
		state = updateStr;
		System.out.println("������ ���ͣ�"+this.getClass().getName()+" ״̬����Ϊ ��"+state);
	}

	public void updatePull(ObservedAbstract concrete) {
		ObServedConcrete observe = (ObServedConcrete)concrete;
		state = observe.getCurState();
		System.out.println("������ ��ȡ��"+this.getClass().getName()+" ״̬����Ϊ ��"+state);
	}
}
