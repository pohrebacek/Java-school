package tretak.fileworkss;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CommonTasks {
    public static void main(String[] args) throws IOException {
        String filepath = "task.txt";
        //vygeneruj soubor plny random cisel
        //potřebuju path, lines (500000), (-10000;10000)
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filepath)));
        for (int i = 0; i < 500000; i++) {
            pw.println((int)(Math.random()*20001-10000));
        }
        pw.close();
        //u souboru pocitat řádky
        List<String> lines = Files.readAllLines(Paths.get(filepath));
        System.out.println(lines.size());

        //jake řádky maj kladná čísla
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (Integer.parseInt(line) > 0){
                System.out.println("Line: "+i+", Value: "+line);
            }
        }
    }
}
