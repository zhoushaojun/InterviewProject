package DesignModule;

public class ChainHandlerGeneral extends ChainHandler{
	
	public String handleRequest(String user, Integer fee) {
		System.out.println("����  : "+this.getClass().getName());
		System.out.println("user : "+user+" fee : "+fee);
		if(fee <= 2000){
			return "�ܾ�����ͨ�����"+String.valueOf(fee);
		}else {
			return getSuccessor().handleRequest(user, fee);
		}
	}

}
