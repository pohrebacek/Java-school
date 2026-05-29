package ctvrtak.networking.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        int port = 11111;
        String host = "127.0.0.1";

        System.out.println("Pripojuji se k " + host + ":" + port);

        try (Socket socket = new Socket(host, port)) {  //socket je vlastně spoj mezi dvěma programy přes sí´t
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);   //vezme text z konzole a pošle druhé straně
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //čte text z druhé strany poslaný přes socket

            System.out.println("připojeno k serveru");

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("Zadej zpravu, kterou chces poslat (quit pro ukonceni): ");

                String message = sc.nextLine();
                if (message.equalsIgnoreCase("quit")) {
                    break;
                }

                //zpravu ze scanneru (klavesnice/konzole) nacti a posli do outputu -> server
                pw.println(message);

                String response = in.readLine();    //přečte si právě poslaný text z druhé strany

                if (response == null) {
                    System.out.println("Server ukoncil pripojeni");
                    break;
                }
                System.out.println("Echo od serveru: " + response);
            }
        } catch (IOException e) {
            System.out.println("nuuuuuuuuuuu");
        }
    }
}
