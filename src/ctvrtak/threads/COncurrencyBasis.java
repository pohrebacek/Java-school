package ctvrtak.threads;

public class COncurrencyBasis {
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread aThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                a = 5;
                System.out.println("thread a: "+a);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread bThread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                b = 10;
                System.out.println("thread b: "+b);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        aThread.start();
        bThread.start();
        System.out.println(Thread.currentThread());
        System.out.println(Thread.activeCount());

        bThread.join(); //říká aby momentální vlákno čekalo na vlákno, na které se zavoallo join

        //díky join se tohle garantovaně zavolá až po přenastavení variables
        //bez toho dojede main hned do konce
        //když se ale bude na "a" čekat dýl, tak to furt bude rozbitý
        System.out.println("main a: "+a);
        System.out.println("main b: "+b);
        System.out.println("konec");
    }
}
