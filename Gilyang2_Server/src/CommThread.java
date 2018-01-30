import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 
 * @author ������, ����ȣ
 * This class is CommThread
 * read health from users and compute win and send it to user
 * @return
 */

public class CommThread extends Thread {
	public int previous_Health = 15;
	private Socket soc;
	private int id;
	public CommThread (Socket soc, int id) {
		this.soc = soc;
		this.id = id;
	}
	public void run () {
		try {

			DataInputStream dis = new DataInputStream(soc.getInputStream());

			int health = dis.readInt();

			int difference = (health - previous_Health) / 5;
			int win_proab = 50 + difference * 5;

			OutputStream os = soc.getOutputStream ();
			DataOutputStream dos = new DataOutputStream (os);

			if((int)(Math.random()*100) + 1 <= win_proab){ // 1 to 100
				dos.writeUTF("���ֿ��� �¸��ߴ�!");
			}
			else{
				dos.writeUTF("���ֿ��� �й��ߴ�..");
			}


			previous_Health = health;

			System.out.println (Server.getLog ("message is sent (" + id + ")"));
			dis.close();
			dos.close ();
			this.soc.close ();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}