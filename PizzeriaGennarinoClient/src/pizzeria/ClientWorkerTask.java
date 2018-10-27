package pizzeria;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luca.daminato
 */
public class ClientWorkerTask implements Runnable {
	
	private PrintWriter pw;
	private BufferedReader br;
	
	public ClientWorkerTask(Socket client) throws Exception {
		pw= new PrintWriter(client.getOutputStream());
		br = new BufferedReader(new InputStreamReader(client.getInputStream()));
	}

	@Override
	public void run() {
		String data="";
		pw.println("GET MENU");
		pw.flush();
		while(true){
			try {
				data=br.readLine()+"\n";
				while(br.ready()){
					data+=br.readLine()+"\n";
				}
				parse(data);
				data="";
			} catch (IOException ex) {
			}
		}
	}

	private void parse(String data) {
		if(data.contains("MENU")){
			Scanner s = new Scanner(data);
			s.useDelimiter(":");
			String menu="";
			while(s.hasNext()){
				String line = s.next();
				if(line.equals("name")){
					line= s.next();
					menu+="Nome: "+line;
				}else if(line.equals("price")){
					line=" Prezzo: "+s.next()+"\n";
					menu+=line;
				}
			}
			System.out.println(menu);
			System.out.println("\nScegli Pizza (quit to exit): ");
			s = new Scanner(System.in);
			String choice=s.nextLine();
			String response="";
			while(true){
				if(choice.contains("quit")){
					break;
				}
				else
					response+="Pizza:"+choice.toLowerCase()+":";
				choice=s.nextLine();
			}
			pw.println(response);
			pw.flush();
		}else if(data.contains("Scontrino")){
			System.out.println("\n\n"+data);
		}
	}
	
}
