public class AtomicIntegerTest {

    private static int n = 0;

    public static void main(String[] args) throws InterruptedException {
        // Проблема с потоком, вызванная i ++
        Thread t1 = new Thread() {
            public void run() {
                for(int i = 0; i < 1000; i++) {
                    n++;
                }
            };
        };
        Thread t2 = new Thread() {
            public void run() {
                for(int i = 0; i < 1000; i++) {
                    n++;
                }
            };
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println ("Конечное значение n:" + n);
    }
}