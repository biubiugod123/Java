package socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) {
		try {
			Socket s = new Socket("192.168.0.105",8888);
			
			new SendThread(s).start();
			new RecieveThread(s).start();


			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
