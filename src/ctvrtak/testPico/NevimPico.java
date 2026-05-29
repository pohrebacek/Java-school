package ctvrtak.testPico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NevimPico {
    public static void main(String[] args) {
        try {
            List<Item> inventory = new ArrayList<>();
            List<String> lines = Files.readAllLines(Paths.get("inputs\\inventory.txt"));
            for (String line : lines) {
                String[] parts = line.split(";");
                int maxQuantity = 0;

                if (parts.length == 2) {
                    inventory.add(new Item(
                            parts[0],
                            Integer.parseInt(parts[1]),
                            Integer.MAX_VALUE
                    ));
                } else {
                    inventory.add(new Item(
                            parts[0],
                            Integer.parseInt(parts[1]),
                            Integer.parseInt(parts[2])));
                }

            }

            List<Operation> operations = Files.lines(Paths.get("inputs\\operations.txt"))
                    .map(line -> line.split(";"))
                    .map(parts -> new Operation(
                            parts[0],
                            parts[1],
                            Integer.parseInt(parts[2])
                    ))
                    .toList();

            processOperations(inventory, operations);
            inventory.stream()
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    static void processOperations(List<Item> inventory, List<Operation> operations){
        int count = 0;
        for (Operation operation : operations){
            if (operation.operationName.equals("ADD")) {
                Item currentItem;
                for (Item item : inventory) {
                    if (item.getName().equals(operation.getItemName())){
                        currentItem = item;
                        int newQuantity = operation.getAmount() + currentItem.getQuantity();
                        if (currentItem.getMaxQuantity() == Integer.MAX_VALUE || newQuantity <= currentItem.getMaxQuantity()){
                            currentItem.setQuantity(newQuantity);
                        }
                        count++;
                        break;
                    }
                }

            } else if (operation.operationName.equals("REMOVE")) {
                Item currentItem;
                for (Item item : inventory) {
                    if (item.getName().equals(operation.getItemName())){
                        currentItem = item;
                        int newQuantity = currentItem.getQuantity() - operation.getAmount();
                        if (newQuantity >= 0){
                            currentItem.setQuantity(newQuantity);
                        }
                        count++;
                        break;
                    }
                }

            }
        }
        System.out.println(count);
    }
}

class Operation {
    String operationName;
    String itemName;
    int amount;

    public Operation(String operationName, String itemName, int amount) {
        this.operationName = operationName;
        this.itemName = itemName;
        this.amount = amount;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

class Item {
    String name;
    int quantity;
    int maxQuantity;

    public Item(String name, int quantity, int maxQuantity) {
        this.name = name;
        this.quantity = quantity;
        this.maxQuantity = maxQuantity;
    }

    @Override
    public String toString() {
        return "name='" + name +
                ", quantity=" + quantity +
                ", maxQuantity=" + maxQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
}
