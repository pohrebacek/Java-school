package tretak.Lambda;


import java.io.File;
import java.util.Comparator;

public class Basics {
    public static void main(String[] args) {
        Functions f = new Functions() {
            @Override
            public double quadratic(double a) {
                return a*a;
            }
        };

        //prijme a, vrati a*a
        Functions quadratic = a -> a*a;
        System.out.println(quadratic.quadratic(5));

        Operations addition = (a, b) -> a+b;
        Operations multiplication = (a, b) -> a*b;

        System.out.println("addition");
        System.out.println(addition.operation(5, 2));

        Texting world = whom -> System.out.println("Hello "+ whom);
        world.hello("World");

        Zero z = () -> System.out.println("Tohle nic nedela...");
        z.print();

        //lambda
        Comparator<File> fileSize = (o1, o2) -> (int)(o1.length() - o2.length());

        //agregace: silne, ale potreba znat predem
        Comparator<File> fileSize2 = Comparator.comparing(File::length);
    }
}

interface Functions {
    double quadratic(double a);
}
interface Operations {
    double operation(double a, double b);
}
interface Texting {
    void hello(String whom);
}
interface Zero {
    void print();
}