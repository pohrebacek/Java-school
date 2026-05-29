package metody_exercises;

import java.util.Scanner;

public class ex2 {

    public static int dayCount(int day, int month){
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month2 = 0;
        for (int i = 0; i < month-1; i++) {     //-1 bcs to počítá od 0
            month2 += months[i];
        }
        return month2 + day;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("zadej den: ");
        int day = sc.nextInt();
        System.out.println("Zadej měsíc: ");
        int month = sc.nextInt();

        System.out.println("Uběhlo "+dayCount(day, month)+" dní");
    }
}
