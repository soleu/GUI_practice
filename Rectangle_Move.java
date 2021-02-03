package Mouse;
import java.awt.color.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
class Rect {
	int x;
	int y;
	int size;
	Color color = Color.black;
	String text;// 화살표에 넣을 텍스트
}
class panelRC extends JPanel implements MouseListener, MouseMotionListener {
	Rect rect = new Rect();// 움직이는 사각형
	Rect fixedRect = new Rect();// 고정된 사각형
	Rect[] arrow = new Rect[4];// 화살표
	int state = -1;
	int speed = 1;// 스피드로 움직임 조절
	panelRC() {
		addMouseListener(this);
		addMouseMotionListener(this);
		rect.x = 200;
		rect.y = 200;
		rect.size = 100;
		rect.color = Color.blue;
		fixedRect.x = 700;
		fixedRect.y = 300;
		fixedRect.size = 100;
		for (int i = 0; i < 4; i++) {
			arrow[i] = new Rect();
			arrow[i].x = 700 + i * 50;
			arrow[i].y = 700;
			arrow[i].color = Color.white;
			arrow[i].size = 50;
		}
		arrow[0].x = 800;
		arrow[0].y = 650;
		arrow[0].text = "↑";
		arrow[1].text = "←";
		arrow[2].text = "↓";
		arrow[3].text = "→";
	}
	void update() {
		if (state == 0) {// 0번째 화살표에 눌림 발생
			rect.y -= speed;
		} else if (state == 1) {
			rect.x -= speed;
		} else if (state == 2) {
			rect.y += speed;
		} else if (state == 3) {
			rect.x += speed;
		}
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			Thread.sleep(10);
			repaint();
		} catch (Exception e) {
		}
		update();
		g.setColor(Color.pink);
		g.fillRect(rect.x, rect.y, rect.size, rect.size);
		g.setColor(Color.black);// 이걸 안하면 다른 개체들도 이색깔이 됨
		g.drawRect(rect.x, rect.y, rect.size, rect.size);
		g.drawRect(fixedRect.x, fixedRect.y, fixedRect.size, fixedRect.size);
		for (int i = 0; i < 4; i++) {
			g.setColor(arrow[i].color);// 그냥했을때, 바탕색깔이됨
			g.fillRect(arrow[i].x, arrow[i].y, arrow[i].size, arrow[i].size);// fill을 올리고
			g.setColor(Color.black);// 다시 테두리를 올림
			g.drawRect(arrow[i].x, arrow[i].y, arrow[i].size, arrow[i].size);// 그걸 그린다.
			g.drawString(arrow[i].text, arrow[i].x + 20, arrow[i].y + 30);
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseMoved(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
//마우스를 눌렸을때는 그레이 색
		int x = e.getX();
		int y = e.getY();
		for (int i = 0; i < 4; i++) {
			if (x > arrow[i].x && x < arrow[i].x + arrow[i].size && y > arrow[i].y && y < arrow[i].y + arrow[i].size) {
				arrow[i].color = Color.lightGray;
				state = i;// 몇번이 눌렸는지 표기,박스 상태 움직이기
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
//마우스를 풀었을때는 다시 하얗게
		int x = e.getX();
		int y = e.getY();
		for (int i = 0; i < 4; i++) {
			if (x > arrow[i].x && x < arrow[i].x + arrow[i].size && y > arrow[i].y && y < arrow[i].y + arrow[i].size) {
				arrow[i].color = Color.white;// 다시 원래색으로
				state = -1;// 눌린거 없을때는 -1
			}
		}
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
public class RectMove {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Moving Rectangle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(200, 200);
		frame.setSize(800, 800);
		frame.setVisible(true);
		panelRC pc = new panelRC();
		frame.setContentPane(pc);
		frame.revalidate();
	}
}
