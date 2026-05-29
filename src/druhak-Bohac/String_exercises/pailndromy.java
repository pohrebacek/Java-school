package String_exercises;

import java.util.Scanner;

public class pailndromy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        boolean idk = true;

        for (int i = 0; i < (int)word.length()/2; i++) {
            if (word.charAt(i) == word.charAt(word.length()-1-i)){

            } else {
                idk = false;
                break;
            }
        }

        if (idk){
            System.out.println("je to pailndrom");
        } else {
            System.out.println("neni to pailndrom");
        }
    }
}
