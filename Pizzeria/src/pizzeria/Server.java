package pizzeria;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luca.daminato
 */
public class Server implements Runnable{
	
	private ServerSocket ss;
	private Executor executor;
	private Pizzeria pizzeria;
	
	Server(int port) throws Exception {
		ss = new ServerSocket(port);
		executor= Executors.newFixedThreadPool(10);
		this.pizzeria=new Pizzeria();
	}

	@Override
	public void run() {
		while(true){
			try {
				Socket client = ss.accept();
				executor.execute(new ServerWorkerTask(this.pizzeria,client));
			} catch (Exception ex) {
				Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
