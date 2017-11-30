import java.util.concurrent.CountDownLatch;

public class Test{

public static void main(String[] args) {  
	RiempiCercaArray istanza = new RiempiCercaArray();
	int[] array = istanza.fillArray(new int[100]);
int totalThreads = 10;
int[] results = new int[totalThreads];
int chunkSize = array.length / totalThreads;
CountDownLatch end = new CountDownLatch(totalThreads);
for (int i = 0; i < totalThreads; i++) {
    int threadIndex = i;
    new Thread(
        () -> {
            int max = -1;
            int startIndex = threadIndex * chunkSize;
			for (int k = 0; k < array.length; k++) {
				if (max <  array[k]) {
					max = array[k];
				}
			}
            results[threadIndex] = max;
            end.countDown();
        }
    ).start();
}

int max = results[0];
for (int k = 1; k < results.length; k++) {
    if (max < results[k]) {
        max = results[k];
    }
}
System.out.printf("Max found %d%n", max);
}
}
