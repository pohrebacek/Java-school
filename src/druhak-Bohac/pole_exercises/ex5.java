package pole_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] pole = new int[10];
        int num;
        for (int i = 0; i < pole.length; i++) {
            System.out.println("Zadej číslo od 10 do 100: ");
            num = sc.nextInt();
            while (num < 10 || num > 100) {
                System.out.println("Číslo neakceptováno. Zadej číslo od 10 do 100: ");
                num = sc.nextInt();
            }
            pole[i] = num;
        }
        System.out.println(Arrays.toString(pole));
    }
}
