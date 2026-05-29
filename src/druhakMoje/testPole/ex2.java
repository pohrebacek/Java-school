package testPole;

import java.util.Arrays;

public class ex2 {
    public static void main(String[] args) {
        int[] pole = {-18,5,10,12,120,-5,-8,-99,0,7};
        for (int i = 0; i < pole.length; i++) {
            if (pole[i] >= -10 && pole[i] <= 10) {
                System.out.println(pole[i]);
            }
        }

    }
}
