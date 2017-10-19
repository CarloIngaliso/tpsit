import java.util.concurrent.TimeUnit;

public class Simul3 {
	/*In quest'ultimo caso i thread accedono in modo diverso alle risorse (in ordine opposto): non possono accedere ad alcune zone (zona I) e si intrappolano in altre (zona T) dando luogo ad un deadlock.
Viene realizzata la classe*/
    public static void main(String[] args) {
        Risorsa primaRisorsa = new Risorsa("primaRisorsa");
        Risorsa secondaRisorsa = new Risorsa("secondaRisorsa");
        Thread primo = new Thread(new Task(primaRisorsa, secondaRisorsa));
        Thread secondo = new Thread(new Task(secondaRisorsa, primaRisorsa));
        primo.setName("primo");
        secondo.setName("secondo");
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
