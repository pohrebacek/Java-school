package pole_exercises;

import java.util.Arrays;

public class ex3 {
    public static void main(String[] args) {

        //int[] pole = new int[5];
        //for (int i = 0; i < pole.length; i++) {
        //    pole[i] = (int) (Math.random() * 100 + 1);
        //}

        int[] pole = {9, 16, 25, 36, 49};
        int[] poleSqrt = new int[pole.length];

        for (int i = 0; i < poleSqrt.length; i++) {
            poleSqrt[i] = (int) (Math.sqrt(pole[i]));
        }

        System.out.println(Arrays.toString(pole));
        System.out.println(Arrays.toString(poleSqrt));
    }
}
