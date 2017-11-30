import java.util.concurrent.CountDownLatch;

public class RiempiCercaArray {

    public int[] fillArray(int array[]) {
        for (int i = 0; i < array.length; i++){
              array[i] = (int)(Math.random() * 1000);
            }
            return array;
        }
	
    

    public int searchMaxValue(int[] array) {
		int max = 0;
        for (int i= 0; i < array.length; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (array[i] > max) {
                    max = array[i];
                }
            }
        return max;
    }


}
