import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest2 {

    private static AtomicInteger n2 = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                for(int i = 0; i < 1000; i++) {
                    n2.incrementAndGet();
                }
            };
        };
        Thread t2 = new Thread() {
            public void run() {
                for(int i = 0; i< 1000; i++) {
                    n2.incrementAndGet();
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println ("Конечное значение n2:" + n2.toString ());
    }
}