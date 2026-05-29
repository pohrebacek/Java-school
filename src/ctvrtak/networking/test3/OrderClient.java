package ctvrtak.networking.test3;

import ctvrtak.networking.test2.Order1;
import ctvrtak.networking.test2.OrderResponse;
import jdk.jshell.Snippet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class OrderClient {
    public static void main(String[] args) {
        int requestId = 1;
        try (
                Socket socket = new Socket("localhost", 5001);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Scanner sc = new Scanner(System.in);
        ) {
            while (true) {
                String msg = sc.nextLine();
                if (msg.equalsIgnoreCase("/quit")) {
                    break;
                }
                switch (sc.nextLine()){
                    case "/order":
                        System.out.println("Zadej typ (put/take): ");
                        OrderType type = sc.nextLine().equals("put") ? OrderType.PUT : OrderType.TAKE;
                        System.out.println("Zadej jméno itemu: ");
                        String itemName = sc.nextLine();
                        System.out.println("Zadej množství: ");
                        int qty = sc.nextInt();
                        out.writeObject(new Order(requestId, type, itemName, qty));
                        requestId++;
                        out.flush();
                        break;
                    case "/state":
                        out.writeObject(new StateRequest(requestId));
                        requestId++;
                        out.flush();
                        break;

                }

                Object response = in.readObject();
                if (response instanceof OrderResponse) {
                    OrderResponse orderResponse = (OrderResponse) response;
                    System.out.println("Item: " + orderResponse.itemName() + ", cena: " + orderResponse.price());

                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}


