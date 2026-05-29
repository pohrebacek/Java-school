package tretak.fileworkss;

import java.io.*;

public class WritingTask {
    public static void main(String[] args) throws IOException {
        //přečte všechny outputs, vezme sudý čísla a všechny je napíše do soubory evens
        File directory = new File("outputs");
        File[] files = directory.listFiles();




        BufferedWriter bw = new BufferedWriter(new FileWriter("outputs\\evens.txt"));
        for (File file : files) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if (Integer.parseInt(line) % 2 == 0) {
                    bw.write(line);
                    bw.newLine();
                }
            }
            bufferedReader.close();

        }
        bw.close();

    }
}
