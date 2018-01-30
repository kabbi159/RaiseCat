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
 * @author 김윤호,현지웅
 * @return
 */
public class StartFrame extends JFrame{
	StartFrame(){
		setTitle("길냥이 키우기");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout (null);
		
		ImageIcon icon = new ImageIcon("src/resources/cat.jpg");
		
		JLabel l2 = new JLabel("<html>성균관대 길냥이 키우기!");
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("210 맨발의청춘 R", Font.BOLD, 30));
		l2.setBounds(291, 271, 338, 77);
		getContentPane().add(l2);
		
		JButton start = new JButton("시작하기!");
		start.setBounds(400, 400, 100, 40);
		start.addActionListener(new ButtonClickListener_start());
		getContentPane().add(start);
		//	JLabel l2 = new JLabel (icon);
		//	l2.setBounds(0, 0, 900, 600);
		//	add(l2);
			
			

			JLabel l = new JLabel(icon);
			//	l.setFont(new Font("굴림체",Font.BOLD,40));
				l.setBounds(0, 0, 900, 600);
				getContentPane().add(l);
		
		
		setSize (900,600); // pixel
		setVisible (true);
	}
	
	private class ButtonClickListener_start implements ActionListener{
		public void actionPerformed (ActionEvent e){
			String command = e.getActionCommand();
			if(command.equals("시작하기!")){
				setVisible(false);
				SelectFrame sf = new SelectFrame();
			}
		}
	}
	
}
