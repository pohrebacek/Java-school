package exercises;

import java.util.Scanner;

public class exercise_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("zadej číslo: ");
        int num = sc.nextInt();     //počet řádků
        int num2 = 1;   //variable na vypisující se čísla
        for (int i = 0; i < num; i++) { //řádek
            for (int j = num2; j < num+num2; j++) {  //číslo, num+num2 je číslo na dalšim řádku
                System.out.print(j+"\t");
            }
            System.out.println();
            num2 = num2 + num;  //num+num2 je číslo na dalšim řádku
        }
    }
}
