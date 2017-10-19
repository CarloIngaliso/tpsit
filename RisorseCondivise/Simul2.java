import java.util.concurrent.TimeUnit;

public class Simul2 {
	//In questo secondo caso ogni singolo thread usa due risorse e vie è un momento in cui le usa entrambe, ma i due tread accedono in modo analogo alle risorse (prima la prima risorsa e poi la seconda). 
    public static void main(String[] args) {
        Risorsa primaRisorsa = new Risorsa("primaRisorsa");
        Risorsa secondaRisorsa = new Risorsa("secondaRisorsa");
        Thread primo = new Thread(new Task(primaRisorsa, secondaRisorsa));
        Thread secondo = new Thread(new Task(primaRisorsa, secondaRisorsa));
        primo.setName("primo");
        secondo.setName("t2");
        primo.start();
        secondo.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        primo.interrupt();
        secondo.interrupt();
    }
}
