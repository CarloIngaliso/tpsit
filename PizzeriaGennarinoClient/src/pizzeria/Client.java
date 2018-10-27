package pizzeria;

import java.net.*;

/**
 *
 * @author luca.daminato
 */
public class Client {

	public static void main(String[] args) throws Exception {
		Socket client = new Socket("localhost",8080);
		new Thread(new ClientWorkerTask(client)).start();
	}
	
}
