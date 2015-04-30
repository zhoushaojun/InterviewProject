package DesignModule;

public class ChainHandlerDept extends ChainHandler{
	
	public String handleRequest(String user, Integer fee) {
		System.out.println("����  : "+this.getClass().getName());
		System.out.println("user : "+user+" fee : "+fee);
		if(fee <= 1000){
			return "���ž���ͨ�����"+String.valueOf(fee);
		}else {
			return getSuccessor().handleRequest(user, fee);
		}
	}

}
