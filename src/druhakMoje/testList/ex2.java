package testList;

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        int[][] pole = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("zadej číslo sloupce");
        int input = sc.nextInt();
        int min = pole[0][input];


        for (int i = 1; i < pole.length; i++) {
            if (pole[i][input] < min){
                min = pole[i][input];
            }
        }

        System.out.println(min);
    }
}
