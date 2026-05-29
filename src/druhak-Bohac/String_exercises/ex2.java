package String_exercises;

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        //idk.charAt(index)
        Scanner sc = new Scanner(System.in);
        String slovo = sc.nextLine();


        for (int i = 0; i < (int)slovo.length()-1; i++) {   //-1 bcs pak by to spadlo když by to dojelo nakonec
            if (slovo.charAt(i) == slovo.charAt(i+1)){
                System.out.println("Ano");
                break;
            } else if (i == (int)slovo.length()-2 && slovo.charAt(i) != slovo.charAt(i+1)) {    //pokud na předposlednim indexu se to nerovná tomu dalšímu tak se jebne "ne" aby to nechodilo dál a nejeblo to error, bcs kdyby tam tohle nebylo tak ten program jede dál a je error
                System.out.println("ne");
            }

        }


    }
}
