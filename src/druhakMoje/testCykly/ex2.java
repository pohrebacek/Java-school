package testCykly;

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Prosím zadejte pin v rozmezí 1000 - 9999: ");
        int pin = sc.nextInt();
        while (pin < 1000 || pin > 9999) {
            System.out.println("Prosím zadejte pin v rozmezí 1000 - 9999: ");
            pin = sc.nextInt();
        }
        System.out.println("pin je ok");
    }
}
