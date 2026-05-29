package exam;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Prace se streamy a statistikami.
 */
public class MonitoringServices {


    static long getMeasurementCount() {
        return Run.measurements.size();  //celkovy pocet mereni
    }

    static double getAverageOxygen(String department) {
        List<String> patientIDs = Run.patients.stream()
                .filter(p -> p.getDepartment().equals(department))
                .map(Patient::getId).toList();
        return Run.measurements.stream()
                .filter(m -> patientIDs.contains(m.getPatientId()))
                .collect(Collectors.averagingDouble(Measurement::getOxygen));
        //return 0; //Prumerna oxidace pacientu na oddeleni
    }

    static double pctHighPressure(){
        return (double) Run.measurements.stream()
                .filter(m -> m.getSystolic() > 150 || m.getDiastolic() > 100)
                .count() / Run.measurements.size() * 100;//vrati, kolik % mereni vykazuje vyssi tlak (Systolicky tlak vyssi 150 nebo diastolicky vyssi nez 100)
    }

    static Map<String, Long> patientsPerDepartment(){
        return Run.patients.stream()
                .collect(Collectors.groupingBy(Patient::getDepartment, Collectors.counting())); //mapa <nazev oddeleni - pocet pacientu>
    }

    static Map<String, List<Patient>> criticalInDepartment(){
        return null; // mapa <nazev oddeleni - kriticti pacienti>
    }

    static List<Measurement> topRecent(int limit){
        return Run.measurements.stream()
                .sorted(Comparator.comparing(Measurement::getMinute))
                .toList().reversed().stream().limit(limit).toList(); // list poslednich mereni (napr poslednich 10 - 10 dle nejvetsich minutes)
    }

    static void init() {
        // TODO: zde testujte vypocty
        System.out.println("celkovy pocet mereni: " + getMeasurementCount());
        System.out.println(("avg oxygen: " + getAverageOxygen("ICU")));
        System.out.println("kolik % mereni vykazuje vyssi tlak: " + pctHighPressure());
        System.out.println(patientsPerDepartment());
        System.out.println(topRecent(10));
    }
}
