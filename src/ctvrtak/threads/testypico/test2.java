package ctvrtak.threads.testypico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class test2 {
    public static List<Integer> beats = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        Thread gen = new Thread(() -> {
            try {
                for (int i = 0; i < 40; i++) {
                    Thread.sleep(250);
                    Random r = new Random();
                    beats.add(r.nextInt(40, 81));
                    System.out.println("added");
                }


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread print = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1000);
                    System.out.println("max: "+ Collections.max(beats));
                    System.out.println("min: "+ Collections.min(beats));
                    System.out.println("avg: "+ beats.stream().mapToInt(Integer::intValue).average());
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        print.setDaemon(true);
        print.start();


        gen.start();
        gen.join();

        System.out.println("done");
    }
}
