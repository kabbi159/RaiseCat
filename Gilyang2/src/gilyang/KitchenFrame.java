package gilyang;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class is KitchenFrame.
 * This class give four functions ��Ա�,�����ñ�,�ȹ�,����
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

public class KitchenFrame extends JFrame{
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
	
	KitchenFrame(int dirty, int tired, int hungry, int thirsty, int health, String name){
		setTitle("����� Ű��� - �ξ�");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout (null);
		
		this.name = name;
		this.dirty = dirty;
		this.tired = tired;
		this.hungry = hungry;
		this.thirsty = thirsty;
		this.health = health;
		
		
		ImageIcon icon = new ImageIcon("src/resources/kitchen.jpg");
		
		JButton eatButton = new JButton("�� �Ա�");
		eatButton.setBounds(700, 280, 100, 30);
		eatButton.addActionListener(new ButtonClickListener_eat());
		getContentPane().add(eatButton);
		
		JButton drinkButton = new JButton("�� ���ñ�");
		drinkButton.setBounds(100, 300, 100, 30);
		drinkButton.addActionListener(new ButtonClickListener_drink());
		getContentPane().add(drinkButton);
		
		JButton bedroomButton = new JButton("�ȹ�");
		bedroomButton.setBounds(750, 500, 100, 30);
		bedroomButton.addActionListener(new ButtonClickListener_move());
		getContentPane().add(bedroomButton);
		
		JButton groundButton = new JButton("����");
		groundButton.setBounds(30, 500, 100, 30);
		groundButton.addActionListener(new ButtonClickListener_move());
		getContentPane().add(groundButton);
		
		JLabel l = new JLabel(icon);
		l.setBounds(0, 0, 900, 600);
		getContentPane().add(l);
		

		

		
		setSize(900,600);
		setVisible(true);
	}
	
	private class ButtonClickListener_eat implements ActionListener{
		public void actionPerformed (ActionEvent e){
			String command = e.getActionCommand();
			if(command.equals("�� �Ա�")){
				int intValue = (int) (Math.random()*4)+1;
				if(getHealth() > intValue){
					setHealth(getHealth() - intValue);
				}
				else setHealth(0);
				
				if(getDirty() < 95){
					setDirty(getDirty() + 5);
				}
				else setDirty(100);
				
				if(getHungry() > 80){
					setHungry(getHungry() -80);
				}
				else setHungry(0);
				
				if(getThirsty() < 90){
					setThirsty(getThirsty() + 10);
				}
				else setThirsty(100);
				
				JFrame resultFrame = new JFrame("�� �Ա�");
				JLabel resultLabel = new JLabel();
				resultFrame.getContentPane().setLayout(null);
				resultLabel.setBounds(80, 40, 150, 150);
				resultLabel.setFont(new Font("����ü",Font.CENTER_BASELINE,14));
				resultLabel.setText("<html>�� �԰ڴٳ�~<br><br>"+name +" �� ����<br>������: "+ getDirty()+ "<br>�ǰ��� : "+ getTired()+"<br>����� : "+ getHungry()+ "<br>�񸶸�: "+ getThirsty());
				resultFrame.getContentPane().add(resultLabel);
				resultFrame.setSize(300, 300);
				resultFrame.setVisible(true);
			}
		}
	}
	
	
	private class ButtonClickListener_drink implements ActionListener{
		public void actionPerformed (ActionEvent e){
			String command = e.getActionCommand();
			if(command.equals("�� ���ñ�")){			
				if(getHealth() < 99){
					setHealth(getHealth() + 3);
				}
				else setHealth(100);
				
				if(getHungry() > 10){
					setHungry(getHungry() -10);
				}
				else setHungry(0);
				
				if(getThirsty() > 70){
					setThirsty(getThirsty() - 70);
				}
				else setThirsty(0);
				
				JFrame resultFrame = new JFrame("�� ���ñ�");
				JLabel resultLabel = new JLabel();
				resultFrame.getContentPane().setLayout (null);
				resultLabel.setBounds(80,40,150,150);
				resultLabel.setFont(new Font("����ü",Font.CENTER_BASELINE,14));
				resultLabel.setText("<html>'�� ���ðڴٳ�'~<br><br>"+name +" �� ����<br>������: "+ getDirty()+ "<br>�ǰ��� : "+ getTired()+"<br>����� : "+ getHungry()+ "<br>�񸶸�: "+ getThirsty());
				resultFrame.getContentPane().add(resultLabel);
				resultFrame.setSize(300, 300);
				resultFrame.setVisible(true);
			}
		}
	}
	
	private class ButtonClickListener_move implements ActionListener{
		public void actionPerformed (ActionEvent e){
			String command = e.getActionCommand();
			if(command.equals("�ȹ�")){
				setVisible(false);
				BedroomFrame bf = new BedroomFrame(getDirty(),getTired(),getHungry(),getThirsty(),getHealth(), name);
			}
			if(command.equals("����")){
				setVisible(false);
				GroundFrame gf = new GroundFrame(getDirty(),getTired(),getHungry(),getThirsty(),getHealth(), name);
			}
		}
	}
	
}
