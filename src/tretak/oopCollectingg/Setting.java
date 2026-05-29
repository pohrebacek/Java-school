package tretak.oopCollectingg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Setting {  //nějaká množina tam je jednou nebo vůbec
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*121);
        }
        System.out.println(Arrays.toString(array));
        Set<Integer> uniqueNumbers = new HashSet<>();
        uniqueNumbers.add(5);
        uniqueNumbers.add(5);
        uniqueNumbers.add(5);
        uniqueNumbers.add(5);
        System.out.println(uniqueNumbers);

        //vygeneruj 100 random unikatnich cisel
        while (uniqueNumbers.size() < 100){
            uniqueNumbers.add((int)(Math.random()*121));
        }
        System.out.println(uniqueNumbers);

        //je neco v mnozine (setu)? a)
        System.out.println(uniqueNumbers.contains(6));
        //zkus pridat, nevyjde=už to tam je
        System.out.println(uniqueNumbers.add(6));

        ArrayList<Integer> trulyUniqueNumbers = new ArrayList<>(uniqueNumbers);
        System.out.println(trulyUniqueNumbers);



        //task
        //1) vytvoř arraylist, random čísla (0-199)
        //2) zjisti kolik jich bylo unique

        ArrayList<Integer> subSetNumbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            subSetNumbers.add((int)(Math.random()*200));
        }
        System.out.println(subSetNumbers);


        HashSet<Integer> subSet = new HashSet<>(subSetNumbers);
        System.out.println(subSet);
        //kolik čísel je unique
        System.out.println(subSet.size());

        //kolik je tam non-unique čísel
        System.out.println(subSetNumbers.size()-subSet.size());
    }
}
