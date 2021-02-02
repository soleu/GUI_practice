package GUI;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

class Omok_Panel extends JPanel implements ActionListener {
	JButton map_arr[][];// 오목판
	JButton reset;// 리셋버튼
	boolean turn;// 턴

	Omok_Panel() {
		this.setLayout(null);
		init();// 시작 설정
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// reset button
		if (e.getSource() == reset) {
			Reset();
		}

		// omok_map
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (e.getSource() == map_arr[i][j]) {
					if (turn) {
						map_arr[i][j].setBackground(Color.pink);
						turn = !turn;
					} else {
						map_arr[i][j].setBackground(Color.blue);
						turn = !turn;
					}
				}
			}
		}

		// check
		check();
	}

	public void check() {
		// garo
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 5; j++) {
				int countp1 = 0;
				int countp2 = 0;
				for (int k = 0; k < 5; k++) {
					Color temp = map_arr[i][j + k].getBackground();// color 속성도 빼올 수 있음.
					if (temp == Color.pink) {
						countp1++;
					} else {
						countp1 = 0;
					}

					if (temp == Color.blue) {
						countp2++;
					} else {
						countp2 = 0;
					}
				}
				if (countp1 == 5) {
					System.out.println("p1 승리!");
					break;
				}
				if (countp2 == 5) {
					System.out.println("p2 승리!");
					break;
				}

			}
		}
		// sero
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				int countp1 = 0;
				int countp2 = 0;
				for (int k = 0; k < 5; k++) {
					Color temp = map_arr[i + k][j].getBackground();// color 속성도 빼올 수 있음.
					if (temp == Color.pink) {
						countp1++;
					} else {
						countp1 = 0;
					}

					if (temp == Color.blue) {
						countp2++;
					} else {
						countp2 = 0;
					}
				}
				if (countp1 == 5) {
					System.out.println("p1 승리!");
					break;
				}
				if (countp2 == 5) {
					System.out.println("p2 승리!");
					break;
				}

			}
		}

	}

	private void Reset() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				map_arr[i][j].setBackground(Color.white);
			}
		}
	}

	public void init() {
		map_arr = new JButton[9][9];
		reset = new JButton();
		// 배열 값 초기화
		turn = true;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				map_arr[i][j] = new JButton();
				map_arr[i][j].setLocation(50 * i, 50 * j);
				map_arr[i][j].setSize(50, 50);
				map_arr[i][j].setBackground(Color.white);
				map_arr[i][j].addActionListener(this);
				add(map_arr[i][j]);
			}
		}

		reset.setText("reset");
		reset.setLocation(500, 200);
		reset.setSize(200, 150);
		reset.addActionListener(this);
		add(reset);

	}
}

public class Omok_Game {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("1TO50");
		frame.setSize(1000, 800);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Omok_Panel op = new Omok_Panel();
		frame.setContentPane(op);
		frame.revalidate();
	}

}
