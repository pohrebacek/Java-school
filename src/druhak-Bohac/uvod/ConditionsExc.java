package uvod;

import java.util.Scanner;

public class ConditionsExc {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Scanner sc = new Scanner(System.in);
        //Vygenerujete 3 random cisla (1 - 4)
        //A reknete jako v slot machine, 3 musi byt stejne
//        int a1 = (int)(Math.random() * 4 + 1);
//        int a2 = (int)(Math.random() * 4 + 1);
//        int a3 = (int)(Math.random() * 4 + 1);
//        System.out.println("1:" + a1 + ", 2:" + a2 + ", 3:" + a3);
//        if (a1 == a2 && a2 == a3){
//            System.out.println("Winner");
//        } else {
//            System.out.println("Exekuce");
//        }

//        //tri strany
//        //zjistite zda je trojuhelnik pravouhly
//        int a = 4;
//        int b = 5;
//        int c = 3;
//        if ( c*c == a*a + b*b || a*a == b*b + c*c || b*b == a*a + c*c){
//            System.out.println("Trojuhelnik je pravouhly");
//        } else {
//            System.out.println("Neni pravouhly");
//        }

        //DnD: mate postavu s zivoty
        //Zadate, jakou ma obranu
        //zadate, jakou dostal DMG
        //DMG do postavy = obrana - DMG
        int health = 100;
        System.out.println("Zadej armour");
        int armour = sc.nextInt();
        System.out.println("Zadej DMG");
        int damage = sc.nextInt();
        if (health + armour - damage > 0){
            System.out.println("Lived");
        } else {
            System.out.println("Died :(");
        }





    }
}
