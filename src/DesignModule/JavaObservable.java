package DesignModule;

import java.util.Observable;

public class JavaObservable extends Observable{

	private String date;
	
	public void changePull(String outter){
		if(null != outter && !"".equalsIgnoreCase(date)){
			if(!outter.equalsIgnoreCase(date)){
				this.date = outter;
				System.out.println("被观察者 : "+this.getClass().getName() +" 更改状态为: "+date);
				setChanged();
				notifyObservers();
				
			}
		}
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
