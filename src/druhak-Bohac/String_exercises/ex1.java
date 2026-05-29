package String_exercises;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] users = {"kok", "kok1", "kok2", "kok3"};
        String username = sc.nextLine();

        for (int i = 0; i < users.length; i++) {
            if (username.equals(users[i])){
                System.out.println(username+" se v poli nachází");
                break;
            } else if (i == users.length-1 && !username.equals(users[i])) {
                System.out.println(username+" se v poli nenachází");
            }
        }
    }
}
