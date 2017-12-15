
package merge;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Test {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci il numero di elementi da generare :");
        int numero = input.nextInt();
        System.out.println();
        MergeSort b = new MergeSort();
        int[] num = new int[numero];
        for (int a = 0; a < num.length; a++) {
            num[a] = (int) (Math.random() * 10000);
        }

        Thread t = new Thread(new threadSort(b, num));
        long startTime = System.nanoTime();
        t.start();
        long estimatedTime = System.nanoTime() - startTime;

        TimeUnit.MILLISECONDS.sleep(10);

        int count = 0;
        for (int h : num) {
            System.out.print(h + " ");
            count++;
        }
        System.out.println();
        System.out.println("Tempo di ordinamento: " + estimatedTime / 1000 + " s");
        System.out.println();
    }

}