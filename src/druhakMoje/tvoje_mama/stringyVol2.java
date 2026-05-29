package tvoje_mama;

import java.util.Scanner;

public class stringyVol2 {
    public static void main(String[] args) {
        //porovnání a načtení:
        //uživatel zadá input, ověřte zda je roven heslu
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej heslo: ");
        String input = sc.nextLine();
        String pass = "secret";

        if (input.equals(pass)) {
            System.out.println("Heslo je OK");
        } else {
            System.out.println("Heslo nesedí");
        }


        //validace rodnýho čísla
        // zkontroluje jestli je ok
        //zda je to žena nebo muž
        String rc = "000209/2121";
        if (rc.length() == 11) {
            System.out.println("delka je ok");
            if (rc.charAt(6) == '/'){
                System.out.println("lomitko je ok");
                if (rc.charAt(2) == '5' || rc.charAt(2) == '6'){
                    System.out.println("zena");
                } else {
                    System.out.println("muz");
                }
            }
        }

        //uzivatel zada input (neco), vypis jestli se trefil:
        //a) presne
        //b) bez malych/velkych pismen
        String neco = sc.nextLine();
        String[] passwords = {"automat", "kobliHa", "0132546", "liverp00l"};
        for (int i = 0; i < passwords.length; i++) {
            //var a
            if (neco.equals(passwords[i])){
                System.out.println("correct");
                break;
            }
            //var b, dá se použít i equalsIgnoreCase
            if (passwords[i].toLowerCase().equals(neco.toLowerCase())){
                System.out.println("correct (case ignored)");
            }
        }

        //pole jmen - vypište pouze Honzy
        String[] names = {"Jan Karel", "Karel Jan", "Frant Omáčka", "Franta Vomáčka", "Jan Novák", "Jana Stará", "Franz Ferdinand"};
        for (int i = 0; i < names.length; i++) {
            if (names[i].startsWith("Jan ")){
                System.out.println(names[i]);
            }
        }

        //Ze stringu mixed vypis pouze čísla
        String mixed = "12he54he213";
        System.out.println("Values: ");
        for (int i = 0; i < mixed.length(); i++) {
            if (Character.isDigit(mixed.charAt(i))){
                System.out.println(mixed.charAt(i));
            }
        }

        //ukazka replace
        String greeting = "Hello World";
        String replaced = greeting.replace(" ", "|"); //co čim
        System.out.println(replaced);

    }
}
