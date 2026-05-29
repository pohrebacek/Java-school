package metody_exercises;

import java.util.Scanner;

public class ex3 {
    public static boolean isLeapYear(int year){
        boolean idk = false;
        if (year % 4 == 0 || year % 100 == 0 && year % 400 == 0){
            idk = true;
        }

        return idk;
    }

    public static int dayCount(int day, int month, int year){
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (!isLeapYear(year)){
            months[1] = 28;
        }

        int year2 = 0;

        for (int i = 0; i < months.length; i++) {
            year2 += months[i];
        }

        int month2 = 0;
        for (int i = 0; i < month-1; i++) {     //-1 bcs to počítá od 0
            month2 += months[i];
        }
        return month2 + day + year2*(year-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("zadej den: ");
        int day = sc.nextInt();
        System.out.print("Zadej měsíc: ");
        int month = sc.nextInt();
        System.out.print("Zadej rok: ");
        int year = sc.nextInt();

        System.out.println("Uběhlo "+dayCount(day, month, year)+" dní");
    }
}
