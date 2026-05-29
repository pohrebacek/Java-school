package testCykly;

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("zadej číslo: ");
        int num = sc.nextInt();
        for (int i = 0; i < num+1; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
