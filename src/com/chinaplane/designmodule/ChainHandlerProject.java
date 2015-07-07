package com.chinaplane.designmodule;

public class ChainHandlerProject extends ChainHandler{
	
	public String handleRequest(String user, Integer fee) {
		System.out.println("����  : "+this.getClass().getName());
		System.out.println("user : "+user+" fee : "+fee);
		if(fee <= 500){
			return "��Ŀ����ͨ�����"+String.valueOf(fee);
		}else {
			return getSuccessor().handleRequest(user, fee);
		}
	}

}
