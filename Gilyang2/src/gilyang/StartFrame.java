package gilyang;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
/**
 * This class is StartFrame.
 * This class display starting screen.
 * @author ����ȣ,������
 * @return
 */
public class StartFrame extends JFrame{
	StartFrame(){
		setTitle("����� Ű���");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout (null);
		
		ImageIcon icon = new ImageIcon("src/resources/cat.jpg");
		
		JLabel l2 = new JLabel("<html>���հ��� ����� Ű���!");
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("210 �ǹ���û�� R", Font.BOLD, 30));
		l2.setBounds(291, 271, 338, 77);
		getContentPane().add(l2);
		
		JButton start = new JButton("�����ϱ�!");
		start.setBounds(400, 400, 100, 40);
		start.addActionListener(new ButtonClickListener_start());
		getContentPane().add(start);
		//	JLabel l2 = new JLabel (icon);
		//	l2.setBounds(0, 0, 900, 600);
		//	add(l2);
			
			

			JLabel l = new JLabel(icon);
			//	l.setFont(new Font("����ü",Font.BOLD,40));
				l.setBounds(0, 0, 900, 600);
				getContentPane().add(l);
		
		
		setSize (900,600); // pixel
		setVisible (true);
	}
	
	private class ButtonClickListener_start implements ActionListener{
		public void actionPerformed (ActionEvent e){
			String command = e.getActionCommand();
			if(command.equals("�����ϱ�!")){
				setVisible(false);
				SelectFrame sf = new SelectFrame();
			}
		}
	}
	
}
