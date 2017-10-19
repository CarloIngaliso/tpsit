import java.util.concurrent.TimeUnit;

public class Simul1 {
	//In questo primo caso i due thread non possono usare la risorsa non condivisibile in contemporanea (zona V) e quindi non possono entrare in zona vietata.
    public static void main(String[] args) {
        Risorsa primaRisorsa = new Risorsa("PrimaRisorsa");
        Thread primo = new Thread(new Task(primaRisorsa));
        Thread secondo = new Thread(new Task(primaRisorsa));
        primo.setName("primo");
        secondo.setName("secondo");
        primo.start();
        secondo.start();
        try{
            TimeUnit.SECONDS.sleep(10);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        primo.interrupt();
        secondo.interrupt();
    }
}
