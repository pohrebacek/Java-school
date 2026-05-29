package ctvrtak.networking.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class MathServer {
    public static void main(String[] args) {
        String[] operations = {"difference","addition","multiplication"};
        Random r = new Random();
        String operation = operations[r.nextInt(1,3)];
        int num1 = r.nextInt(-100, 101);
        int num2 = r.nextInt(-100, 101);
        String priklad = "/" + operation+ ";" + num1 + ";" + num2;
        String[] answer;

        int port = 54321;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("waiting");
            try (Socket client = serverSocket.accept()) {
                System.out.println("Pripojil se: " + client.getInetAddress() + ":" + client.getPort());

                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter pw  =new PrintWriter(client.getOutputStream(), true);


                pw.println("Priklad:" + priklad);
                String input = reader.readLine();
                System.out.println(input);
                while (input != null) {

                    answer = input.split(";");
                    if (answer[0].equals("/result")) {
                        try {
                            System.out.println("done");
                            int result = Integer.parseInt(answer[1]);
                            if (check(operation, num1, num2, result)) {
                                pw.println("good");
                            } else {
                                pw.println("not good");
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("zadej číslo");
                        }
                    } else {
                        System.out.println("bruh");
                    }
                }


            }
        } catch (IOException e) {
            System.out.println((":("));
        }
    }

    public static boolean check(String operation, int num1, int num2, int userResult){
        switch (operation){
            case "difference": if((num1 - num2) == userResult) {
                return true;
            }; break;
            case "addition": if((num1 + num2) == userResult) {
                return true;
            }break;
            case "multiplication": if((num1 * num2) == userResult) {
                return true;
            } break;

        }
        return false;
    }
}
