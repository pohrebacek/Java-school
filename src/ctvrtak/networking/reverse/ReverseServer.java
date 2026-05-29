package ctvrtak.networking.reverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ReverseServer {
    public static void main(String[] args) {
        int port = 11111;
        String keyword = "test";

        try (ServerSocket server = new ServerSocket(port)){
            System.out.println("waiting...");

            try (Socket client = server.accept()) {
                PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

                pw.println(keyword);

                String clientInput = reader.readLine(); //přečte co poslal uživatel
                System.out.println("client sent: " + clientInput);
                if (new StringBuilder(clientInput).reverse().toString().equals(keyword)) {
                    pw.println("OK");
                } else {
                    pw.println("NOT OK");
                }
            }
        } catch (IOException e) {
            System.out.println(":(");
        }
    }
}
