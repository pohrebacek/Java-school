package String_exercises;

import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        String number2 = "";

        for (int i = 0; i < (int)number.length(); i++) {
            number2 = number.charAt(i) + number2;
        }
        System.out.println(number2);
    }
}
