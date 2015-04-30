package DesignModule;

public class ChainHandlerGeneral extends ChainHandler{
	
	public String handleRequest(String user, Integer fee) {
		System.out.println("我是  : "+this.getClass().getName());
		System.out.println("user : "+user+" fee : "+fee);
		if(fee <= 2000){
			return "总经理经理通过审核"+String.valueOf(fee);
		}else {
			return getSuccessor().handleRequest(user, fee);
		}
	}

}
