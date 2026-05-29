package ctvrtak.networking.test2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class OrderClient {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 5001);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Scanner sc = new Scanner(System.in);
                ) {
            System.out.println("Zadej položku z katalogu: ");
            String item = sc.nextLine();
            System.out.println("Zadej množství: ");
            int amount = sc.nextInt();

            out.writeObject(new Order1(item, amount));
            out.flush();

            OrderResponse orderResponse = (OrderResponse) in.readObject();
            System.out.println("Item: " + orderResponse.itemName() + ", cena: " + orderResponse.price());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(":(");
        }
    }
}
