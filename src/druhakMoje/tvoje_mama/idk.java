package tvoje_mama;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class idk {
    public static void main(String[] args) {
        //vytvořit pole o velkosti 6
        //naplnit random čísly 1 - 15
        //uzivatele se 7x zeptáte, aby uhodl číslo v poli
        //u uživatele se sleduje skore
        //pri spravnem tipu se přičte skore 100

        int[] guessArray = new int [6];
        Scanner sc = new Scanner((System.in));
        int score = 0;
        int guess;

        for (int i = 0; i < guessArray.length; i++) {
            guessArray[i] = (int) (Math.random() * 15 + 1);
        }
        System.out.println(Arrays.toString(guessArray));

        for (int i = 0; i < 7; i++) {
            System.out.println("Tipni číslo: ");
            guess = sc.nextInt();

            if (guess < 0 || guess > 15) {
                continue;
            }

            for (int j = 0; j < guessArray.length; j++) {
                if (guess == guessArray[j]) {
                    score += 100;
                    System.out.println("Uhádl jsi");
                    guessArray[j] = -1; //když uhádnu číslo, tak abych nemoh napsat to samý
                    System.out.println(Arrays.toString(guessArray));
                }
            }
            //uz uhodl vse
            if (score >= guessArray.length * 100) {
                break;
            }
        }
        System.out.println("game over, score: "+score);
    }
}
