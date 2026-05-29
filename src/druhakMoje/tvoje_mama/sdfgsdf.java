package tvoje_mama;

import java.util.ArrayList;
import java.util.Scanner;

public class sdfgsdf {
    public static void main(String[] args) {
        //uzivatel zadává tel číslo, zadání ukončí zadáním konec, na konci vypise pouze cz cisla

        Scanner sc = new Scanner(System.in);
        ArrayList<String> phoneList = new ArrayList<>();
        System.out.println("zadávej tel. čísla, zadávání ukončí zadáním konec: ");
        String input = sc.nextLine();

        //tel. číslo má předvolbu (+ nebo cislo), obsahuje pouze čísla
        boolean notADigit = false;
        while (!input.equals("konec")){
            if (input.charAt(0) == '+' || Character.isDigit(input.charAt(0))){
                notADigit = false;
                for (int i = 1; i < input.length(); i++) {
                    if (!Character.isDigit(input.charAt(i))){
                        notADigit = true;
                        break;
                    }
                }
                if (!notADigit){
                    System.out.println("Added: "+input);
                    phoneList.add(input);
                }

            }
            input = sc.nextLine();

        }
        System.out.println(phoneList);

        //vypis pouze cesky
        //zacinaji na +420
        //maj delku 14

        for (int i = 0; i < phoneList.size(); i++) {
            if (phoneList.get(i).length() == 14){
                if (phoneList.get(i).startsWith("+420")){
                    System.out.println(phoneList.get(i));
                }
            }
        }
    }
}
