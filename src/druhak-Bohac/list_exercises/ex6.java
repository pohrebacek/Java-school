package list_exercises;

import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {
        int[][] pole = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int randr = (int) (Math.random() * 5);  //musí ject od 0 do 4 protože pole má indexy 0 - 4
        int randc = (int) (Math.random() * 5);  //to samý
        System.out.println("cheat: "+randr+" "+randc);
        pole[randr][randc] = 1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("-");
            }
            System.out.println();
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej číslo řádku: ");
        int inputR = sc.nextInt();
        System.out.println("Zadej číslo sloupce: ");
        int inputC = sc.nextInt();
        int count = 0;

        while (pole[inputR-1][inputC-1] != pole[randr][randc]){
            count += 1;
            pole[inputR-1][inputC-1] = 2;
            System.out.println("Zde poklad není");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (pole[i][j] == 2){
                        System.out.print("o");
                    } else {
                        System.out.print("-");
                    }
                }
                System.out.println();
            }
            System.out.println("Zadej číslo řádku: ");
            inputR = sc.nextInt();
            System.out.println("Zadej číslo sloupce: ");
            inputC = sc.nextInt();
        }

        count += 1;
        System.out.println("Našel si poklad!");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (pole[i][j] == 2){
                    System.out.print("o");
                } else if (pole[i][j] == 1) {
                    System.out.print("x");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }



    }
}
