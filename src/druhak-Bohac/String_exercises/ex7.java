package String_exercises;

import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = "nečum";
        String fileName = sc.nextLine();
        String fullName = name+"."+fileName;

        System.out.println(fullName);

    }
}
