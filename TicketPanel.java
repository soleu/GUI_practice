package Ticket_System;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.color.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;

public class TicketPanel extends JPanel implements ActionListener {
	Carculate_Charge charge = new Carculate_Charge();
	JLabel manager;// 관리자 라벨
	JLabel user;// 사용자 라벨
	JLabel m_money[];// 관리자 금액 배열
	JLabel u_money[];// 사용자 금액 배열
	JButton purchase;// 구입하기 버튼
	JButton m_button[][];// 관리자 버튼
	JButton u_button[][];// 사용자 버튼
	JLabel mealTicketPrice;// 식권 가격 라벨
	JLabel mealTicketBuy;// 살 식권 개수
	JLabel money_arr_label[][];// 돈 단위 라벨
	JLabel result;//결과  출력 라벨

	public TicketPanel() {
		Font font1 = new Font("SanSerif", Font.BOLD, 23);
		Font font2 = new Font("SanSerif", Font.BOLD, 18);
		Font font3 = new Font("SanSerif", Font.BOLD, 16);
		Color color1 = new Color(205, 74, 119);
		Color color2 = new Color(19, 19, 19);
		revalidate();
		repaint();
		setLayout(null);
		setBackground(Color.white);
		// 관리자 라벨
		manager = new JLabel();
		manager.setFont(font1);
		manager.setForeground(color1);
		manager.setBounds(180, 30, 150, 100);
		manager.setOpaque(true);// 뒤에 칸이 생김
		manager.setHorizontalAlignment(JLabel.CENTER);// 문자열 가운데 정렬
		manager.setText("Manager");
		add(manager);
		// 사용자 라벨
		user = new JLabel();
		user.setFont(font1);
		user.setForeground(color1);
		user.setBounds(650, 30, 150, 100);
		user.setOpaque(true);// 뒤에 칸이 생김
		user.setHorizontalAlignment(JLabel.CENTER);// 문자열 가운데 정렬
		user.setText("User");
		add(user);
		// 관리자 버튼
		m_button = new JButton[7][2];
		for (int i = 0; i < 7; i++) {
			m_button[i][0] = new JButton();
			m_button[i][1] = new JButton();
			m_button[i][0].setText("+");
			m_button[i][1].setText("-");
			m_button[i][0].setBackground(Color.white);
			m_button[i][1].setBackground(Color.white);
			m_button[i][0].setBounds(280, 153 + i * 80, 45, 45);
			m_button[i][1].setBounds(325, 153 + i * 80, 45, 45);
//			u_money[i].setHorizontalAlignment(JLabel.CENTER);// 문자열 가운데 정렬
			m_button[i][0].addActionListener(this);
			m_button[i][1].addActionListener(this);
			add(m_button[i][0]);
			add(m_button[i][1]);
		}
		// 사용자 버튼
		u_button = new JButton[7][2];
		for (int i = 0; i < 7; i++) {
			u_button[i][0] = new JButton();
			u_button[i][1] = new JButton();
			u_button[i][0].setText("+");
			u_button[i][1].setText("-");
			u_button[i][0].setBackground(Color.white);
			u_button[i][1].setBackground(Color.white);
			u_button[i][0].setBounds(700, 153 + i * 80, 45, 45);
			u_button[i][1].setBounds(745, 153 + i * 80, 45, 45);
			u_button[i][0].addActionListener(this);
			u_button[i][1].addActionListener(this);
			add(u_button[i][0]);
			add(u_button[i][1]);
		}
		// 관리자 금액 라벨
		m_money = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			m_money[i] = new JLabel();
			m_money[i].setFont(font2);
			m_money[i].setBackground(Color.lightGray);
			m_money[i].setForeground(color2);
			m_money[i].setBounds(420, 150 + i * 80, 400, 50);
			m_money[i].setHorizontalAlignment(JLabel.LEFT);// 문자열 가운데 정렬
			m_money[i].setText(charge.m_money_data[i] + "개");
			add(m_money[i]);
		}
		// 사용자 금액 라벨
		u_money = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			u_money[i] = new JLabel();
			u_money[i].setFont(font2);
			u_money[i].setBackground(Color.lightGray);
			u_money[i].setForeground(color2);
			u_money[i].setBounds(650, 150 + i * 80, 400, 50);
			u_money[i].setHorizontalAlignment(JLabel.CENTER);// 문자열 가운데 정렬
			u_money[i].setText(charge.u_money_data[i] + "개");
			add(u_money[i]);
		}
		// 관리자, 사용자 돈 단위 라벨
		money_arr_label = new JLabel[6][2];
		for (int i = 0; i < 6; i++) {
			money_arr_label[i][0] = new JLabel();
			money_arr_label[i][1] = new JLabel();
			money_arr_label[i][0].setFont(font2);
			money_arr_label[i][1].setFont(font2);
			money_arr_label[i][0].setBackground(Color.lightGray);
			money_arr_label[i][1].setBackground(Color.lightGray);
			money_arr_label[i][0].setForeground(color2);
			money_arr_label[i][1].setForeground(color2);
			money_arr_label[i][0].setBounds(80, 150 + i * 80, 400, 50);
			money_arr_label[i][1].setBounds(500, 150 + i * 80, 400, 50);
			money_arr_label[i][0].setOpaque(true);// 뒤에 칸이 생김
			money_arr_label[i][1].setOpaque(true);// 뒤에 칸이 생김
			money_arr_label[i][0].setHorizontalAlignment(JLabel.LEFT);// 문자열 가운데 정렬
			money_arr_label[i][1].setHorizontalAlignment(JLabel.LEFT);// 문자열 가운데 정렬
			money_arr_label[i][0].setText("   " + charge.money_arr[i] + "원");
			money_arr_label[i][1].setText("   " + charge.money_arr[i] + "원");
			add(money_arr_label[i][0]);
			add(money_arr_label[i][1]);
		}
		// 관리자 식권 라벨
		mealTicketPrice = new JLabel();// 식권 가격 라벨
		mealTicketPrice.setFont(font2);
		mealTicketPrice.setForeground(color2);
		mealTicketPrice.setBounds(80, 150 + 80 * 6, 400, 50);
		mealTicketPrice.setBackground(Color.pink);
		mealTicketPrice.setOpaque(true);
		mealTicketPrice.revalidate();
		mealTicketPrice.setText("식권 가격 : 3200원                                     " + charge.m_mealTicket + "개");
		add(mealTicketPrice);
		// 사용자 살 식권 개수 라벨
		mealTicketBuy = new JLabel();// 살 식권 개수
		mealTicketBuy = new JLabel();// 식권 가격 라벨
		mealTicketBuy.setFont(font2);
		mealTicketBuy.setForeground(color2);
		mealTicketBuy.setBackground(Color.pink);
		mealTicketBuy.setOpaque(true);
		mealTicketBuy.setBounds(500, 150 + 80 * 6, 400, 50);
		mealTicketBuy.setHorizontalAlignment(JLabel.LEFT);// 문자열 가운데 정렬
		mealTicketBuy.setText("구입할 식권 수                                            " + charge.mealTicket + "개");
		add(mealTicketBuy);
		// 구입하기 버튼
		purchase = new JButton();
		purchase.setFont(font1);
		purchase.setBounds(545, 700, 300, 100);
		purchase.setForeground(color2);
		purchase.setBackground(new Color(135, 206, 235));
		purchase.setText("Purchase");
		purchase.addActionListener(this);
		add(purchase);
		
		//결과 출력 라벨
		result=new JLabel();
		result.setFont(font3);
		result.setBounds(50,700,450,100);
		result.setHorizontalAlignment(JLabel.CENTER);
		result.setForeground(color1);
		result.setBackground(color1);
		result.setVisible(false);
		add(result);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 관리자 버튼 눌렀을떄
		for (int i = 0; i < 6; i++) {
			// +버튼
			if (e.getSource() == m_button[i][0]) {
				charge.m_money_data[i]++;
			}
			// -버튼
			else if (e.getSource() == m_button[i][1]) {
				if (charge.m_money_data[i] > 0) {
					charge.m_money_data[i]--;
				}
			}
			m_money[i].setText(charge.m_money_data[i] + "개");
		}
		// 사용자 버튼 눌렀을때
		for (int i = 0; i < 6; i++) {
			if (e.getSource() == u_button[i][0]) {
				charge.u_money_data[i]++;
			} else if (e.getSource() == u_button[i][1]) {
				if (charge.u_money_data[i] > 0) {
					charge.u_money_data[i]--;
				}
			}
			u_money[i].setText(charge.u_money_data[i] + "개");
		}
		// 관리자 식권 관리 버튼 눌렀을떄
		if (e.getSource() == m_button[6][0]) {
			charge.m_mealTicket++;
			System.out.println(charge.m_mealTicket);
		} else if (e.getSource() == m_button[6][1]) {
			if (charge.m_mealTicket > 0) {
				charge.m_mealTicket--;
				System.out.println(charge.m_mealTicket);
			}
		}
		mealTicketPrice.setText("식권 가격 : 3200원                                     " + charge.m_mealTicket + "개");
		// 사용자 구입 식권 버튼
		if (e.getSource() == u_button[6][0]) {
			charge.mealTicket++;
		} else if (e.getSource() == u_button[6][1]) {
			if (charge.mealTicket > 0) {
				charge.mealTicket--;
			}
		}
		mealTicketBuy.setText("구입할 식권 수                                            " + charge.mealTicket + "개");

		// 구입하기 버튼 눌렀을떄
		if (e.getSource() == purchase) {
			charge.purchaseItems();
			//결과 출력
			result.setText(charge.result);
			result.setVisible(true);
			//다른거 갱신
			for(int i=0;i<6;i++) {
				m_money[i].setText(charge.m_money_data[i] + "개");
				u_money[i].setText(charge.u_money_data[i] + "개");
			}
			mealTicketPrice.setText("식권 가격 : 3200원                                     " + charge.m_mealTicket + "개");
			mealTicketBuy.setText("구입할 식권 수                                            " + charge.mealTicket + "개");
		}
	}
}