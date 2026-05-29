package testStringy;

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cislo = sc.nextLine();

        if (cislo.startsWith("+420") && cislo.length() == 13){
            System.out.println("ok");
        } else {
            System.out.println("nah");
        }
    }
}
