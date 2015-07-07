package com.chinaplane.designmodule;

public abstract class ChainHandler {
	private ChainHandler successor;

	public abstract String handleRequest(String user, Integer fee);

	public ChainHandler getSuccessor() {
		return successor;
	}

	public void setSuccessor(ChainHandler successor) {
		this.successor = successor;
	}
	public static void main(String[] args) {
		ChainHandler project = new ChainHandlerProject();
		ChainHandler dept = new ChainHandlerDept();
		ChainHandler general = new ChainHandlerGeneral();
		
		project.setSuccessor(dept);
		dept.setSuccessor(general);
		
		String result = project.handleRequest("÷‹…‹æ˚", 100);
		System.out.println(result);
	}
}
