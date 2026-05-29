package ctvrtak.threads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Basics {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("neco se stane za 3 vteriny");
        Thread.sleep(3000);
        System.out.println("Neco");
        System.out.println(Thread.activeCount());
        System.out.println(Thread.currentThread());

        //pořadí v jakym se threads projedou a dokončí nelze garantovat, pokud běží paralelně
        FirstThread thread = new FirstThread();
        thread.setName("Prvni");
        thread.start();
        System.out.println(Thread.activeCount());
        FirstThread another = new FirstThread();
        another.setName("dalsi");
        another.start();

        IThread th = new IThread();
        Thread implemented = new Thread(th);
        implemented.start();
        System.out.println("Doneeee");  //vypíše se před operacema v ostatních vláknech, prptože main na ně nemusí čekat
    }
}
class FirstThread extends Thread {
    @Override
    public void run() {
        System.out.println("getName: "+getName());
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(getName()+".txt")));
            for (int i = 0; i < 10; i++) {
                pw.println(getName() + ": " + 1);
            }
            pw.close();
        } catch (IOException e) {
            System.out.println(":(");
        }
        System.out.println(getName() + " Finished");
    }
}
class IThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try{
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(Thread.currentThread().getName()+".txt")));
            for (int i = 1; i <= 100000; i++) {
                pw.println(Thread.currentThread().getName() + ": " + i);
            }
            pw.close();
        } catch (IOException e){
            System.out.println(":(");
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}