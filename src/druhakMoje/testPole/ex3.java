package testPole;

import java.util.Arrays;

public class ex3 {
    public static void main(String[] args) {
        int[] score = new int[8];
        int prumer = 0;
        boolean prošel = true;

        for (int i = 0; i < score.length; i++) {
            score[i] = (int) (Math.random() * 101);
            prumer += score[i];
            if (score[i] < 60){
                prošel = false;
            }
        }
        System.out.println(Arrays.toString(score));

        prumer = prumer / 8;
        System.out.println(prumer);
        if (prošel && prumer >= 70){
            System.out.println("Student uspěl se skorem "+prumer*8);
        } else {
            System.out.println("Student nepuspěl se skorem "+prumer*8);
        }
    }
}
