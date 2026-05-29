package tretak.exceptionsBruh;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Showcase {
    static void createAndPrint(String file) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write("test");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        printFile(file);
    }

    static void printFile(String file) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        createAndPrint("negr");
    }
}
