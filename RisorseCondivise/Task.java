import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

//Task che rappresenta il compito (Runnable) di un singolo thread. Tale classe accederà alle risorse.

public class Task extends Thread {
     Semaphore semaforo;
     Risorsa primaRisorsa;
     Risorsa secondaRisorsa;

    public Task(Risorsa primaRisorsa, Risorsa SecondaRisorsa) {
        this.primaRisorsa = primaRisorsa;
        this.secondaRisorsa = secondaRisorsa;
    }

    public Task(Risorsa primaRisorsa) {
        this(primaRisorsa,null);
    }

    public void run() {
        for (; ; ) {
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                if (secondaRisorsa == null) {
                    primaRisorsa.semaforo.acquire();
                    System.out.println(this.getName() + " ha come risorsa " + primaRisorsa.getName());
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                    primaRisorsa.semaforo.release();
                    System.out.println(this.getName() + " ha rilasciato la risorsa " + primaRisorsa.getName());
                }
                else{
                    primaRisorsa.semaforo.acquire();
                    secondaRisorsa.semaforo.acquire();
                    System.out.println(this.getName() + " ha come risorsa " + primaRisorsa.getName() + " e " + secondaRisorsa.getName());
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                    primaRisorsa.semaforo.release();
                    secondaRisorsa.semaforo.release();
                    System.out.println(this.getName() + " ha rilasciato la risorsa  " + primaRisorsa.getName() + " e " + secondaRisorsa.getName());
                }
            } catch (InterruptedException e) {
                System.out.println(this.getName() + " e terminato "); 
                break;
            }
        }
    }
}
