package cvika;

import java.util.Scanner;

public class TestRecap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej pocet lahvi:");
        int count = sc.nextInt();
        int pricePerBottle = 540;
        int finalPrice = 0;
        if (count < 5){
            finalPrice = count * pricePerBottle;
        } else if(count < 10){
            finalPrice = (int)(count * pricePerBottle * 0.9);
        } else if (count < 50) {
            finalPrice = (int)(count * pricePerBottle * 0.8);
        } else {
            System.out.println("Takove mnozsvi koupit nemuzes");
        }
        System.out.println("Celkova cena je " + finalPrice);
    }
}
