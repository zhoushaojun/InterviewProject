package com.chinaplane.designmodule;

public class ObserverImpl implements Observer{
	
	private String state;
	
	public ObserverImpl(ObServedConcrete observer) {
		observer.addObserve(this);
	}
	
	public void updatePush(String updateStr) {
		state = updateStr;
		System.out.println("监听者 推送："+this.getClass().getName()+" 状态更改为 ："+state);
	}

	public void updatePull(ObservedAbstract concrete) {
		ObServedConcrete observe = (ObServedConcrete)concrete;
		state = observe.getCurState();
		System.out.println("监听者 拉取："+this.getClass().getName()+" 状态更改为 ："+state);
	}
}
