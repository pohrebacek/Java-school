package exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Patient implements Monitoring{
    String id;
    int age;
    String department;
    List<Measurement> measurements;

    public Patient(String id, int age, String department) {
        this.id = id;
        this.age = age;
        this.department = department;

        //zacina s prazdnym seznamem procedur
        measurements = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", measurements=" + measurements +
                '}';
    }

    @Override
    public Measurement getLatestMeasurement() {
        /*
        vrátí poslední měření pacienta
        poslední = nejvyšší hodnota minute
        pokud pacient nemá měření → vrátí null
         */
        //jsem si nemšim že Patient má measurements :D
        //return Run.measurements.stream()
        //        .filter(m -> m.getPatientId().equals(this.getId()))
        //        .sorted(Comparator.comparing(Measurement::getMinute))
        //        .toList().reversed().stream().findFirst().orElse(null);
        if (measurements.isEmpty()) {
            return null;
        }
        return this.measurements.getLast();
    }

    @Override
    public double getRiskScore() {
        /*
        Skóre se počítá z posledního měření:

        oxygen < 92 +3
        bpm > 120 +2
        systolic > 160 +2
        diastolic > 100 +2
        age >= 65 +1

        Pokud pacient nemá měření → vrátí 0

         */
        double score = 0;
        Measurement lastMeasurement = this.getLatestMeasurement();
        if (lastMeasurement != null) {
            if (lastMeasurement.getOxygen() < 92) {
                score += 3;
            }
            if (lastMeasurement.getBpm() > 120) {
                score += 2;
            }
            if (lastMeasurement.getSystolic() > 160) {
                score += 2;
            }
            if (lastMeasurement.getDiastolic() > 100) {
                score += 2;
            }
            if (this.getAge() >= 65) {
                score += 1;
            }
            return score;
        }
        return 0;
    }

    @Override
    public boolean needsAttention() {
        /*
        vrací true, pokud skóre ≥ 5
         */
        return this.getRiskScore() >= 5;
    }

    @Override
    public void printMonitoringInfo() {
        /*
        vypíše historii měření u pacienta
        tato historie je vypsaná chronologicky (časově řazená)
         */


        this.measurements.stream()
                .sorted(Comparator.comparing(Measurement::getMinute))
                .forEach(System.out::println);


    }

    // TODO: implementovat rozhrani exam.Monitoring ve tride pacienta
}
interface Monitoring {

    /**
     * @return Nejnovejsi mereni pacienta
     */
    Measurement getLatestMeasurement();

    /**
     * @return skore zavaznosti, pokud nema zadna mereni, vrati 0
     */
    double getRiskScore();

    /**
     * @return true, pokud pacient ma skore zavaznosti >=5
     */
    boolean needsAttention();

    /**
     * Vypise historii pacienta.
     */
    void printMonitoringInfo();
}