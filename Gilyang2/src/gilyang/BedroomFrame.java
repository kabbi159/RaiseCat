package gilyang;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class is BedroomFrame.
 * This class give three functions �ı�,���ڱ�,�ξ�
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
public class BedroomFrame extends JFrame{

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



	BedroomFrame(int cattype ,String catname){
		setTitle("����� Ű��� - �ȹ�");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout (null);

		this.name = catname;
		this.type = cattype;
		this.dirty = 20; 
		this.tired = 20;
		this.hungry = 20;
		this.thirsty = 20;
		this.health = 10;
		ImageIcon icon = new ImageIcon("src/resources/bedroom.jpg");

		JButton washButton = new JButton("�ı�");
		washButton.setBounds(300, 280, 100, 30);
		washButton.addActionListener(new ButtonClickListener_wash());
		getContentPane().add(washButton);

		JButton sleepButton = new JButton("���ڱ�");
		sleepButton.setBounds(520, 400, 100, 30);
		sleepButton.addActionListener(new ButtonClickListener_sleep());
		getContentPane().add(sleepButton);

		JButton kitchenButton = new JButton("�ξ�");
		kitchenButton.setBounds(30,480,100,30);
		kitchenButton.addActionListener(new ButtonClickListener_kitchen());
		getContentPane().add(kitchenButton);

		JLabel l = new JLabel(icon);
		l.setBounds(0, 0, 900, 600);
		getContentPane().add(l);




		setSize(900,600);
		setVisible(true);
	}

	BedroomFrame(int dirty, int tired, int hungry, int thirsty, int health, String name){
		setTitle("����� Ű��� - �ȹ�");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout (null);

		this.name = name;
		this.dirty = dirty;
		this.tired = tired;
		this.hungry = hungry;
		this.thirsty = thirsty;
		this.health = health;
		ImageIcon icon = new ImageIcon("src/resources/bedroom.jpg");

		JButton washButton = new JButton("�ı�");
		washButton.setBounds(300, 280, 100, 30);
		washButton.addActionListener(new ButtonClickListener_wash());
		getContentPane().add(washButton);

		JButton sleepButton = new JButton("���ڱ�");
		sleepButton.setBounds(520, 400, 100, 30);
		sleepButton.addActionListener(new ButtonClickListener_sleep());
		getContentPane().add(sleepButton);

		JButton kitchenButton = new JButton("�ξ�");
		kitchenButton.setBounds(30,500,100,30);
		kitchenButton.addActionListener(new ButtonClickListener_kitchen());
		getContentPane().add(kitchenButton);

		JLabel l = new JLabel(icon);
		l.setBounds(0, 0, 900, 600);
		getContentPane().add(l);




		setSize(900,600);
		setVisible(true);
	}

	private class ButtonClickListener_wash implements ActionListener{
		public void actionPerformed (ActionEvent e){
			String command = e.getActionCommand();
			if(command.equals("�ı�")){
				if(getDirty() > 80){
					setDirty(getDirty()-80);
				}
				else setDirty(0);

				if(getTired() < 80){
					setTired(getTired()+20);
				}
				else {
					setHealth(getHealth() - 2);
					if(getHealth() < 0) setHealth(0);
					setTired(100);
				}

				if(getHungry()< 90){
					setHungry(getHungry()+10);
				}
				else setHungry(100);

				if(getThirsty() < 80){
					setThirsty(getThirsty()+20);
				}
				else setThirsty(100);

				JFrame resultFrame = new JFrame("�ı�");
				JLabel resultLabel = new JLabel();
				resultFrame.getContentPane().setLayout(null);
				resultLabel.setBounds(80, 40, 150, 150);
				resultLabel.setFont(new Font("����ü",Font.CENTER_BASELINE,14));
				resultLabel.setText("<html>���̴� ����������!<br><br>"+name +" �� ����<br>������: "+ getDirty()+ "<br>�ǰ��� : "+ getTired()+"<br>����� : "+ getHungry()+ "<br>�񸶸�: "+ getThirsty());
				resultFrame.getContentPane().add(resultLabel);
				resultFrame.setSize(300, 300);
				resultFrame.setVisible(true);
			}
		}
	}

	private class ButtonClickListener_sleep implements ActionListener{
		public void actionPerformed (ActionEvent e){
			String command = e.getActionCommand();
			if(command.equals("���ڱ�")){
				if(getDirty() < 70){
					setDirty(getDirty() +30);
				}
				else setDirty(100);

				if(getTired() > 80){
					setTired(getTired()-80);
				}
				else setTired(0);

				if(getHungry() < 50){
					setHungry(getHungry()+50);
				}
				else setHungry(100);

				if(getThirsty() < 70){
					setThirsty(getThirsty() +30);
				}
				else setThirsty(100);

				JFrame resultFrame = new JFrame("���ڱ�");
				JLabel resultLabel = new JLabel();
				resultFrame.getContentPane().setLayout(null);
				resultLabel.setBounds(80, 40, 150, 150);
				resultLabel.setFont(new Font("����ü",Font.CENTER_BASELINE,14));
				resultLabel.setText("<html>Zzz...���ڳ�<br><br>"+name +" �� ����<br>������: "+ getDirty()+ "<br>�ǰ��� : "+ getTired()+"<br>����� : "+ getHungry()+ "<br>�񸶸�: "+ getThirsty());
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




}