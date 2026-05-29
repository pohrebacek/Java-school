package ctvrtak.networking.test2;
import java.io.Serializable;

public record OrderResponse(String itemName, int price) implements Serializable{

}
