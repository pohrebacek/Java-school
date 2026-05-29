package String_exercises;

import java.util.Scanner;

public class IPcheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        boolean idk = true;
        String[] numbers = ip.split("\\.");

        if (numbers.length == 4){
            System.out.println("délka je ok");
        } else {
            System.out.println("neni IP");
            idk = false;
        }

        for (int i = 0; i < numbers.length && idk; i++) {
            if (numbers[i].isEmpty()){
                System.out.println("neni IP");
                idk = false;
                break;
            }
            for (int j = 0; j < numbers[i].length(); j++) {
                char currnet = numbers[i].charAt(j);
                if (!Character.isDigit(currnet)){
                    System.out.println("neni IP");
                    idk = false;
                    break;
                } else {
                    System.out.println("cislo na pozici "+j+1+" z části "+i+1+ " je ok");
                }
            }
        }

        for (int i = 0; i < numbers.length && idk; i++) {
            int num = Integer.parseInt(numbers[i]);
            if (num >= 0 && num <= 255){
                System.out.println("číslo z části "+i+1+" je ok");
            }
        }

    }
}
