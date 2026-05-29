package list_exercises;

import java.util.Arrays;

public class ex5 {
    public static void main(String[] args) {
        int[][] reviews = new int[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                reviews[i][j] = (int) (Math.random() * 10 +1);
            }
        }

        System.out.println("Hodnocení filmů: ");
        for (int i = 0; i < reviews.length; i++) {
            System.out.println(Arrays.toString(reviews[i]));
        }
        System.out.println("-----------------------------");
        
        
        double count = 0;
        double prumer = 0;
        for (int i = 0; i < 4; i++) {   //prochází film
            for (int j = 0; j < 5; j++) {   //prochází jednotlivá hodnocení
                prumer += reviews[i][j];
                System.out.println("film "+i+", kritik "+j+", soucet hodnoceni: "+prumer);
            }
            prumer = prumer / 5;
            System.out.println("film "+i+" prumer "+prumer);
            if (prumer > 7.5){
                count += 1;
                System.out.println("count "+count);
            }
            prumer = 0;    //prumer se musí vyresetovat aby každej film měl svoje skore, jinak by se do toho pocital prumer toho predeslyho
        }

        System.out.println("Filmy s průměrnym skore více jak 7,5: "+count);

    }
}
