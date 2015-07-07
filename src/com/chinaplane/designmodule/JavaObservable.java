package com.chinaplane.designmodule;

import java.util.Observable;

public class JavaObservable extends Observable{

	private String date;
	
	public void changePull(String outter){
		if(null != outter && !"".equalsIgnoreCase(date)){
			if(!outter.equalsIgnoreCase(date)){
				this.date = outter;
				System.out.println("���۲��� : "+this.getClass().getName() +" ����״̬Ϊ: "+date);
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
