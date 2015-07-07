package com.chinaplane.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote{
	
	public abstract String hello() throws RemoteException;
}
