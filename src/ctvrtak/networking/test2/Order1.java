package ctvrtak.networking.test2;
import java.io.Serializable;

public record Order1(String itemName, int qty) implements Serializable {
    public Order1 {
        if (itemName == null) itemName = "";
    }
}

