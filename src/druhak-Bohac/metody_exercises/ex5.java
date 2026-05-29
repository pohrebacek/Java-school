package metody_exercises;

import java.util.Scanner;

public class ex5 {

    public static boolean isTriangle(int a, int b, int c){
        int min = 0;
        int min2 = 0;
        int idk;

        if (c >= a && c >= b){
            idk = c;
            min = a;
            min2 = b;
        } else if (b >= a && b >= c) {
            idk = b;
            min = c;
            min2 = a;
        } else {
            idk = a;
            min = c;
            min2 = b;
        }

        if (min + min2 > idk){
            return true;
        } else {
            return false;
        }

    }



    public static double triangleArea(int a, int b, int c){
        if (!isTriangle(a, b, c)){
            return -1;
        } else {
            int s = (a + b + c) / 2;
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            return area;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zadej stranu 'a': ");
        int a = sc.nextInt();
        System.out.print("Zadej stranu 'b': ");
        int b = sc.nextInt();
        System.out.print("Zadej stranu 'c': ");
        int c = sc.nextInt();

        System.out.println(triangleArea(a, b, c));

    }
}
