package String_exercises;

import java.util.Scanner;

public class morseovka {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] letters = {"A .-", "B -...", "C -.-.", "D -..", "E .",
                "F ..-.", "G --.", "H ....", "I ..", "J .---",
                "K -.-", "L .-..", "M --", "N -.", "O ---",
                "P .--.", "Q --.-", "R .-.", "S ...", "T -",
                "U ..-", "V ...-", "W .--", "X -..-", "Y -.--",
                "Z --.."};
        String input = sc.nextLine();
        input = input.toUpperCase();
        String finalWord = "";

        for (int i = 0; i < (int)input.length(); i++) {
            if (input.charAt(i) == ' '){
                finalWord = finalWord + " ";
            }
            for (int k = 0; k < letters.length; k++) {  //tenhle projíždí tu morzeovku to pole

                if (input.charAt(i) == letters[k].charAt(0)){   //jestli písmeno na indexu se rovná písmenu v poli
                    for (int j = 2; j < letters[k].length(); j++) {   //zapisuje znaky, 2 protože to má přeskočit písmeno a mezeru
                        finalWord = finalWord + letters[k].charAt(j);
                    }
                    finalWord = finalWord + " ";
                }
            }

        }

        System.out.println(finalWord);
    }
}
