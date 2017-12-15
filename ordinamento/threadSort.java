package merge;

public class threadSort implements Runnable {

    MergeSort thread;
    int[] num;

    public threadSort(MergeSort thread, int[] num) {
        this.num = num;
        this.thread = thread;
    }

    @Override
    public void run() {

        thread.mergesort(num);
    }

}