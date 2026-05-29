package pole_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class bonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int[] pickedNumbers = new int[10];
        //int[] guesses = new int[5];
        int[] pickedNumbers = {30, 3, 30, 1, 13, 16, 15, 13, 15, 4};
        int[] guesses = {15, 25, 13, 19, 21};

        //for (int i = 0; i < pickedNumbers.length; i++) {
        //    pickedNumbers[i] = (int) (Math.random() * 30 + 1);
        //}

        //for (int i = 0; i < guesses.length; i++) {
        //    System.out.println("Zadej tip: ");
        //    guesses[i] = sc.nextInt();
        //}


        //int idk = 0;
        System.out.print("Picked numbers:");
        System.out.println(Arrays.toString(pickedNumbers));
        System.out.println(Arrays.toString(guesses));
        System.out.println("Guesses: ");

        //for (int i = 0; i < pickedNumbers.length; i++) {
        //    if (pickedNumbers[i] == guesses[i]) {
        //        System.err.println(guesses[i]);
        //        idk += 1;
        //    } else {
        //        System.out.println(guesses[i]);
        //        idk += 1;
        //    }
        //}

        //int count = 0;
        //for (int i = 0; i < pickedNumbers.length; i++) {
        //    if (pickedNumbers[i] == guesses[i]) {
        //        System.err.println(guesses[i]);
        //    } else {
        //        System.out.println(guesses[i]);
        //    }
        //    count++;
        //    if (count == guesses.length) {
        //        break;
        //    }
        //}


        int count = 0;
        for (int i = 0; i < guesses.length; i++) {
            boolean correct = false;
            for (int j = 0; j < pickedNumbers.length; j++) {
                if (guesses[i] == pickedNumbers[j]) {
                    System.err.println(guesses[i]);
                    count += 1;
                    correct = true;
                    break;
                }
            }
            if (!correct) {
                System.out.println(guesses[i]);
            }
        }


        System.out.println("Soutěžící správně tipl čísel: "+count);


        //for (int i = 0; i < pickedNumbers.length; i++) {
        //    for (int j = 0; j < guesses.length; j++) {
        //        if (guesses[j] == pickedNumbers[i]) {
        //            System.err.println(guesses[j]);
        //        } else {
        //            System.out.println(guesses[j]);
        //        }
        //    }
        //}

    }
}
