package ctvrtak.threads;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Childern {
    public static void main(String[] args) {
        Thread timer = new Thread(() -> {
            while (true) {
                System.out.println(LocalDateTime.now());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        System.out.println("Je to daemon?" + timer.isDaemon());
        timer.setDaemon(true);  //daemon je vlákno, na kterém neni program závislý. To znamená, že když se všechny ostatní non-daemon vlákna dokončí dřív než daemon vlákno, tak se program ukončí i když daemon vlákno ještě nemuselo doběhnout
        System.out.println("Je to daemon?" + timer.isDaemon());
        timer.start();
        String input = JOptionPane.showInputDialog("Neco zadej...");
        System.out.println("Zadal jsi " + input);   //jelikož je timer nastavem na daemon, tak toto vlastně program ukončí spolu s timerem
    }
}
