package tretak.fileworkss;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BloodBank {
    static void testDonations(int times) {
        for (int i = 0; i < times; i++) {
            //TODO: 18.12.2024 Nahodna dvojice se pokusi darovat krev
        }
    }
    static BloodType parseBlood(String bloodType) {
        switch (bloodType) {
            case "A+": return BloodType.A_POSITIVE;
            case "A-": return BloodType.A_NEGATIVE;
            case "B+": return BloodType.B_POSITIVE;
            case "B-": return BloodType.B_NEGATIVE;
            case "AB+": return BloodType.AB_POSITIVE;
            case "AB-": return BloodType.AB_NEGATIVE;
            case "0+": return BloodType.O_POSITIVE;
            case "0-": return BloodType.O_NEGATIVE;
            default: return BloodType.AB_POSITIVE;
        }
    }
    static ArrayList<BloodDonor> getDonors(String filePath) throws IOException {
        ArrayList<BloodDonor> donors = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        lines.remove(0);    //první řádek jsou názvy sloupců
        String[] params;
        BloodDonor donor;
        for (String line : lines){
            params = line.split(",");
            donor = new BloodDonor(params[0], Integer.parseInt(params[1]), params[2], parseBlood(params[3]));
            donors.add(donor);
        }
        return donors;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<BloodDonor> donors = getDonors("inputs\\blood.csv");
        for (BloodDonor donor : donors){
            System.out.println(donor);
        }
        BloodDonor from = donors.get(0);
        BloodDonor to = donors.get(1);

    }
}
class BloodDonor {
    String name;
    int age;
    String state;
    BloodType bloodType;

    public BloodDonor(String name, int age, String state, BloodType bloodType) {
        this.name = name;
        this.age = age;
        this.state = state;
        this.bloodType = bloodType;
    }
    static boolean donate(BloodDonor from, BloodDonor to) {
        int[][] compatibility = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };
        int toIndex;
        if (to.bloodType.i - 7 < 0){
            toIndex = (to.bloodType.i - 7) * (-1);
        } else {
            toIndex = to.bloodType.i - 7;
        }
        if (compatibility[from.bloodType.i][toIndex] == 1) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return name+"("+bloodType+")";
    }
}

enum BloodType {
    O_POSITIVE(1),
    O_NEGATIVE(0),
    A_POSITIVE(5),
    A_NEGATIVE(4),
    B_POSITIVE(3),
    B_NEGATIVE(2),
    AB_POSITIVE(7),
    AB_NEGATIVE(6),
    ;
    int i;

    BloodType(int i) {
    }
}
