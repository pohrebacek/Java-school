package ctvrtak.threads.testypico;

import javax.swing.*;

public class test1 {
    public static void main(String[] args) throws InterruptedException {
        String pass = "kokot";



        Thread login = new Thread(() -> {
            String input = JOptionPane.showInputDialog("Zadej heslo:");

            if (input != null && input.equals(pass) ) {
                System.out.println("Heslo je good");
            } else {
                System.out.println(":(");
            }
        });

        Thread timer = new Thread(() -> {
            for (int i = 10; i > 0; i--) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("time out");
            login.interrupt();

        });

        timer.setDaemon(true);
        timer.start();

        //login.setDaemon(true);
        login.start();

    }
}
