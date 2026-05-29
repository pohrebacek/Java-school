package tretak.fileworkss;

import java.io.Serial;
import java.io.Serializable;

public class Coordinates implements Serializable { //bez toho seriazable to spadne na držku
    int x,y,z;
    @Serial
    private static final long serialVersionUID = 42L;

    public Coordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "["+x+","+y+","+z+"]";
    }
}
