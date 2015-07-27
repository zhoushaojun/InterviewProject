package com.netease.java.cocurrent;

public class EnumTest {
	enum ExchangeState {

		   EXCHANGE_NOT_BEGIN,               // �һ�δ��ʼ-�޷��һ�
		   EXCHANGE_WORKING,                 // �һ�������-���Զһ�
		   EXCHANGE_OVER,                    // �һ��ѽ���-�޷��һ�
		   VISITOR_NOT_ENOUGH_COIN,          // �û���Ҳ���-�޷��һ�
		   VISITOR_REACH_LIMIT,              // �û��Ѿ��һ�-�޷��һ�
		   PRIZE_OVER,                       // ��Ʒ�Ѷһ���
		   PRIZE_DAILY_OVER,                 // ��Ʒ�����Ѷһ���
		   PRIZE_IN_EXPRESS,                 // ��Ʒ�ڡ��ﱸ�������׶�
		   PRIZE_IN_RECEIVER,                // ��Ʒ�ڡ�Ԥ����ȡ���׶�
		   PRIZE_RECEIVER_OVER,              // ��Ʒ���ڡ���ȡ�������׶�
		   VISITOR_CAN_EXCHANGE,             // �û��ɶһ�
		   VISITOR_CAN_NOT_EXCHANGE,         // �û����ɶһ�
		   VISITOR_OVER_EXPERIENCE,          // �û�����ֵ��������
		   VISITOR_NOT_REACH_EXPERIENCE,     // �û�δ�ﵽ����ֵ����
		   REQUEST_EXPIRED,                  // �����ѹ���
		   FLOW_GIFT_NOT_IN_RANGE,           // ������������Ӧ��Χ��
		   CAPTCHA_VALIDATE_ERROR,           // ��֤����֤ʧ��
		   VISITOR_NOT_VIP,                  // �û�����VIP
		   VISITOR_NOT_FORMAL_VIP,           // �û�������ʽVIP
		   EXCHANGE_NOT_TURN                 // ˳��Ʒ��û���ֵ���
		   
		}

	public static void main(String[] args) {
		System.out.println(ExchangeState.EXCHANGE_NOT_BEGIN);
		System.out.println(ExchangeState.EXCHANGE_NOT_BEGIN.ordinal());
	}
}
