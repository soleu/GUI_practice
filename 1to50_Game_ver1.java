package Mouse;
import java.awt.color.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
class Rect {
	int x;
	int y;
	Color color;
	int back;// 들어갈 수 뒷면
	int size;
	int num;// 들어갈 수
}
class My_panel extends JPanel implements MouseListener, MouseMotionListener {
	Rect rect[] = new Rect[25];
	int count = 0;
	My_panel() {
		addMouseListener(this);// 마우스와 패널 연결
		addMouseMotionListener(this);// 마우스 모션과 패널 연결
		int i = 0;
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				rect[i] = new Rect();// 각각 배열객체마다 선언
				rect[i].size = 50;
				rect[i].x = 400 + x * rect[i].size;
				rect[i].y = 200 + y * rect[i].size;
				rect[i].num = i;
				rect[i].color = Color.white;
				rect[i].back = i + 25;
				i++;
			}
		}
	}
	protected void paintComponent(Graphics g) {
		// 그리기 함수
		super.paintComponent(g);// 지우기
		try {
			Thread.sleep(10);
			repaint();
		} catch (Exception e) {
			// TODO: handle exception
		}
//		g.drawRoundRect(200, 200, 50, 50, 30, 30);//둥근 사각형 생성 가능
		g.drawString("다음 숫자 : " + count, 100, 300);// x:100,y:100 자리에 텍스트 생성
		for (int i = 0; i < 25; i++) {
			g.setColor(rect[i].color);
			g.fillRect(rect[i].x, rect[i].y, rect[i].size, rect[i].size);
			g.setColor(Color.black);
			g.drawRect(rect[i].x, rect[i].y, rect[i].size, rect[i].size);
			g.drawString(rect[i].num + "", rect[i].x + 20, rect[i].y + 30);// ""을 붙여주면 String 형식이 됨
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// 마우스가 해당 위치로 올라갔을 때
		int x = e.getX();
		int y = e.getY();
//		System.out.println(x + " " + y);
		for (int i = 0; i < 25; i++) {
			if (rect[i].x < x && rect[i].x + rect[i].size > x && rect[i].y < y && rect[i].y + rect[i].size > y) {
				// 맞는 사각형 찾기
				rect[i].color = Color.red;
			} else {
				rect[i].color = Color.white;
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();// 좌표를 다시 가져온다.
		int y = e.getY();
		System.out.println(x + " " + y);
		for (int i = 0; i < 25; i++) {
			if (rect[i].x < x && x < rect[i].x + rect[i].size) {
				if (rect[i].y < y && y < rect[i].y + rect[i].size) {
					if (i != count) {
						return;
					}
					rect[i].num = rect[i].back;// 뒷면으로 돌린다.
				}
			}
		}
		count++;
		if (count == 50) {
			System.out.println("게임 종료!");
			return;
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
public class One_to_50 {
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setTitle("1TO50");
		jf.setLocation(200, 200);
		jf.setSize(800, 800);
		jf.setVisible(true);
		My_panel mp = new My_panel();
		jf.setContentPane(mp);
		jf.revalidate();
	}
}
