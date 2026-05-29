package tvoje_mama;

import java.lang.reflect.Array;
import java.util.Arrays;

public class stringy {
    public static void main(String[] args) {
        //idk.charAt(index)
        //idk.equals()
        //input je sc.nextLine()
        //indexOf

        String song = "Dream on;Aerosmith;(1973)";
        String [] texts = {"first", "second", "another"};
        System.out.println(texts[1]);

        String[] splits = song.split(";");
        System.out.println(Arrays.toString(splits));
        String songname = splits[0];
        String composer = splits[1];
        String yearOfRelease = splits[2];




        String hello = "hello";
        String something = hello.substring(0,4);
        System.out.println(something);

        String spanishSuffix = hello.substring(1,3);
        System.out.println(spanishSuffix);

        String number = "42";
        System.out.println(number + 42);
        int parsing = Integer.parseInt(number);
        System.out.println(parsing + 42);
        int text = 12345;
        String acutalText = String.valueOf(text);

        acutalText.isBlank(); // mezery
        acutalText.isEmpty();//jestli délka je nula
        //acutalText.lastIndexOf();

    }
}
