package exercises;

import java.util.Scanner;

public class exercise_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej číslo: ");
        //int num = sc.nextInt();
        //int num2 = num;   //variable na faktoriál
        //for (int i = 1; i < num; i++) {   //i je číslo který snižuje svou hodnotou hodnotu num, tim se násobí náš budoucí faktoriál
        //    num2 = num2 * (num-i);
        //}
        //System.out.println("Faktoriál čísla "+(num)+" je "+(num2));

        //n-tá mocnina

        int num = sc.nextInt();
        int num2 = 1;   //variable na n-tou mocninu
        for (int i = 0; i < num; i++) {
            num2 = num2 * num;
        }
        System.out.println(num2);
    }
}
