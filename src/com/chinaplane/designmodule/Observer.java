package com.chinaplane.designmodule;

public interface Observer {
	/**
	 * 推送形式，推送给用户一些 吸引信息
	 * @param change
	 */
	public void updatePush(String updateStr);
	
	/**
	 * 拉取模式，用户拉取更新的全部信息
	 * @param concrete
	 */
	public void updatePull(ObservedAbstract concrete);
}
