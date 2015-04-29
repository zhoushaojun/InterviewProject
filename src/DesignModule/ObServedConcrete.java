package DesignModule;

public class ObServedConcrete extends ObservedAbstract{

	private String curState;
	
	public void changePush(String state){
		curState = state;
		System.out.println("被观察者 ："+this.getClass().getName()+" 状态更改为 : "+curState);
		notifyObserverPush(state);
	}
	
	public void changePull(String state){
		curState = state;
		System.out.println("被观察者 ："+this.getClass().getName()+" 状态更改为 : "+curState);
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
