package tretak.oopInheritence;
import fileworks.DataImport;
import fileworks.DataExport;

import java.util.ArrayList;

public class HospitalTest {
    public static void main(String[] args) {
        DataImport di = new DataImport("procedures.txt");
        String line;
        String[] info;
        Doctor min = new Doctor(Integer.MAX_VALUE, "none");
        Doctor max = new Doctor(Integer.MIN_VALUE, "none");
        Doctor tmp = new Doctor(0, "none");
        ArrayList<Doctor> doctors = new ArrayList<>();
        while (di.hasNext()){
            line = di.readLine();
            info = line.split(",");
            int s = 50000;
            switch (info[1]) {
                case "DOC":
                    for (int i = 2; i < info.length; i++) {
                        switch (info[i]) {
                            case "D":
                                s += 1000;
                            case "S":
                                s -=50000;
                            case "C":
                                s -=50000;
                        }
                    }
                    tmp = new Doctor(s, info[0]);
                    doctors.add(tmp);
                    break;
                case "SUR":
                    for (int i = 2; i < info.length; i++) {
                        switch (info[i]) {
                            case "D":
                                s += 1000;
                            case "S":
                                s +=5000;
                            case "C":
                                s -=50000;
                        }
                    }
                    tmp = (new Surgeon(s, info[0]));
                    doctors.add(tmp);
                    break;
                case "CAR":
                    for (int i = 2; i < info.length; i++) {
                        switch (info[i]) {
                            case "D":
                                s += 1000;
                            case "S":
                                s +=5000;
                            case "C":
                                s +=15000;
                        }
                    }
                    tmp = (new CardioSurgeon(s, info[0]));
                    doctors.add(tmp);
                    break;

            }
            if (min.salary > s){
                min = tmp;
            }

            if (max.salary < s){
                max = tmp;
            }

        }
        di.finishImport();

        System.out.println("Nejvíc: "+max.name);
        System.out.println("Nejmíň: "+min.name);
        DataExport de = new DataExport("report.txt");
        for (Doctor doctor: doctors) {
            de.writeLine(doctor.name+": "+doctor.salary);
        }
        de.finishExport();


    }
}
