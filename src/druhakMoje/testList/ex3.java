package testList;

import java.util.ArrayList;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        ArrayList<String> passwords = new ArrayList<>();
        ArrayList<String> passwords2 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Zadávej hesla, zadáváaní ukončí napsáním 'konec': ");
        String pass = sc.nextLine();

        while (!pass.equals("konec")){
            passwords.add(pass);
            if (pass.length() >= 8 && pass.contains("*")){
                passwords2.add(pass);
            }
            pass = sc.nextLine();
        }

        System.out.println(passwords2);
    }
}
