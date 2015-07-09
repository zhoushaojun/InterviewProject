package com.netease.cocurrent.collection;

import java.util.concurrent.locks.ReentrantLock;

public class AlternateLock {

	private static Node head;
	static{
		init();
	}
	public AlternateLock() {
	}

	public static void coreLogic(int value){
		Node current = head;
		Node next = head.getNext();
		current.getLock().lock();
		
		try {
			while(true){
				
				next.getLock().lock();
				try {
					if(null != next && value >= next.getValue()){
						Node node = new Node("insert", value);
						current.setNext(node);
						node.setNext(next);
						System.out.println("return");
						return;
					}
				} finally{
					System.out.println(" Õ∑≈current Lock");
					current.getLock().unlock();
				}
				current = next;
				next = next.getNext();
			}
			
		} finally{
			System.out.println(" Õ∑≈next Lock");
			next.getLock().unlock();
		} 
		
	}
	
	public static void print(){
		Node read = head;
		while(read != null){
			System.out.println(read.getName()+":"+read.getValue());
			read = read.getNext();
		}
	}
	
	public static void main(String[] args) {
		coreLogic(2);
		print();
		
	}
	private static void init(){
		head = new Node("Head", 10);
		Node first = new Node("Head", 7);
		Node second = new Node("Head", 5);
		Node three = new Node("Head",4);
		Node four = new Node("Head", 3);
		Node five = new Node("Head", 1);
		
		head.setNext(first);
		first.setNext(second);
		second.setNext(three);
		three.setNext(four);
		four.setNext(five);
		
	}
	
}
class Node {
	
	private String name;
	private int value;
	private Node next;
	
	private ReentrantLock lock = new ReentrantLock();
	
	public Node(String nameOutter, int valueOutter) {
		name  = nameOutter;
		value = valueOutter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ReentrantLock getLock() {
		return lock;
	}

	public void setLock(ReentrantLock lock) {
		this.lock = lock;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}