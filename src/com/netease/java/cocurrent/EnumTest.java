package com.netease.java.cocurrent;

public class EnumTest {
	public enum ExchangeState {

		   EXCHANGE_NOT_BEGIN(50),               // �һ�δ��ʼ-�޷��һ�
		   EXCHANGE_WORKING(10);                 // �һ�������-���Զһ�
		   
		   int value;
		   private ExchangeState(int value){
		       this.value = value;
		   }
		   
		   public int getValue(){
		       return value;
		   }
		   
		}

	public static void main(String[] args) {
		System.out.println(ExchangeState.EXCHANGE_NOT_BEGIN);
		System.out.println(ExchangeState.EXCHANGE_NOT_BEGIN.name());
		System.out.println(ExchangeState.EXCHANGE_NOT_BEGIN.ordinal());
		System.out.println(ExchangeState.EXCHANGE_NOT_BEGIN.toString());
		System.out.println(ExchangeState.EXCHANGE_NOT_BEGIN.getValue());
	}
}
