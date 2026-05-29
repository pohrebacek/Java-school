package exam;

/**
 * Trida slouzici pouze pro overeni spravne implementace
 */
public class PatientTest {

    static void init(){
        //TODO: odkomentujte vsechny radky kodu pro overeni

        // vytvoreni pacientu
        Patient p1 = new Patient("P001", 70, "ICU");
        Patient p2 = new Patient("P002", 40, "Internal");

        System.out.println("TEST: pacient bez měření");
        System.out.println(p2.getLatestMeasurement()); // null
        System.out.println(p2.getRiskScore());         // 0
        System.out.println(p2.needsAttention());       // false

        System.out.println();

        // pridani mereni
        p1.measurements.add(new Measurement("P001", 30, 95.0, 80, 130, 85));
        p1.measurements.add(new Measurement("P001", 10, 97.0, 75, 120, 80));
        //tohle mereni bude kriticke:
        p1.measurements.add(new Measurement("P001", 60, 90.0, 130, 170, 110));

        System.out.println("TEST: getLatestMeasurement ");
        exam.Measurement latest = p1.getLatestMeasurement();
        System.out.println(latest);

        // melo by byt:
        // minute = 60, oxygen 90, bpm 130, tlak 170/110

        System.out.println();

        System.out.println("TEST: needsAttention ");
        System.out.println(p1.needsAttention()); // true (>=5)

        System.out.println();

        System.out.println("printMonitoringInfo: je serazeno?");
        p1.printMonitoringInfo();
    }
}
