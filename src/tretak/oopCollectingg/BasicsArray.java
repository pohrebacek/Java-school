package tretak.oopCollectingg;

import java.util.Arrays;

public class BasicsArray {
    public static void main(String[] args) {
        //static array
        int[] numbers = {1, 2, 3, 4};

        //pouze deklarace;
        int[] nums2 = new int[10];

        //iterace
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = (int)(Math.random() * 100);
        }

        numbers = nums2;
        //původní numbers sežere garbage collector


        //kopie pole
        int[] nums3 = Arrays.copyOf(nums2, 15);


        //co je v každym poli na indexu 5
        nums3[3] = 20;
        numbers[5] = 30;
        nums2[5] = 40;

        //int[] je primitivní, nemá žádné metody, musim zavolat knihovnu

        //jednoduchá ukázka řazení
        Arrays.sort(nums3); //použije quicksort
        System.out.println(Arrays.toString(nums3));
    }
}
