package tretak.fileworkss;

import java.io.*;

public class SerialExport {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //exportovani/serialization
        Coordinates coords = new Coordinates(5, 6, 20);
        System.out.println("Exportuju: "+coords);


        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("single coord.ser"));
        oos.writeObject(coords);
        oos.close();

        //import/deserialization
        Coordinates deserialized = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("single coord.ser"));
        deserialized = (Coordinates) ois.readObject();

        System.out.println("Importovano: "+deserialized);

    }
}
