package DesignModule;

public class ChainHandlerDept extends ChainHandler{
	
	public String handleRequest(String user, Integer fee) {
		System.out.println("我是  : "+this.getClass().getName());
		System.out.println("user : "+user+" fee : "+fee);
		if(fee <= 1000){
			return "部门经理通过审核"+String.valueOf(fee);
		}else {
			return getSuccessor().handleRequest(user, fee);
		}
	}

}
