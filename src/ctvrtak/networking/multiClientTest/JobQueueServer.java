package ctvrtak.networking.multiClientTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobQueueServer {


    public static List<String> jobs = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        int port = 11111;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket newClient = serverSocket.accept();
                System.out.println("Pripojil se novy klient: " + newClient.getInetAddress() + ":" + newClient.getPort());

                ClientHandler handler = new ClientHandler(newClient);
                handler.start();
            }
        } catch (IOException e) {
            System.out.println(":(");
        }
    }

    static synchronized void addToList(StringBuilder task) {
        jobs.add(String.valueOf(task).trim());
    }

    static class ClientHandler extends Thread {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run(){
            try(BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);

                String[] command;

                while ((command = (br.readLine()).split(" ")).length != 0) {
                    if ("quit".equalsIgnoreCase(command[0])) {
                        System.out.println(clientSocket.getInetAddress() + ":"
                                + clientSocket.getPort() + " se odpojuje.");
                        break;
                    }



                    switch (command[0]) {
                        case "push":
                            boolean commandIsBlank = true;
                            for (int i = 1; i < command.length; i++) {
                                if (!command[i].isBlank()) {
                                    commandIsBlank = false;
                                    break;
                                }
                            }
                            if (commandIsBlank) {
                                pw.println("Couldn't add task");
                                break;
                            }
                            StringBuilder task = new StringBuilder();
                            for (int i = 1; i < command.length; i++) {
                                task.append(command[i] + " ");
                            }
                            addToList(task);
                            pw.println("Task was added");
                            break;
                        case "list":
                            if (command.length > 1) {
                                pw.println("Zadej správný příkaz");
                                break;
                            }
                            if (jobs.isEmpty()) {
                                pw.println("Task list je prazdny");
                                break;
                            }
                            pw.println(jobs);
                            break;
                        default:
                            pw.println("Zadej správný příkaz");
                    }

                }




            } catch (IOException e) {
                System.out.println(":(");
            }
        }
    }
}
