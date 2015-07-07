package com.chinaplane.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {
	
	protected HelloImpl() throws RemoteException {
		super();
	}

	public String hello() throws RemoteException {
		return "I am saying hello & leng!";
	}

}
