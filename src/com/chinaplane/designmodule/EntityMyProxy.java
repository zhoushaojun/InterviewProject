package com.chinaplane.designmodule;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class EntityMyProxy implements InvocationHandler {
	
	private Object object;

	public EntityMyProxy(Object outer) {
		this.object = outer;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before");
		 EntityInterfaceImpl entity = new EntityInterfaceImpl();
		Object obj = method.invoke(entity, args);
		System.out.println("End");
		return obj;
	}
	
	public static EntityInterface getInterface(){
	    EntityInterface entityInterface = (EntityInterface)Proxy.newProxyInstance(EntityMyProxy.class.getClassLoader(), new Class []{EntityInterface.class}, new EntityMyProxy(null));
        return entityInterface;
	}
	private class zhou{
	    private String ss ="";
	}
	 public static void main(String[] args) {
		 System.out.println(getInterface().getInteger());
	}

}
