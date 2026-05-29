package ctvrtak.networking.test2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class OrderServer {

    private static final int PORT = 5001;
    private static final Map<String, Double> CATALOG = Map.of(
            "pen", 1.50,
            "notebook", 3.99,
            "stapler", 7.25,
            "mouse", 12.90
    );

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("OrderServer listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                new Thread(() -> handleClient(socket), "client-handler").start();
            }
        }
    }

    private static void handleClient(Socket socket) {
        try (socket;
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
        ) {
            //bude Order
            Order1 order = (Order1) in.readObject();
            if (CATALOG.get(order.itemName()) != null && order.qty() > 1) {
                out.writeObject(new OrderResponse(order.itemName(), (int) (order.qty() * CATALOG.get(order.itemName()))));
                out.flush();
            } else {
                out.writeObject(new OrderResponse("nenalezeno", 0));
                out.flush();
            }


            //CATALOG.get("jmeno"); // vrati cenu

        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
