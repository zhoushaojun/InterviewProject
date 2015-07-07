package com.chinaplane.designmodule;

public class ChainHandlerProject extends ChainHandler{
	
	public String handleRequest(String user, Integer fee) {
		System.out.println("我是  : "+this.getClass().getName());
		System.out.println("user : "+user+" fee : "+fee);
		if(fee <= 500){
			return "项目经理通过审核"+String.valueOf(fee);
		}else {
			return getSuccessor().handleRequest(user, fee);
		}
	}

}
