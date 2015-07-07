package com.chinaplane.designmodule;

import java.util.Observable;
import java.util.Observer;

public class JavaObserver implements Observer{

	public JavaObserver(Observable observable) {
		observable.addObserver(this);
	}
	public void update(Observable o, Object arg) {
		JavaObservable observable = (JavaObservable)o;
		System.out.println("观察者 拉取数据  : "+observable.getDate());
	}
	public static void main(String[] args) {
		JavaObservable observable = new JavaObservable();
		Observer observer = new JavaObserver(observable);
		observable.changePull("Lengjing");
	}

}
