package tretak.fileworkss;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ciphering {


    public static void main(String[] args) throws IOException {
        Caesar cipher = new Caesar(3, "Caesar cipher");
        List<String> lines = Files.readAllLines(Paths.get("inputs\\cipherText.txt"));
        //pro ucely debugu, ulozit cely souboe do variable
        ArrayList<String> encryptedLines = new ArrayList<>();
        for (String line : lines){
            encryptedLines.add(cipher.encrypt(line));
        }

        System.out.println(encryptedLines);

        //nahazet do souboru:
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("outputs\\encryptedText.txt"))));
        for (String line : encryptedLines) {
            pw.println(line);
        }
        pw.close();

        lines = Files.readAllLines(Paths.get("outputs\\encryptedText.txt"));
        for (String line : lines){
            System.out.println(cipher.decrpyt(line));
        }
    }
}

abstract class Cipher{  //abstract - vylepšený rozhraní
    int key;
    String name;

    public Cipher(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cipher: " + name + " secret: " + key;
    }

    abstract String encrypt(String input);
    abstract String decrpyt(String encryptedInput);
}

class Caesar extends Cipher{
    public Caesar(int key, String name) {
        super(key, name);
    }

    @Override
    String encrypt(String input) {
        String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        char znak;
        int znakIndex;
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            znak = input.charAt(i);
            znakIndex = ALPHABET.indexOf(znak);
            encrypted.append(ALPHABET.charAt(znakIndex + this.key));
        }
        return encrypted.toString();
    }

    @Override
    String decrpyt(String encryptedInput) {
        String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        char znak;
        int znakIndex;
        StringBuilder dencrypted = new StringBuilder();
        for (int i = 0; i < encryptedInput.length(); i++) {
            znak = encryptedInput.charAt(i);
            znakIndex = ALPHABET.indexOf(znak);
            dencrypted.append(ALPHABET.charAt(znakIndex - this.key));
        }
        return dencrypted.toString();
    }
}
