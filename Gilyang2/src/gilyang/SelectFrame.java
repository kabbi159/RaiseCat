package gilyang;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * This class is SelectFrame.
 * It gives chances for choosing cats 홀쭉냥이,평범냥이,돼지냥이 and gives explanation.
 * @author 김윤호,현지웅
 * @return
 */

public class SelectFrame extends JFrame{
	SelectFrame(){
		setTitle("길냥이 키우기");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout (null);
		
		
		JButton infoButton1 = new JButton("훌쭉냥이");
		infoButton1.setForeground(Color.BLACK);
		infoButton1.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 30));
		infoButton1.setBounds(51, 27, 182, 77);
		infoButton1.addMouseListener(new ButtonMouseEntered_select1());
		getContentPane().add(infoButton1);
		
		JButton infoButton2 = new JButton("평범냥이");
		infoButton2.setForeground(Color.BLACK);
		infoButton2.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 30));
		infoButton2.setBounds(350, 27, 182, 77);
		infoButton2.addMouseListener(new ButtonMouseEntered_select2());
		getContentPane().add(infoButton2);
		
		JButton infoButton3 = new JButton("돼지냥이");
		infoButton3.setForeground(Color.BLACK);
		infoButton3.setFont(new Font("나눔스퀘어 ExtraBold", Font.BOLD, 30));
		infoButton3.setBounds(640, 27, 182, 77);
		infoButton3.addMouseListener(new ButtonMouseEntered_select3());
		getContentPane().add(infoButton3);
		
		JButton typeButton1 = new JButton("홀쭉냥이 선택");
		typeButton1.setIcon(new ImageIcon(SelectFrame.class.getResource("/resources/cat_thin.jpg")));
		typeButton1.setBounds(14, 116, 270, 270);
		typeButton1.addActionListener(new ButtonClickListener_select());
		getContentPane().add(typeButton1);
		
		JButton typeButton2 = new JButton("평범냥이 선택");
		typeButton2.setIcon(new ImageIcon(SelectFrame.class.getResource("/resources/cat_normal.jpg")));
		typeButton2.setBounds(308, 116, 270, 270);
		typeButton2.addActionListener(new ButtonClickListener_select());
		getContentPane().add(typeButton2);
		
		JButton typeButton3 = new JButton("돼지냥이 선택");
		typeButton3.setIcon(new ImageIcon(SelectFrame.class.getResource("/resources/cat_fat.jpg")));
		typeButton3.setBounds(602, 116, 270, 270);
		typeButton3.addActionListener(new ButtonClickListener_select());
		getContentPane().add(typeButton3);
		
		JLabel lblNewLabel = new JLabel("<html>이름 버튼에 마우스를 대면 그 냥이에 대한 자세한 정보가 나온다냥~ <br> 그림 버튼을 누르면 그 냥이를 선택하게 된다냥~");
		lblNewLabel.setFont(new Font("나눔스퀘어", Font.PLAIN, 18));
		lblNewLabel.setBounds(350, 481, 518, 45);
		getContentPane().add(lblNewLabel);
		
		
		setSize (900,600); // pixel
		setVisible (true);
	}
	
	 private class ButtonClickListener_select implements ActionListener{
		public void actionPerformed (ActionEvent e){
			
			String command = e.getActionCommand();
			if(command.equals("홀쭉냥이 선택")){
				JFrame nameFrame = new JFrame("이름짓기");
				JLabel nameLabel = new JLabel();
				JTextField nameInput = new JTextField();
				JButton sendButton = new JButton("전송");
				nameFrame.getContentPane().setLayout (null);
				
				nameLabel.setFont(new Font("굴림체",Font.CENTER_BASELINE,14));
				nameLabel.setText("집사! 내 이름은 뭘로 지을거냥~");
				nameLabel.setBounds(93, 64, 235,85);
				nameFrame.getContentPane().add(nameLabel);
				
				nameInput.setBounds(93, 150, 134, 30);
				nameFrame.getContentPane().add(nameInput);
				
				sendButton.setBounds(241, 150, 80, 30);
				sendButton.addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent e){
						String catname = nameInput.getText();
						System.out.println(catname);
						nameFrame.setVisible(false);
						setVisible(false);
						BedroomFrame bf = new BedroomFrame(1,catname);
					}
				});
				nameFrame.getContentPane().add(sendButton);

				
				nameFrame.setSize(400, 300);
				nameFrame.setVisible(true);			
			}
			
			if(command.equals("평범냥이 선택")){
				JFrame nameFrame = new JFrame("이름짓기");
				JLabel nameLabel = new JLabel();
				JTextField nameInput = new JTextField();
				JButton sendButton = new JButton("전송");
				nameFrame.getContentPane().setLayout (null);
				
				nameLabel.setFont(new Font("굴림체",Font.CENTER_BASELINE,14));
				nameLabel.setText("집사! 내 이름은 뭘로 지을거냥~");
				nameLabel.setBounds(93, 64, 235,85);
				nameFrame.getContentPane().add(nameLabel);
				
				nameInput.setBounds(93, 150, 134, 30);
				nameFrame.getContentPane().add(nameInput);
				
				sendButton.setBounds(241, 150, 80, 30);
				sendButton.addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent e){
						String catname = nameInput.getText();
						System.out.println(catname);
						nameFrame.setVisible(false);
						setVisible(false);
						BedroomFrame bf = new BedroomFrame(2,catname);
					}
				});
				nameFrame.getContentPane().add(sendButton);

				
				nameFrame.setSize(400, 300);
				nameFrame.setVisible(true);		
				
			}
			
			if(command.equals("돼지냥이 선택")){
				JFrame nameFrame = new JFrame("이름짓기");
				JLabel nameLabel = new JLabel();
				JTextField nameInput = new JTextField();
				JButton sendButton = new JButton("전송");
				nameFrame.getContentPane().setLayout (null);
				
				nameLabel.setFont(new Font("굴림체",Font.CENTER_BASELINE,14));
				nameLabel.setText("집사! 내 이름은 뭘로 지을거냥~");
				nameLabel.setBounds(93, 64, 235,85);
				nameFrame.getContentPane().add(nameLabel);
				
				nameInput.setBounds(93, 150, 134, 30);
				nameFrame.getContentPane().add(nameInput);
				
				sendButton.setBounds(241, 150, 80, 30);
				sendButton.addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent e){
						String catname = nameInput.getText();
						System.out.println(catname);
						nameFrame.setVisible(false);
						setVisible(false);
						BedroomFrame bf = new BedroomFrame(3,catname);
					}
				});
				nameFrame.getContentPane().add(sendButton);

				
				nameFrame.setSize(400, 300);
				nameFrame.setVisible(true);		
				
			}
			
		
			
			
		}
		
		
	}
	

	
	
	
	
	private class ButtonMouseEntered_select1 implements MouseListener{
		public void mouseEntered(MouseEvent me){
			((JButton)me.getSource()).setBounds(51, 27, 182, 200);
			((JButton)me.getSource()).setFont(new Font("나눔스퀘어", Font.CENTER_BASELINE, 18));
			((JButton)me.getSource()).setText("<html>홀쭉냥이는 매일 반도체관을 왕래합니다.<br>따라서 날씬하지만 목이 금방 말라합니다.");
		}
		public void mouseExited(MouseEvent me){
			((JButton)me.getSource()).setBounds(51, 27, 182, 77);
			((JButton)me.getSource()).setFont(new Font("나눔스퀘어", Font.CENTER_BASELINE, 30));
			((JButton)me.getSource()).setText("홀쭉냥이");
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class ButtonMouseEntered_select2 implements MouseListener{
		public void mouseEntered(MouseEvent me){
			((JButton)me.getSource()).setBounds(350, 27, 182, 200);
			((JButton)me.getSource()).setFont(new Font("나눔스퀘어", Font.CENTER_BASELINE, 18));
			((JButton)me.getSource()).setText("<html>평범냥이는 정말 평범합니다.<br>산학협력관 앞 잔디에서 구르는 것을 좋아합니다.");
		}
		public void mouseExited(MouseEvent me){
			((JButton)me.getSource()).setBounds(350, 27, 182, 77);
			((JButton)me.getSource()).setFont(new Font("나눔스퀘어", Font.CENTER_BASELINE, 30));
			((JButton)me.getSource()).setText("평범냥이");
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class ButtonMouseEntered_select3 implements MouseListener{
		public void mouseEntered(MouseEvent me){
			((JButton)me.getSource()).setBounds(640, 27, 182, 200);
			((JButton)me.getSource()).setFont(new Font("나눔스퀘어", Font.CENTER_BASELINE, 18));
			((JButton)me.getSource()).setText("<html>돼지냥이는 신관 B동 근처에 삽니다.<br>따라서 뚱뚱해서 금방 배고파집니다.");
		}
		public void mouseExited(MouseEvent me){
			((JButton)me.getSource()).setBounds(640, 27, 182, 77);
			((JButton)me.getSource()).setFont(new Font("나눔스퀘어", Font.CENTER_BASELINE, 30));
			((JButton)me.getSource()).setText("돼지냥이");
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}


}
