package tretak.files;

import fileworks.DataImport;

public class PersonReading {
    public static void main(String[] args) {
        DataImport di = new DataImport("osoba.txt");
        String line;
        String[] attributes;
        Person p;

        Person tallest = new Person("tmp", Integer.MIN_VALUE, 0, 0);
        while (di.hasNext()) {
            line = di.readLine();
            attributes = line.split(",");
            p = new Person(
                    attributes[0],
                    Integer.parseInt(attributes[1]),
                    Integer.parseInt(attributes[2]),
                    Integer.parseInt(attributes[3])
            );
            if (p.height > tallest.height){
              tallest = p;
            };
        };
        System.out.println("tallest: " + tallest);
        di.finishImport();
    }
}

class Person {
    String fullname;

    int height, weight, age;

    public Person(String fullname, int height, int weight, int age) {
        this.fullname = fullname;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    @Override
    public String toString() {
        return fullname +
                ", height=" + height +
                ", weight=" + weight +
                ", age=" + age;
    }
}
