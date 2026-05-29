package ctvrtak.networking.chatRoom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RoomChatServer {
    final static int PORT = 11111;
    static int clientCounter = 1;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            while(true) {
                Socket client = serverSocket.accept();
                System.out.println("Pripojil se: " + client.getPort() + ":" + client.getInetAddress());

                ClientHandler clientHandler = new ClientHandler(client, "CL_"+clientCounter++);
                clientCounter++;

                clientHandler.start();
            }
        } catch (IOException e) {
            System.out.println(":(");
        }
    }

}
