package tvoje_mama;

import java.util.Arrays;

public class pole_mole {
    public static void main(String[] args) {
        int[] pole = {5, 32, 45, 99, 6};
        int[] poleZwei = new int[10]; // udělá pole o daný velikosti
        System.out.println(pole[3]);
        for (int i = 0; i < pole.length; i++) {
            System.out.println(pole[i]);
        }

        pole[2] = 10;
        for (int i = 0; i < poleZwei.length; i++) {
            poleZwei[i] = (int) (Math.random()*101); //0 až 100
        }

        System.out.println("-------");
        for (int i = 0; i < poleZwei.length; i++) {
            System.out.println(poleZwei[i]);
        }

        int[] kokArray = new int[15];
        for (int i = 0; i < kokArray.length-1; i++) {
            kokArray[i] = (i+1)*5;
        }
        System.out.println(Arrays.toString(kokArray));
    }
}
