package com.chinaplane.designmodule;

public class ObServedConcrete extends ObservedAbstract{

	private String curState;
	
	public void changePush(String state){
		curState = state;
		System.out.println("���۲��� ��"+this.getClass().getName()+" ״̬����Ϊ : "+curState);
		notifyObserverPush(state);
	}
	
	public void changePull(String state){
		curState = state;
		System.out.println("���۲��� ��"+this.getClass().getName()+" ״̬����Ϊ : "+curState);
		notifyObserverPull();
	}
	
	public static void main(String[] args) {
		ObServedConcrete observe = new ObServedConcrete();
		ObserverImpl observerImpl = new ObserverImpl(observe);
		ObserverImpl observerImplA = new ObserverImpl(observe);
		
		observe.changePush("zhoushaojun");
	}

	public String getCurState() {
		return curState;
	}

	public void setCurState(String curState) {
		this.curState = curState;
	}
}
