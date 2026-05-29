package tretak.exceptionsBruh;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

public class Demo {

    static void infinity(String test){  //example erroru (stack ovefrlow)
        System.out.println(test);
        infinity(test);
    }

    static int biiigSequence(int a){    //example erroru (stack ovefrlow)
        System.out.println(a);
        if (a < Integer.MAX_VALUE - 1){
            biiigSequence(a + 1);
        }
        return a;
    }
    public static void main(String[] args) {
        try{
            //infinity("pico");
            //biiigSequence(0);
            List<String> lines = Files.readAllLines(Paths.get("nenajdes.txt"));
        } catch (StackOverflowError err){
            err.printStackTrace();
            System.out.println("Ran out of memory");
        } catch (FileNotFoundException | NoSuchFileException e){
            System.out.println("Nenasel jsem soubor");
        } catch (IOException e){
            System.out.println("Obecny problem se souborem");
        }

    }
}
