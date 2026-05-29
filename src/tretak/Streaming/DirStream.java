package tretak.Streaming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirStream {
    public static void main(String[] args) {
        //známý způsob
        //File[] tretak.files = new File("cesta").listFiles();

        Path start = Paths.get("inputs\\testData2");

        try (Stream<Path> fileStream = Files.walk(start)) { //proč to tu je takhle?, vysvětlení try with resources
            //Files.walk(start)   //vrací stream
            fileStream
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
