package pole_exercises;

import java.util.Arrays;

public class ex2 {
    public static void main(String[] args) {
        int[] pole = new int[5];
        int sudý = 0;
        int lichý = 0;

        for (int i = 0; i < pole.length; i++) {
            pole[i] = (int) (Math.random() * 100 + 1);
            if (pole[i] % 2 == 0) {
                sudý += pole[i];
            } else {
                lichý += pole[i];
            }
        }

        System.out.println(Arrays.toString(pole));
        System.out.println("sudý: "+sudý);
        System.out.println("lichý: "+lichý);


    }
}
