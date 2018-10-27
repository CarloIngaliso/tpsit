package pizzeria;

/**
 *
 * @a&uthor luca.daminato
 */
public class Main  {

	public static void main(String[] args) throws Exception {
		new Thread(new Server(8080)).start();
	}
	
}
