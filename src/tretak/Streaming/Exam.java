package tretak.Streaming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Exam {
    public static void main(String[] args) {
        ArrayList<Record> records = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("inputs\\hospital_data.csv"));
            String[] params;
            for (String line: lines) {
                params = line.split(",");
                records.add(new Record(Integer.parseInt(params[0]), params[1], params[2], Double.parseDouble(params[3]), Integer.parseInt(params[4])));
            }

            //1: vypsat všechny ženy ve věkzu od 30 do 60 let
            System.out.println("vypsat všechny ženy ve věkzu od 30 do 60 let");
            records.stream()
                    .filter(record -> record.getGender().equals("Female"))
                    .filter(record -> record.getAge() >= 30 && record.getAge() <= 60)
                    .forEach(System.out::println);

            //2: Jaká byla průměrná částka pro pojišťovnu za muže s diagnózou cukrovky (Diabetes)
            System.out.println("Jaká byla průměrná částka pro pojišťovnu za muže s diagnózou cukrovky (Diabetes)");
            double avgAmount = records.stream()
                    .filter(record -> record.getGender().equals("Male"))
                    .filter(record -> record.getMedicalCondition().equals("Diabetes"))
                    .mapToDouble(Record::getBillingAmount)
                    .average()
                    .orElse(0);
            System.out.println(avgAmount);

            //3: Spočítat a vypsat, kolik procent všech diagnóz jsou rakovina (Cancer)
            System.out.println("Spočítat a vypsat, kolik procent všech diagnóz jsou rakovina (Cancer)");
            long cancers = records.stream()
                    .filter(record -> record.getMedicalCondition().equals("Cancer"))
                    .count();
            double procenta = (double) cancers /records.size();
            System.out.println(procenta*100);

            //4: Vypište, kolik unikátních nemocničních pokojů bylo využito (Room number)
            System.out.println("Vypište, kolik unikátních nemocničních pokojů bylo využito (Room number)");
            double rooms = records.stream()
                    .mapToDouble(Record::getRoomNumber)
                    .distinct()
                    .count();
            System.out.println(rooms);

        } catch (IOException e) {
            System.out.println("Nepodarilo se najit soubor");
            System.out.println(e.getMessage());
        }


    }
}

class Record {
    int Age;
    String Gender;
    String MedicalCondition;
    double BillingAmount;
    int RoomNumber;

    public Record(int age, String gender, String medicalCondition, double billingAmount, int roomNumber) {
        Age = age;
        Gender = gender;
        MedicalCondition = medicalCondition;
        BillingAmount = billingAmount;
        RoomNumber = roomNumber;
    }

    public int getAge() {
        return Age;
    }

    public String getGender() {
        return Gender;
    }

    public String getMedicalCondition() {
        return MedicalCondition;
    }

    public double getBillingAmount() {
        return BillingAmount;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    @Override
    public String toString() {
        return "Record{" +
                "Age=" + Age +
                ", Gender='" + Gender + '\'' +
                ", MedicalCondition='" + MedicalCondition + '\'' +
                ", BillingAmount=" + BillingAmount +
                ", RoomNumber=" + RoomNumber +
                '}';
    }
}
