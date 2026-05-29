package uvod;

import java.util.Scanner;

public class Variables {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello world!");
        int num = 5;
        long bigNumber = 123456789;
        double decimal = 4.3;
        float otherDecimal = 4.2f;
        System.out.println("Number: " +otherDecimal);
        int result = 9/10;
        int randomNumber = (int) (Math.random() * 5 + 1);
        System.out.println(randomNumber);

        System.out.println("Zadej cislo:");
        int readNumber = sc.nextInt();
        System.out.println("Zadal jsi: " + readNumber);
    }
}
