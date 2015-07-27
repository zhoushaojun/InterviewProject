package com.netease.java.cocurrent;

public class EnumTest {
	enum ExchangeState {

		   EXCHANGE_NOT_BEGIN,               // 兑换未开始-无法兑换
		   EXCHANGE_WORKING,                 // 兑换进行中-可以兑换
		   EXCHANGE_OVER,                    // 兑换已结束-无法兑换
		   VISITOR_NOT_ENOUGH_COIN,          // 用户金币不足-无法兑换
		   VISITOR_REACH_LIMIT,              // 用户已经兑换-无法兑换
		   PRIZE_OVER,                       // 奖品已兑换完
		   PRIZE_DAILY_OVER,                 // 奖品今日已兑换完
		   PRIZE_IN_EXPRESS,                 // 奖品在“筹备发货”阶段
		   PRIZE_IN_RECEIVER,                // 奖品在“预计领取”阶段
		   PRIZE_RECEIVER_OVER,              // 奖品出于“领取结束”阶段
		   VISITOR_CAN_EXCHANGE,             // 用户可兑换
		   VISITOR_CAN_NOT_EXCHANGE,         // 用户不可兑换
		   VISITOR_OVER_EXPERIENCE,          // 用户经验值超过限制
		   VISITOR_NOT_REACH_EXPERIENCE,     // 用户未达到经验值限制
		   REQUEST_EXPIRED,                  // 请求已过期
		   FLOW_GIFT_NOT_IN_RANGE,           // 流量请求不在相应范围内
		   CAPTCHA_VALIDATE_ERROR,           // 验证码验证失败
		   VISITOR_NOT_VIP,                  // 用户不是VIP
		   VISITOR_NOT_FORMAL_VIP,           // 用户不是正式VIP
		   EXCHANGE_NOT_TURN                 // 顺序奖品中没有轮到的
		   
		}

	public static void main(String[] args) {
		System.out.println(ExchangeState.EXCHANGE_NOT_BEGIN);
		System.out.println(ExchangeState.EXCHANGE_NOT_BEGIN.ordinal());
	}
}
