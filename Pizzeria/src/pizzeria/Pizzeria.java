package pizzeria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author luca.daminato
 */
public class Pizzeria {
	
	private String menu;
	
	public String parse(String data) throws Exception {
		System.out.println(data);
		String response="";
		if(data.contains("GET MENU")){
			FileReader f;
			f=new FileReader("C:\\Users\\luca.daminato.LAP.000\\Documents\\NetBeansProjects\\Pizzeria\\src\\pizzeria\\pizze.txt");

			BufferedReader b;
			b=new BufferedReader(f);

			response="MENU\n";
			while(b.ready()){
				response+=b.readLine()+"\n";
			}
			menu=response;
		}
		else if(data.contains("Pizza")){
			Scanner s = new Scanner(data);
			s.useDelimiter(":");
			float price=0;
			ArrayList<String> pizze= new ArrayList<>();
			while(s.hasNext()){
				String line = s.next();
				if(line.equals("Pizza")){
					line=s.next();
					pizze.add(line);
				}
			}
			response="Scontrino: \n\n";
			response+="Pizze Ordinate:\n\n";
			for(int i=0; i<pizze.size();i++){
				s= new Scanner(menu);
				s.useDelimiter(":");
				while(s.hasNext()){
					String line = s.next().toLowerCase();
					if(line.equals(pizze.get(i))){
						response+=pizze.get(i)+"\n";
						s.next();
						price+=Float.parseFloat(s.next());
					}
				}
			}
			response+="Prezzo: \n"+price;
			System.out.println(response);
		}
		return response;
	}
}
