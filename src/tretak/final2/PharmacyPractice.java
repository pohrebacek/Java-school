package tretak.final2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PharmacyPractice {

    static List<Medication> medications = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();

    static HashMap<String, Integer> stockMedications = new HashMap<>();


    static void loadAndProcessOrders(String filePath) {
        try {
            Files.lines(Paths.get(filePath))
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(params -> new Order(
                            params[0],
                            params[1],
                            Integer.parseInt(params[2])
                            )


                    );

        } catch (IOException e) {
            System.out.println("soubor nenalezen");
        }
    }

    static boolean loadMedications(String filePath) {
        try {
            medications = Files.lines(Paths.get(filePath))
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(params -> new Medication(
                            params[0],
                            params[1],
                            Double.parseDouble(params[2])
                    ))
                    .toList();
            return true;
        } catch (IOException e) {
            System.out.println("soubor nenalezen");
            return false;
        }
    }

    static void printInventory() {
        for (String med : stockMedications.keySet()) {
            System.out.println(med+": "+ stockMedications.get(med));
            System.out.println(
                    medications.stream()
                            .collect(Collectors.groupingBy(Medication::getName, Collectors.summingDouble(Medication::getPricePerPiece))
            ));
        }

    }


    public static void main(String[] args) throws IOException {
        loadMedications("inputs\\final2\\medications.csv");
        loadAndProcessOrders("inputs\\final2\\orders.csv");


        for (Order order : orders) {
            BufferedWriter bw = new BufferedWriter(new FileWriter("outputs\\invalids.txt"));
            ArrayList<String> medNames = new ArrayList<>();
            for (Medication medication : medications) {
                medNames.add(medication.getName());
            }

            if (order.getAction().equals("restock")) {
                if(stockMedications.containsKey(order.getMedicationName())) {
                    stockMedications.replace(order.getMedicationName(), stockMedications.get(order.getMedicationName()), stockMedications.get(order.getMedicationName())+ order.getPieces());
                } else {
                    stockMedications.put(order.getMedicationName(), order.getPieces());
                }
            } else {
                if (!medNames.contains(order.getMedicationName())) {
                    bw.write(order.toString() + "LÉK NENALEZEN");
                    bw.close();
                } else if (stockMedications.get(order.getMedicationName()) < order.getPieces())  {
                    bw.write(order.toString() + "NEDOSTATEK KUSŮ NA SKLADĚ");
                    bw.newLine();
                }
            }

        }

    }

}

class Medication {
    String name, type;
    double pricePerPiece;

    public Medication(String name, String type, double pricePerPiece) {
        this.name = name;
        this.type = type;
        this.pricePerPiece = pricePerPiece;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPricePerPiece() {
        return pricePerPiece;
    }
}

class Order {
    String action, medicationName;
    int pieces;

    public Order(String action, String medicationName, int pieces) {
        this.action = action;
        this.medicationName = medicationName;
        this.pieces = pieces;
    }

    public String getAction() {
        return action;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public int getPieces() {
        return pieces;
    }

    @Override
    public String toString() {
        return "Order{" +
                "action='" + action + '\'' +
                ", medicationName='" + medicationName + '\'' +
                ", pieces=" + pieces +
                '}';
    }
}
