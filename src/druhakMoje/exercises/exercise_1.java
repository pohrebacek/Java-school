package exercises;

import java.util.Scanner;

public class exercise_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej číslo: ");
        int num = sc.nextInt();
        int num2 = 0;   //variable na součet
        while (num != -1){
            num2 = num2 + num;
            num = sc.nextInt();
        }
        System.out.println("Součet je: "+(num2));
    }
}
