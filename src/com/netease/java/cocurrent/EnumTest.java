package com.netease.java.cocurrent;

public class EnumTest {
	public enum ExchangeState {

		   EXCHANGE_NOT_BEGIN(50),               // 兑换未开始-无法兑换
		   EXCHANGE_WORKING(10);                 // 兑换进行中-可以兑换
		   
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
