package Ticket_System;

public class Carculate_Charge {
	int[] m_money_data = { 3, 2, 2, 10, 3, 1 };// ������ ������
	int[] u_money_data = { 0, 0, 0, 0, 0, 0 };// ����� ������
	int[] charge_data = { 0, 0, 0, 0, 0, 0 };
	int mealTicket = 0;// ������ �ı� ��
	int m_mealTicket = 5;// ������ ������ �ı� ��
	static int money_arr[] = { 50000, 10000, 5000, 1000, 500, 100 };// �� ���� �迭
	String result;// ��� ���

	void purchaseItems() {
		if(mealTicket==0) {result="�ı��� ������ �������ּ��� ";return;}
		if (m_mealTicket < mealTicket) {
			result = "�ı��� �����մϴ�.";
			return;
		}
		// ���� �ݾ� ����
		int totalPrice = mealTicket * 3200;
		int totalMoney = 0;
		for (int i = 0; i < 6; i++) {
			totalMoney += (u_money_data[i] * money_arr[i]);
		}
		System.out.println("totalPrice"+totalPrice);
		System.out.println("totalMoney"+totalMoney);

		if (totalPrice > totalMoney) {
			result = "�ݾ��� �����մϴ�.";
			return;
		}

		// ���� �帧
		// ��迡 �� �ֱ�

		for (int i = 0; i < 6; i++) {
			m_money_data[i] += u_money_data[i];
			u_money_data[i] = 0;
		}

		int chargeMoney = totalMoney - totalPrice;
		System.out.println(chargeMoney);
		// �Ž����� ����
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
			result = "�Ž������� �����մϴ�.";
			return;
		}

		result = "<html> [�Ž�����] : <br>";
		for (int i = 0; i < 6; i++) {
			m_money_data[i] -= charge_data[i];
			if(charge_data[i]==0)continue;
			if(i==5) {result += +money_arr[i] + "�� : " + charge_data[i] + "�� ";}
			else {
			result += +money_arr[i] + "�� : " + charge_data[i] + "�� ,  ";
			}
		}
		result+="<br>�ı� "+mealTicket+"���� �����߽��ϴ�.</html>";
		m_mealTicket-=mealTicket;
		mealTicket=0;
	}
}
