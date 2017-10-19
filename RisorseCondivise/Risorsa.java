import java.util.concurrent.Semaphore;

//realizza mediante un semaforo binario (un solo permits) la risorsa.
public class Risorsa {
    Semaphore semaforo;
    String nome;

    public Risorsa (String nome){
        this.nome = nome;
        this.semaforo = new Semaphore(1, true);
    }

    public String getName(){
        return nome;
    }

}
