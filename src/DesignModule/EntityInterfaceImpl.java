package DesignModule;

public class EntityInterfaceImpl implements EntityInterface {

	public String getStr() {
		return "I am Entity Proxy";
	}

	public Integer getInteger() {
		System.out.println("entry integer function");
		return 10;
	}

}
