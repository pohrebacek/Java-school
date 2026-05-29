package tretak.fileworkss;

import fileworks.DataImport;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ReadingExamples {
    public static void main(String[] args) throws IOException, ArithmeticException {
        File file = new File("inputs\\countries.txt");
        if (file.exists() && file.isFile()){
            DataImport di = new DataImport(file.getPath());
            while (di.hasNext()){
                System.out.println(di.readLine());
            }
            di.finishImport();
            System.out.println();
        }

        //Scanner sc = new Scanner("pico,nevim,kurwa");
        //sc.useDelimiter(",");
        //while (sc.hasNext()){
        //    System.out.println(sc.next());
        //}
        Scanner sc = new Scanner(file);
        sc.useDelimiter(",");
        while (sc.hasNext()){
            System.out.println(sc.next());
        }
        sc.close();


        FileReader reader = new FileReader(file);
        int input;
        while ((input = reader.read()) != -1){
            System.out.println((char) input);
        }
        reader.close();


        //buffer - něco jako mezipaměť
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        bufferedReader.close();

        List<String> lines = Files.readAllLines(Paths.get("inputs\\bruh.txt"));
        System.out.println(lines);
        System.out.println("Lines: "+lines.size());
        int words = 0;
        String full = "";
        for (String idk : lines){
            full += idk;
            System.out.println(full);
            words += idk.split(" ").length;
        }
        System.out.println("Sentences: "+full.split(".").length);
        System.out.println("Words: "+words);




    }
}
