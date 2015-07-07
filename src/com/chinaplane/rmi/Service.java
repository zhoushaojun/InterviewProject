package com.chinaplane.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Service {

	public static void main(String[] args) {
		try {
			Hello hello = new HelloImpl();
			LocateRegistry.createRegistry(12312);
			Naming.bind("rmi://localhost:12312/hello", hello);
			System.out.println("RMI service started");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
