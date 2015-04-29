package DesignModule;

import java.util.List;
import java.util.Vector;

public abstract class ObservedAbstract {
	private List<Observer> observers = new Vector<Observer>();
	
	public void addObserve(Observer observer){
		this.observers.add(observer);
	}
	
	public void removeObserve(Observer observer){
		this.observers.remove(observer);
	}

	public void notifyObserverPush(String change){
		for (Observer server : observers) {
			server.updatePush(change);
		}
	}
	
	public void notifyObserverPull(){
		for (Observer server : observers) {
			server.updatePull(this);
		}
	} 

}
