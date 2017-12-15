
import java.util.concurrent.Semaphore;

public class Controllore extends Thread{
    private Semaphore s;
    private int p;

    Controllore(Semaphore s, int p){
        this.s = s;
        this.p = p;
    }

    @Override
    public void run(){
        System.out.println("Controllore! I passeggeri sono i seguenti:");
        int i;
        for(i = 0; i<p-s.availablePermits()-1; i++)
            System.out.print("Passeggero"+(i+1)+", ");
        System.out.print("Passeggero"+(i+1)+"\n");
    }

}
