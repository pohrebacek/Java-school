package motedyTest;

import java.util.Scanner;

public class ex3 {

    public static double idk(int metry, boolean lakovat){
        double planky = metry * 99;
        if (lakovat){
            planky += planky * 0.23;
            return planky;
        } else {
            return planky;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("zadej metry: ");
        int metry = sc.nextInt();
        System.out.println("lakovat? ano/ne: ");
        boolean lakovat = sc.nextBoolean();
    }

}
