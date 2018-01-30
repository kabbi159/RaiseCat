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
 * It gives chances for choosing cats Ȧ�߳���,�������,�������� and gives explanation.
 * @author ����ȣ,������
 * @return
 */

public class SelectFrame extends JFrame{
	SelectFrame(){
		setTitle("����� Ű���");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout (null);
		
		
		JButton infoButton1 = new JButton("���߳���");
		infoButton1.setForeground(Color.BLACK);
		infoButton1.setFont(new Font("���������� ExtraBold", Font.BOLD, 30));
		infoButton1.setBounds(51, 27, 182, 77);
		infoButton1.addMouseListener(new ButtonMouseEntered_select1());
		getContentPane().add(infoButton1);
		
		JButton infoButton2 = new JButton("�������");
		infoButton2.setForeground(Color.BLACK);
		infoButton2.setFont(new Font("���������� ExtraBold", Font.BOLD, 30));
		infoButton2.setBounds(350, 27, 182, 77);
		infoButton2.addMouseListener(new ButtonMouseEntered_select2());
		getContentPane().add(infoButton2);
		
		JButton infoButton3 = new JButton("��������");
		infoButton3.setForeground(Color.BLACK);
		infoButton3.setFont(new Font("���������� ExtraBold", Font.BOLD, 30));
		infoButton3.setBounds(640, 27, 182, 77);
		infoButton3.addMouseListener(new ButtonMouseEntered_select3());
		getContentPane().add(infoButton3);
		
		JButton typeButton1 = new JButton("Ȧ�߳��� ����");
		typeButton1.setIcon(new ImageIcon(SelectFrame.class.getResource("/resources/cat_thin.jpg")));
		typeButton1.setBounds(14, 116, 270, 270);
		typeButton1.addActionListener(new ButtonClickListener_select());
		getContentPane().add(typeButton1);
		
		JButton typeButton2 = new JButton("������� ����");
		typeButton2.setIcon(new ImageIcon(SelectFrame.class.getResource("/resources/cat_normal.jpg")));
		typeButton2.setBounds(308, 116, 270, 270);
		typeButton2.addActionListener(new ButtonClickListener_select());
		getContentPane().add(typeButton2);
		
		JButton typeButton3 = new JButton("�������� ����");
		typeButton3.setIcon(new ImageIcon(SelectFrame.class.getResource("/resources/cat_fat.jpg")));
		typeButton3.setBounds(602, 116, 270, 270);
		typeButton3.addActionListener(new ButtonClickListener_select());
		getContentPane().add(typeButton3);
		
		JLabel lblNewLabel = new JLabel("<html>�̸� ��ư�� ���콺�� ��� �� ���̿� ���� �ڼ��� ������ ���´ٳ�~ <br> �׸� ��ư�� ������ �� ���̸� �����ϰ� �ȴٳ�~");
		lblNewLabel.setFont(new Font("����������", Font.PLAIN, 18));
		lblNewLabel.setBounds(350, 481, 518, 45);
		getContentPane().add(lblNewLabel);
		
		
		setSize (900,600); // pixel
		setVisible (true);
	}
	
	 private class ButtonClickListener_select implements ActionListener{
		public void actionPerformed (ActionEvent e){
			
			String command = e.getActionCommand();
			if(command.equals("Ȧ�߳��� ����")){
				JFrame nameFrame = new JFrame("�̸�����");
				JLabel nameLabel = new JLabel();
				JTextField nameInput = new JTextField();
				JButton sendButton = new JButton("����");
				nameFrame.getContentPane().setLayout (null);
				
				nameLabel.setFont(new Font("����ü",Font.CENTER_BASELINE,14));
				nameLabel.setText("����! �� �̸��� ���� �����ų�~");
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
			
			if(command.equals("������� ����")){
				JFrame nameFrame = new JFrame("�̸�����");
				JLabel nameLabel = new JLabel();
				JTextField nameInput = new JTextField();
				JButton sendButton = new JButton("����");
				nameFrame.getContentPane().setLayout (null);
				
				nameLabel.setFont(new Font("����ü",Font.CENTER_BASELINE,14));
				nameLabel.setText("����! �� �̸��� ���� �����ų�~");
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
			
			if(command.equals("�������� ����")){
				JFrame nameFrame = new JFrame("�̸�����");
				JLabel nameLabel = new JLabel();
				JTextField nameInput = new JTextField();
				JButton sendButton = new JButton("����");
				nameFrame.getContentPane().setLayout (null);
				
				nameLabel.setFont(new Font("����ü",Font.CENTER_BASELINE,14));
				nameLabel.setText("����! �� �̸��� ���� �����ų�~");
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
			((JButton)me.getSource()).setFont(new Font("����������", Font.CENTER_BASELINE, 18));
			((JButton)me.getSource()).setText("<html>Ȧ�߳��̴� ���� �ݵ�ü���� �շ��մϴ�.<br>���� ���������� ���� �ݹ� �����մϴ�.");
		}
		public void mouseExited(MouseEvent me){
			((JButton)me.getSource()).setBounds(51, 27, 182, 77);
			((JButton)me.getSource()).setFont(new Font("����������", Font.CENTER_BASELINE, 30));
			((JButton)me.getSource()).setText("Ȧ�߳���");
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
			((JButton)me.getSource()).setFont(new Font("����������", Font.CENTER_BASELINE, 18));
			((JButton)me.getSource()).setText("<html>������̴� ���� ����մϴ�.<br>�������°� �� �ܵ𿡼� ������ ���� �����մϴ�.");
		}
		public void mouseExited(MouseEvent me){
			((JButton)me.getSource()).setBounds(350, 27, 182, 77);
			((JButton)me.getSource()).setFont(new Font("����������", Font.CENTER_BASELINE, 30));
			((JButton)me.getSource()).setText("�������");
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
			((JButton)me.getSource()).setFont(new Font("����������", Font.CENTER_BASELINE, 18));
			((JButton)me.getSource()).setText("<html>�������̴� �Ű� B�� ��ó�� ��ϴ�.<br>���� �׶��ؼ� �ݹ� ��������ϴ�.");
		}
		public void mouseExited(MouseEvent me){
			((JButton)me.getSource()).setBounds(640, 27, 182, 77);
			((JButton)me.getSource()).setFont(new Font("����������", Font.CENTER_BASELINE, 30));
			((JButton)me.getSource()).setText("��������");
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
