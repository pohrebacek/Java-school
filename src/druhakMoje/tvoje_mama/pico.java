package tvoje_mama;

import java.util.ArrayList;
public class pico {
    public static void main(String[] args) {
        ArrayList<Integer> expansiveArray = new ArrayList<>();

        //pridavani
        expansiveArray.add(56); //prostě more to dá to číslo na první volnej index ig
        expansiveArray.add(1, 3);

        //vypsání, read-only
        System.out.println(expansiveArray);

        for (int i = 0; i < expansiveArray.size(); i++) {
            System.out.println(expansiveArray.get(i));
        }


        for (int i = 0; i < 20; i++) {
            expansiveArray.add(i*5);
        }
        System.out.println(expansiveArray);



        expansiveArray.isEmpty(); //=== expansiveArray.size() > 0
        expansiveArray.remove(1);
        System.out.println(expansiveArray);

        //expansiveArray.removeAll()
        System.out.println(expansiveArray.indexOf(5));

    }
}
