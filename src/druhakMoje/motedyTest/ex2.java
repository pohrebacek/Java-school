package motedyTest;

import java.util.Scanner;

public class ex2 {

    public static void newerDate(String date, String otherDate){


        int date11 = 0;
        int date12 = 0;
        int date21 = 0;
        int date22 = 0;

        for (int i = 0; i < date.length(); i++) {
            if (date.charAt(i) == '.'){
                date11 = Integer.parseInt(date.substring(0, i));
                date12 = Integer.parseInt(date.substring(i, date.length()-1));

            }

        }

        for (int i = 0; i < otherDate.length(); i++) {
            if (date.charAt(i) == '.'){
                date21 = Integer.parseInt(otherDate.substring(0, i));
                date22 = Integer.parseInt(otherDate.substring(i, otherDate.length()-1));

            }

        }

        if (date21 > date22){
            System.out.println(date+" je novější");
        } else if (date22 > date21) {
            System.out.println(otherDate+" je novější");
        } else {
            if (date11 > date12){
                System.out.println(date+" je novější");
            } else {
                System.out.println(otherDate+" je novější");
            }
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("datum 1: ");
        String date1 = sc.nextLine();
        System.out.println("datum 2: ");
        String date2 = sc.nextLine();
        newerDate(date1, date2);
    }
}
