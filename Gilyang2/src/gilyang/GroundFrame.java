package gilyang;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class is GroundFrame.
 * This class give three functions �����ϱ�,�����ϱ�,�ξ�
 * @author ����ȣ,������
 * @param name
 * @param type
 * @param dirty
 * @param tired
 * @param hungry
 * @param thirsty
 * @param health
 * @return
 */

public class GroundFrame extends JFrame {
	String name;
	int type;
	int dirty; 
	int tired;
	int hungry;
	int thirsty;
	int health;
	
	int getHealth(){
		return this.health;
	}
	
	void setHealth(int num){
		this.health = num;
	}
	
	int getDirty(){
		return this.dirty;
	}
	
	void setDirty(int num){
		this.dirty = num;
	}
	
	int getTired(){
		return this.tired;
	}
	
	void setTired(int num){
		this.tired = num;
	}
	
	int getHungry(){
		return this.hungry;
	}
	
	void setHungry(int num){
		this.hungry = num;
	}
	
	int getThirsty(){
		return this.thirsty;
	}
	
	void setThirsty(int num){
		this.thirsty = num;
	}
	
	
	GroundFrame(int dirty, int tired, int hungry, int thirsty, int health, String name){
		setTitle("����� Ű��� - ����");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout (null);
		
		this.name = name;
		this.dirty = dirty; 
		this.tired = tired;
		this.hungry = hungry;
		this.thirsty = thirsty;
		this.health = health;
		ImageIcon icon = new ImageIcon("src/resources/ground.jpg");
		
		JButton washButton = new JButton("�����ϱ�");
		washButton.setBounds(50, 500, 100, 30);
		washButton.addActionListener(new ButtonClickListener_walk());
		getContentPane().add(washButton);
		
		JButton raceButton = new JButton("�����ϱ�");
		raceButton.setBounds(750, 350, 100, 30);
		raceButton.addActionListener(new ButtonClickListener_race());
		getContentPane().add(raceButton);
		
		JButton kitchenButton = new JButton("�ξ�");
		kitchenButton.setBounds(350,250,100,30);
		kitchenButton.addActionListener(new ButtonClickListener_kitchen());
		getContentPane().add(kitchenButton);
		
		JLabel l = new JLabel(icon);
		l.setBounds(0, 0, 900, 600);
		getContentPane().add(l);
			
		
		
		
		setSize(900,600);
		setVisible(true);
	}
	
	private class ButtonClickListener_walk implements ActionListener{
		public void actionPerformed (ActionEvent e){
			String command = e.getActionCommand();
			if(command.equals("�����ϱ�")){ // dirty +40, hungry +30, thirsty +20, health +5
				if(getDirty() > 60){
					if(getHealth() > 5){
						setHealth(getHealth() - 5);
					}
					else setHealth(0);
					setDirty(100);
				}
				else{
					if(getHealth() < 95){
						setHealth(getHealth() + 5);
					}
					else setHealth(100);
					setDirty(getDirty() + 40);
				}
				
				
				if(getTired() < 60){
					setTired(getTired() + 40);
				}
				else {
					setHealth(getHealth() -3);
					if(getHealth() < 0) setHealth(0);
					setTired(100);
				}
				
				if(getHungry() < 70){
					setHungry(getHungry() +30);
				}
				else setHungry(100);
				
				if(getThirsty() < 80){
					setThirsty(getThirsty() + 20);
				}
				else setThirsty(100);
				
				
				
				JFrame resultFrame = new JFrame("�����ϱ�");
				JLabel resultLabel = new JLabel();
				resultFrame.getContentPane().setLayout(null);
				resultLabel.setBounds(80, 40, 150, 150);
				resultLabel.setFont(new Font("����ü",Font.CENTER_BASELINE,14));
				resultLabel.setText("<html>�� �ѹ����ٳ�~<br><br>"+name +" �� ����<br>������: "+ getDirty()+ "<br>�ǰ��� : "+ getTired()+"<br>����� : "+ getHungry()+ "<br>�񸶸�: "+ getThirsty());
				resultFrame.getContentPane().add(resultLabel);
				resultFrame.setSize(300, 300);
				resultFrame.setVisible(true);
			}
		}
	}
	
	private class ButtonClickListener_kitchen implements ActionListener{
		public void actionPerformed (ActionEvent e){
			String command = e.getActionCommand();
			if(command.equals("�ξ�")){
				setVisible(false);
				KitchenFrame kf = new KitchenFrame(getDirty(),getTired(),getHungry(),getThirsty(),getHealth(), name);
			}
		}
	}
	
	private class ButtonClickListener_race implements ActionListener{
		public void actionPerformed (ActionEvent e){
			String command = e.getActionCommand();
			if(command.equals("�����ϱ�")){
				
			new Send_Server().start();	
			
			
			
				
			}
		}
	}
	
	public class Send_Server extends Thread {
		public void run(){
		try{
			Socket soc = new Socket("localhost",5000);
			OutputStream os = soc.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);			

			
			dos.writeInt(getHealth()); 
	//		System.out.println("����� ������� �ǰ��� " + getHealth() + " �Դϴ�. ������ ���۵˴ϴ�.");
			System.out.println(name +"�� �ǰ��� ������ ���۵˴ϴ�");
			
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			String resultString = dis.readUTF();
			System.out.println(resultString);

			JFrame resultFrame = new JFrame("�����ϱ�");
			JLabel resultLabel = new JLabel();
			JButton resultButton = new JButton("Ȯ��");
			resultFrame.getContentPane().setLayout(null);
			resultLabel.setBounds(80, 40, 150, 150);
			resultLabel.setFont(new Font("����ü",Font.CENTER_BASELINE,14));
			resultLabel.setText("<html>"+name+" �� ���ְ� �������ϴ�!<br>����� Ȯ���Ϸ��� Ȯ�� ��ư�� �����ּ���.");
			resultButton.setBounds(100, 200, 90, 30);
			resultButton.addActionListener (new ActionListener(){
				public void actionPerformed (ActionEvent e){
					String command = e.getActionCommand();
					if(command.equals("Ȯ��")){
						resultFrame.setVisible(false);
						JFrame resultFrame2 = new JFrame("�����ϱ� - ���");
						JLabel resultLabel2 = new JLabel();
						resultFrame2.getContentPane().setLayout(null);
						resultLabel2.setBounds(80, 40, 150, 150);
						resultLabel2.setFont(new Font("����ü",Font.CENTER_BASELINE,14));
						resultLabel2.setText(resultString);
						resultFrame2.getContentPane().add(resultLabel2);
						resultFrame2.setSize(300, 300);
						resultFrame2.setVisible(true);
					}
				}
			});
			resultFrame.getContentPane().add(resultButton);
			resultFrame.getContentPane().add(resultLabel);
			resultFrame.setSize(300, 300);
			resultFrame.setVisible(true);
			
//			System.out.println(dis.readUTF());
			
			dis.close();
			dos.close();
			soc.close();

		} catch (IOException e){
			e.printStackTrace();
		}
	}
	}
	
	
	
	
}
