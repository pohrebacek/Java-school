package tretak.Streaming;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Basics {   //vezmeš data z kolecke (nebo jiná struktura bruh idk) a pak je to zpracuje
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add((int) (Math.random() * 100));
        }
        System.out.println(numbers);

        System.out.println("Size: "+numbers.size());
        int size = (int) numbers.stream()
                .count();

        int uniques = (int) numbers.stream()
                .distinct()
                .count();

        int uniquesUpper = (int) numbers.stream()
                .distinct()
                .filter(num -> num > 50)
                .count();

        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);   //System.out::println - pro každej int co přijde zavolej tuhle metodu

        numbers.stream()
                .sorted((n1, n2) -> n1 - n2)
                .forEach(System.out::println);

        String[] names = {"pico1", "picoo2", "picoooooo3", "picoooo4", "picoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo5"};
        Stream.of(names)
                .sorted((name1, name2) -> name1.length() - name2.length())
                .forEach(System.out::println);

        double average = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0);
    }
}
