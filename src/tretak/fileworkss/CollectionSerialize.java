package tretak.fileworkss;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionSerialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(15,16,19));
        coordinates.add(new Coordinates(50,122,18));
        coordinates.add(new Coordinates(1,18,22));

        System.out.println(coordinates);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("coordiatesArrayList.ser"));
        oos.writeObject(coordinates);
        oos.close();

        List<Coordinates> deserializedCoordinates = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("coordinatesArrayList.ser"));
        deserializedCoordinates = (List<Coordinates>) ois.readObject();
        ois.close();
        System.out.println(deserializedCoordinates);
        System.out.println(deserializedCoordinates.size() == coordinates.size());
    }
}
