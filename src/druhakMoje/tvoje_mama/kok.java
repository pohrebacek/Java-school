package tvoje_mama;

import java.util.Scanner;
public class kok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int random = (int)(Math.random() * 100 + 1);
        System.out.println("Napiš tip: ");
        int tip = sc.nextInt();
        while (tip != random){
            if (tip > random) {
                System.out.println("Číslo je moc velké.");
                tip = sc.nextInt();
            }
            else {
                System.out.println("Číslo je moc malé.");
                tip = sc.nextInt();
            }
        }
        System.out.println("Uhodl jsi číslíčko.");
    }
}

