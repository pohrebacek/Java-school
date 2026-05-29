package metody_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ex4 {

    public static void textAnalysis(String text){
        int countSlova = 0;
        int countVěty = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.'){
                countVěty += 1;
                i += 1;
            } else if (text.charAt(i) == ' ') {
                countSlova += 1;
            }

            if (i == (int)text.length()-1 && text.charAt(i) != ' '){
                countSlova += 1;
            }

        }



        System.out.println("počet slov: "+countSlova+", počet vět: "+countVěty);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Napiš větu: ");
        String text = sc.nextLine();
        textAnalysis(text);
    }
}
