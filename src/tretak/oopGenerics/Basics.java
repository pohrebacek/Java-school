package tretak.oopGenerics;

import java.util.*;

public class Basics {

    static <E> void printArray(E[] array){    //to E je že bere cokoliv za datovej typ
        System.out.println();
        for (E type : array){
            System.out.print(type + " ");
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> void sort(T[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {   //compareTo to odečte ty dvě čísla
                //if (data[j] > data[j + 1]) {
                    T temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        //built-in
        //generický prg se zaměřuje na to mezi <>
        //dávam tam objekty
        //ArrayList<String> strings;
        //ArrayList<Integer> numbers;

        Integer[] numbers = {15, 27, 64, 42, 5, 8};
        String[] words = {"delta", "alpha", "beta", "gamma"};
        Double[] realNumbers = {Math.PI, -Math.sqrt(17),.5, 4.0};

        printArray(numbers);
        printArray(words);
        printArray(realNumbers);


        sort(numbers);
        sort(words);
        sort(realNumbers);


        printArray(numbers);
        printArray(words);
        printArray(realNumbers);

    }
}
