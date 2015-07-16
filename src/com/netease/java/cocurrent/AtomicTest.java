package com.netease.java.cocurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicTest {
	private static AtomicInteger atomicInteger;
	private static AtomicIntegerArray atomicIntegerArray;
	private static AtomicReference<Person> atomicReference;
	private static AtomicReferenceFieldUpdater<Person, String> atomicUpdater;
	private static Person person = new Person("zhoushaojun");

	static {
		atomicInteger = new AtomicInteger(0);
		atomicIntegerArray = new AtomicIntegerArray(new int[] { 1, 2, 3, 4, 5 });
		atomicReference = new AtomicReference<Person>(new Person("zhou"));
		atomicUpdater = AtomicReferenceFieldUpdater.newUpdater(Person.class, String.class, "name");
	}

	public static void execute() {

		ExecutorService executor = new ThreadPoolExecutor(20, 40, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100),
				new ThreadPoolExecutor.CallerRunsPolicy());
		for (int i = 0; i < 2; i++) {
			executor.execute(new AtomicRunable(atomicUpdater, person));
		}

		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}

		System.out.println(atomicUpdater.get(person));
	}

	public static void main(String[] args) {
		execute();
	}
}

class AtomicRunable implements Runnable {
	private AtomicInteger atomic;
	private AtomicIntegerArray atomicArray;
	private AtomicReference<Person> atomicReference;
	private AtomicReferenceFieldUpdater<Person, String> atomicUpdater;
	private Person person;

	public AtomicRunable(AtomicReferenceFieldUpdater<Person, String> updater, Person personOutter) {
		atomicUpdater = updater;
		person = personOutter;
	}

	public AtomicRunable(AtomicReference<Person> refer) {
		this.atomicReference = refer;
	}

	public AtomicRunable(AtomicIntegerArray array) {
		this.atomicArray = array;
	}

	public AtomicRunable(AtomicInteger outter) {
		this.atomic = outter;
	}

	public void run() {
		// AtomicInteger
		// Integer num = atomic.incrementAndGet();

		// AtomicIntegerArray
		// Integer num = atomicArray.incrementAndGet(2);

		// AtomicReference
		// Person person = atomicReference.getAndSet(new
		// Person("leng : "+Thread.currentThread().getName()));

		// AtomicUpdate
		String preString = atomicUpdater.getAndSet(person, "÷‹…‹æ˚" + Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName() + " : " + preString);
	}

}

class Person {

	volatile String name;
	

	public Person(String outter) {
		name = outter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
