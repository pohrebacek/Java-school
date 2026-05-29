package ctvrtak.networking.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        int port = 11111;
        System.out.println("Spousti se server na portu " + port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("server poslouchá");

            try(Socket client = serverSocket.accept()) {    //vezme připojenýho klienta ze socketu serveru
                System.out.println("Pripojil se: " + client.getInetAddress() + ":" + client.getPort());

                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream())); //bere data zadaný od kliente

                PrintWriter pw = new PrintWriter(client.getOutputStream(), true);   //odesílá zprávy klientovi

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Od klienta prislo: " + line);
                    pw.println("ECHO:"+line);   //vlastně pošle text, nevypíše
                }
                System.out.println("Klient se odpojil");
            }
        } catch (IOException e) {
            System.out.println(":(");
        }
        System.out.println("Happy ending");
    }
}
