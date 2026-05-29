package tretak.fileworkss;

import java.io.*;

public class MultipleSerial {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Coordinates c1 = new Coordinates(1,2,3);
        Coordinates c2 = new Coordinates(546,50,3);
        Coordinates c3 = new Coordinates(28,21,39);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dalsiExport.ser"));
        oos.writeObject(c1);
        oos.writeObject(c2);
        oos.writeObject(c3);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dalsiExport.ser"));
        Coordinates d1 = (Coordinates) ois.readObject();
        Coordinates d2 = (Coordinates) ois.readObject();
        Coordinates d3 = (Coordinates) ois.readObject();
        ois.close();

    }


}
