package Ticket_System;

public class Carculate_Charge {
	int[] m_money_data = { 3, 2, 2, 10, 3, 1 };// 관리자 소지금
	int[] u_money_data = { 0, 0, 0, 0, 0, 0 };// 사용자 소지금
	int[] charge_data = { 0, 0, 0, 0, 0, 0 };
	int mealTicket = 0;// 구입할 식권 수
	int m_mealTicket = 5;// 관리자 소지한 식권 수
	static int money_arr[] = { 50000, 10000, 5000, 1000, 500, 100 };// 돈 단위 배열
	String result;// 결과 출력

	void purchaseItems() {
		if(mealTicket==0) {result="식권의 개수를 선택해주세요 ";return;}
		if (m_mealTicket < mealTicket) {
			result = "식권이 부족합니다.";
			return;
		}
		// 소지 금액 부족
		int totalPrice = mealTicket * 3200;
		int totalMoney = 0;
		for (int i = 0; i < 6; i++) {
			totalMoney += (u_money_data[i] * money_arr[i]);
		}
		System.out.println("totalPrice"+totalPrice);
		System.out.println("totalMoney"+totalMoney);

		if (totalPrice > totalMoney) {
			result = "금액이 부족합니다.";
			return;
		}

		// 정상 흐름
		// 기계에 돈 넣기

		for (int i = 0; i < 6; i++) {
			m_money_data[i] += u_money_data[i];
			u_money_data[i] = 0;
		}

		int chargeMoney = totalMoney - totalPrice;
		System.out.println(chargeMoney);
		// 거스름돈 지불
		for (int i = 0; i < 6; i++) {
			int mok = chargeMoney / money_arr[i];

			if (mok > 0) {
				if (m_money_data[i] > 0) {
					if (mok > m_money_data[i]) {
						chargeMoney -= m_money_data[i] * money_arr[i];
						charge_data[i] = m_money_data[i];
					} else {
						chargeMoney -= mok * money_arr[i];
						charge_data[i] = mok;
					}
				}
			}
		}
		if (chargeMoney > 0) {
			result = "거스름돈이 부족합니다.";
			return;
		}

		result = "<html> [거스름돈] : <br>";
		for (int i = 0; i < 6; i++) {
			m_money_data[i] -= charge_data[i];
			if(charge_data[i]==0)continue;
			if(i==5) {result += +money_arr[i] + "원 : " + charge_data[i] + "개 ";}
			else {
			result += +money_arr[i] + "원 : " + charge_data[i] + "개 ,  ";
			}
		}
		result+="<br>식권 "+mealTicket+"장을 구매했습니다.</html>";
		m_mealTicket-=mealTicket;
		mealTicket=0;
	}
}
