package pole_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Zadej velikost pole: ");
        int size = sc.nextInt();
        int[] pole = new int[size];

        for (int i = 0; i < pole.length; i++) {
            pole[i] = (int) (Math.random() * 100 + 1);
        }
        System.out.println(Arrays.toString(pole));


    }
}
