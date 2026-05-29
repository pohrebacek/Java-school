package exercises;

import java.util.Scanner;

public class exercise_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int randInt = (int) (Math.random() * 100 + 1); //čísla od 1 do 100
        int tip = sc.nextInt();
        if (tip < randInt){
            System.out.println("Číslo je moc malé");
        } else if (tip > randInt) {
            System.out.println("Číslo je moc velké");
        } else {
            System.out.println("Zadal jsi stejné číslo");
        }
    }
}
