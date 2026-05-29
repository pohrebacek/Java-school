package metody_exercises;


import java.util.Arrays;

public class ex1 {
    public static int[] getMax(int[] array){
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
            }
        }
        return new int[]{max};
    }
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 18, 15, 2};
        System.out.println(Arrays.toString(getMax(array)));
    }
}
