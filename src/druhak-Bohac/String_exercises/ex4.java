package String_exercises;

import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String věta = sc.nextLine();
        int count = 0;

        for (int i = 0; i < (int)věta.length(); i++) {
            if (věta.charAt(i) == ' ' && i == 0){   // když je první znak mezera tak ať to nepřičtě jedna

            } else {
                if (věta.charAt(i) == ' '){
                    count += 1;
                }
                if (i == (int)věta.length()-1 && věta.charAt(i) != ' '){       //aby když to dojede na poslední slovo to taky zapsalo
                    count += 1;
                }
            }

        }

        System.out.println("počet vět je "+count);
    }
}
