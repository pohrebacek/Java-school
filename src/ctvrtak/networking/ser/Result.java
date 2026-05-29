package ctvrtak.networking.ser;

import java.io.Serializable;

public record Result(double distance, String quadrant) implements Serializable {
}
