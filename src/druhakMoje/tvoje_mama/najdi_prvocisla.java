package tvoje_mama;

import java.util.Scanner;
public class najdi_prvocisla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("zadej max hranici");
        int input = sc.nextInt();
        boolean prime;
        for (int i = 2; i < input; i++) { //zvedá dělitel
            prime = true;
            for (int j = 2; j < i; j++) { //projíždí jestli je "i" prvočíslo
                if (i % j == 0){
                    prime = false;
                    break; //vyskočí jenom z tohohle druhýho cyklu
                }
            }

            if (prime){
                System.out.println(i);
            }
        }

    }
}
