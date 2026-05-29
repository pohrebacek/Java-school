package pole_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] pole = new int[10];
        System.out.println("Zadej číslo: ");
        int num = sc.nextInt();
        int count = 0;
        int[] indexy = new int[pole.length];

        for (int i = 0; i < pole.length; i++) {
            pole[i] = (int) (Math.random() * 10 + 1);
            if (pole[i] == num) {
                count += 1;
                indexy[i] = i;
                //indexy[count-1] = i;
            }
        }
        System.out.println(Arrays.toString(pole));
        System.out.println("počet: "+count);
        System.out.print("indexy: ");
        for (int i = 0; i < indexy.length; i++) {
            if (indexy[i] != 0) {
                System.out.print(i+"; ");
            }
        }

        //System.out.println(iLength);
        //System.out.println(indexy.length);
        //System.out.println("indexy: "+Arrays.toString(indexy));
    }
}
