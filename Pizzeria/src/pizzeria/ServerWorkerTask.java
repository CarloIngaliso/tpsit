package pizzeria;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luca.daminato
 */
public class ServerWorkerTask implements Runnable {
	
	private PrintWriter pw;
	private BufferedReader br;
	private Pizzeria pizzeria;
	
	public ServerWorkerTask(Pizzeria pizzeria,Socket client) throws Exception {
		this.pizzeria=pizzeria;
		pw= new PrintWriter(client.getOutputStream());
		br = new BufferedReader(new InputStreamReader(client.getInputStream()));
	}

	@Override
	public void run() {
		String data="";
		String res="";
		while(true){
			try {
				data=br.readLine();
				while(br.ready()){
					data+=br.readLine();
				}
				if(!data.equals("")){
					res=pizzeria.parse(data);
					pw.println(res);
					pw.flush();
				}
				data="";
			} catch (Exception ex) {
			
			}
		}
	}
}
