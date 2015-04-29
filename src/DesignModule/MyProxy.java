package DesignModule;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler {
	
	private Object object;

	public MyProxy(Object outer) {
		this.object = outer;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before");
		Object obj = method.invoke(object, args);
		System.out.println("End");
		return obj;
	}
	 public static void main(String[] args) {
		 EntityInterfaceImpl entity = new EntityInterfaceImpl();
		 EntityInterface entityInterface = (EntityInterface)Proxy.newProxyInstance(entity.getClass().getClassLoader(), entity.getClass().getInterfaces(), new MyProxy(entity));
		 System.out.println(entityInterface.getInteger());
	}

}
