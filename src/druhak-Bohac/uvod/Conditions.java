package uvod;


import java.util.Scanner;

public class Conditions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        boolean logical = true;
//        boolean anotherLogical = false;
//        System.out.println("Zadej cislo");
//        int number = sc.nextInt();
//        if (number % 2 == 0) {
//            System.out.println(number + " je sude");
//        } else {
//            System.out.println(number + " je liche");
//        }
//
//        System.out.println("Zadej vysledek testu z matiky");
//        int testMath = sc.nextInt();
//        System.out.println("Zadej vysledek testu z AJ");
//        int testEnglish = sc.nextInt();
//        //musi platit, ze z obojiho alespon 30 bodu
//        if (testMath >= 30 && testEnglish >= 30 && testMath+testEnglish >= 70){
//            System.out.println("Splnil");
//        } else {
//            System.out.println("Nesplnil");
//        }
//        System.out.println("Napis umisteni");
//        int umisteni = sc.nextInt();
//        System.out.println("Napis skore");
//        int skore = sc.nextInt();
//        if(skore >= 50 || umisteni <= 3){
//            System.out.println("Prošel");
//        } else{
//            System.out.println("Neprošel");
//        }
//        System.out.println("zadej cislo");
//        int input = sc.nextInt();
//        if (input > 6 || input < 1){
//            System.out.println("je v interavalu");
//        } else {
//            System.out.println("neni v interavalu");
//        }
//        System.out.println("Zadej skore");
//        int score = sc.nextInt();
//        System.out.println("Zadej prumer");
//        double average = sc.nextDouble();
//        if (score >= 1400 && average <= 3.0){
//            System.out.println("Prosel");
//        } else {
//            System.out.println("Neprosel");
//        }
    //Uzivatel zada: má kupon a cenu
        //Má kupon a koupil za alespon $50 tak má slevu 10 %
        //Má kupon a koupil za alespon $100 tak má slevu 20 %
//        System.out.println("Za kolik jsi nakoupil?");
//        int price = sc.nextInt();
//        System.out.println("Máš kupon?");
//        boolean discountTicket = sc.nextBoolean();
//        int finalPrice = 0;
//        if (discountTicket == true){
//            if (price >= 100){
//                finalPrice = (int)(price * 0.8);
//            } else if (price >= 50) {
//                finalPrice = (int)(price * 0.9);
//            } else{
//                finalPrice = price;
//            }
//            System.out.println("K zaplaceni je " + finalPrice);
//        } else {
//            System.out.println("cena je " + price);
//        }

        int year = 2000;
        if ((year % 4 == 0 && year % 4 != 100) || (year % 100 == 0 && year % 400 == 0)){
            System.out.println("Rok je prestupny");
        }

    }
}
