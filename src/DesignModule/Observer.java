package DesignModule;

public interface Observer {
	/**
	 * ������ʽ�����͸��û�һЩ ������Ϣ
	 * @param change
	 */
	public void updatePush(String updateStr);
	
	/**
	 * ��ȡģʽ���û���ȡ���µ�ȫ����Ϣ
	 * @param concrete
	 */
	public void updatePull(ObservedAbstract concrete);
}
