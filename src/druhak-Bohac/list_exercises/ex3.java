package list_exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> wordList = new ArrayList<>();
        System.out.println("Piš španělská slova. Zadávání ukončíš napsáním 'fin': ");
        String input = sc.nextLine();
        while (!input.equals("fin")){
            wordList.add(input);
            input = sc.nextLine();
        }

        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).startsWith("el ") || wordList.get(i).startsWith("la ") ||wordList.get(i).startsWith("un ")){
                System.out.println(wordList.get(i));
            }
        }
    }
}
