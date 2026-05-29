package list_exercises;

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        int[][] list = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("zadej číslo sloupce: ");
        int input = sc.nextInt();
        int count = 0;

        for (int i = 0; i < list.length; i++) {
            count += list[i][input-1];
        }

        System.out.println(count);
    }
}
