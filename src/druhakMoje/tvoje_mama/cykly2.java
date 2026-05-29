package tvoje_mama;

import java.util.Scanner;

public class cykly2 {
    public static void main(String[] args) {
       // System.out.println("Zadej čísla, zdaej -1 pro konec");
       Scanner sc = new Scanner(System.in);
       // int input = sc.nextInt();
       // while (input != -1){
       //     if (input % 2 ==0){
       //         System.err.println(input);
       //     }
       //     input = sc.nextInt();
       // }
//
       // System.out.println("zadej max číslo");
       // input = sc.nextInt();
       // for (int i = 0; i < input; i++) {
       //     if (input % 2 == 0){
       //         System.out.println(i);
       //     }
       // }


        System.out.println("zadej číslo");
        int input = sc.nextInt();
        boolean prime = true;
        for (int i = 2; i < input; i++) {
            if (input % i == 0){
                prime = false;
                break; //to vyskočí z toho cyklu, protože pokud už padne false, tak je víme že to neni prvočíslo a neni potřeba
                // to dál kontrolovat
            }
        }
        System.out.println(prime);
//
    }
}
