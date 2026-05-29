package cvika;

import java.util.Scanner;

public class AdvancedLoops {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Zadej cislo < 10");
//        int input = sc.nextInt();
//        while(input < 10){
//            System.out.println("Zadej cislo < 10!");
//            input = sc.nextInt();
//        }
//        System.out.println("Happy ending");

        int dice1 = (int)(Math.random()*6+1);
        int dice2 = (int)(Math.random()*6+1);
        int counter = 1;
        System.out.println("K1 = " + dice1 + "K2 = " + dice2);
        while (dice1 + dice2 < 12){
            dice1 = (int)(Math.random()*6+1);
            dice2 = (int)(Math.random()*6+1);
            System.out.println("K1 = " + dice1 + " K2 = " + dice2);
            counter++;
        }
        System.out.println("Hazel jsi " + counter);

    }
}
