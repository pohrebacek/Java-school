package cvika;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
//        for (int i = 0; i <= 1000; i++) {
//            if (i % 5 == 0) {
//                System.out.println(i);
//            }
//        }
//        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();
//        for (int i = 0; i < number* number; i++) {
//            System.out.println(i+1);
//        }
        int randomNum = 0;
        for (int i = 0; i < 500; i++) {
            randomNum = (int)(Math.random()*100+1);
            System.out.println(randomNum);
        }

    }
}
