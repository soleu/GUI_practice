package Ticket_System;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
public class _Main {
	public static void main(String[] args) {
		TicketPanel tp=new TicketPanel();
		JFrame frame=new JFrame();
		Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(screenSize.width/2-600,screenSize.height/2-450);
		frame.setSize(1000,900);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setContentPane(tp);
		frame.revalidate();
	}
}