package ctvrtak.networking.chatRoom;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class ClientHandler extends Thread{
    Socket clientSocket;
    String clientID;

    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket clientSocket, String clientID) {
        this.clientSocket = clientSocket;
        this.clientID = clientID;
    }

    public String getClientID() {
        return clientID;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()),true);
            //tudy komunikuje client k serveru
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println("Successful connect");  //vypise u klienta od serveru
            RoomManager.ROOM_MANAGER.joinLobby(this);
            String recieved;


            while ((recieved = in.readLine()) != null) {
                if (recieved.equalsIgnoreCase("/quit")) {
                    break;
                }
                System.out.println(clientID + ":" + recieved);
                CommandRouter.handleCommand(this, recieved);
            }

        } catch (IOException e) {
            System.out.println("Disconnected: " + clientID + " (" + e.getMessage() + ")");
        }finally {
            out.close();
        }
    }


    void send(String message){
        out.println(message);
    }

    void handleCommand(String input){

    }
}
