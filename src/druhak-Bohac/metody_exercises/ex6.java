package metody_exercises;

import java.util.Scanner;

public class ex6 {

    public static int digitSum(String input){
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum += Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("zdaej číslo: ");
        String input = sc.nextLine();
        System.out.println(digitSum(input));
    }
}
