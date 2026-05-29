package tvoje_mama;

import java.util.Scanner;

public class trojuhelnik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej počet pater: ");
        int levels = sc.nextInt();

        for (int i = 1; i <= levels; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
}
