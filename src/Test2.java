import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

//2 soubory:
//        usernames, AllPINs
//
//        Soubory attempts_{1..5}.txt
//
//        Do konzole:
//        attempts_1: 15 valid
//        ...
//        % of all valid: X %
//
//        Vypsat soubor: validLogins.txt
//
//        validní login:
//        ten, kde username a PIN jsou ve zdrojových souborech na stejném řádku.
public class Test2 {
    public static void main(String[] args) throws IOException {
        List<String> users = Files.readAllLines(Paths.get("inputs\\logins\\data\\usernames.txt"));
        List<String> PINS = Files.readAllLines(Paths.get("inputs\\logins\\data\\AllPINs.txt"));
        int allValid = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("outputs\\validLogins.txt"));

        for (int i = 1; i < 6; i++) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inputs\\logins\\data\\attempts_"+i+".txt"));
            String line;
            String[] params;
            String foundUser;
            String PIN;
            int valid = 0;
            while ((line = bufferedReader.readLine()) != null){
                params = line.split("=");
                for (int j = 0; j < users.size(); j++) {
                    if (users.get(j).equals(params[0])) {
                        if (j == Integer.parseInt(params[1])){
                            bw.write(line+"\n");
                            valid++;
                            allValid++;
                        }
                        break;
                    }
                }
            }
            System.out.println(i+": "+valid);
            bufferedReader.close();
        }
        bw.close();
        double allValid2 = (double) allValid /users.size();
        System.out.println(allValid2*100+"%");
    }
}
