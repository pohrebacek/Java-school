package testPole;

import java.util.Arrays;

public class ex1 {
    public static void main(String[] args) {
        int[] pole = new int[20];
        int soucet = 0;

        for (int i = 0; i < pole.length; i++) {
            pole[i] = (int) (Math.random() * 201 -100);
            soucet += pole[i];
        }

        System.out.println(Arrays.toString(pole));
        if (soucet >= 0) {
            System.err.println(soucet);
        } else {
            System.out.println(soucet);
        }
    }
}
