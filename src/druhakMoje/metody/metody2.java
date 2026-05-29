package metody;

import java.util.ArrayList;
import java.util.Arrays;

public class metody2 {
    public static void greetings(String name){
        System.out.println("Hello "+name);
    }

    public static int rectangleArea(int width, int height){
        return width*height;
    }

    public static int randomNumbers(int min, int max){
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static int[] randomArray(int length, int min, int max){
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = randomNumbers(min, max);
        }
        return array;
    }

    public static String minuteConvert (int seconds){
        int hours = seconds / 3600;
        int remainingSecs = seconds - hours * 3600;
        int min = remainingSecs / 60;
        int sec = remainingSecs % 60;
        return hours+":"+min+":"+sec;
    }


    //static void diceRollse (int diceAmount, int value){
    //    int sum = 0;
    //    for (int i = 0; i < diceAmount; i++) {
    //        sum += (int) (Math.random() * value + 1);
    //    }
    //    return sum;
    //}

    public static void main(String[] args) {
        greetings("karel");
        greetings("idk");
        System.out.println(rectangleArea(2, 5));
        System.out.println(randomNumbers(10, 20));
        System.out.println(Arrays.toString(randomArray(10, 50, 100)));
    }
}
