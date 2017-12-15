public class Test {

    public static void main(String[] args){
        Thread t = new Thread(new Bus(10));
        t.start();
    }

}
