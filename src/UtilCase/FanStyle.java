package UtilCase;

import java.util.ArrayList;
import java.util.Arrays;

public class FanStyle<E> {

	private transient Object[] element;
	private int current = 0;
	public FanStyle(int size) {
		element = new Object[size];
	}
	public FanStyle() {
		this(10);
	}
	
	public E getElement(int index){
		return (E)this.element[index];
	}
	public void addElement(E e){
		this.element[this.current++] = e;
	}
	public String toString(){
		return Arrays.toString(element);
	}
	public <T> T[] toArray(T[] arrayT){
		//return (T[])Arrays.copyOf(element, this.element.length,arrayT.getClass());
		System.arraycopy(element, 0,arrayT, 0, element.length);
		return arrayT;
	}
	
	public static void main(String[] args) {
		FanStyle<String> fan = new FanStyle<String>();
		fan.addElement("1");
		fan.addElement("2");
		fan.addElement("3");
		String[] wangStrings  = new String[9];
		System.out.println(fan.toArray(wangStrings)[2]);
		System.out.println(fan.toString());
	}
}

class Pair<T, U> {
	private T t;
	private U u;
	
	public Pair(T tt,U uu) {
		this.t = tt;
		this.u = uu;
	}

	public  T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public U getU() {
		return u;
	}

	public void setU(U u) {
		this.u = u;
	}
}
