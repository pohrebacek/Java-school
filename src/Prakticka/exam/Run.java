package exam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hlavni trida aplikace (Hub).
 */
public class Run {

    // Globalni kolekce
    public static ArrayList<Patient> patients = new ArrayList<>();
    public static ArrayList<Measurement> measurements = new ArrayList<>();

    //Promena pro vlakno - inicializujte jednou, at ho nemusite prepisovat
    public static LogThread logThread = new LogThread();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //nactu data:
        try {

            DataLoad.init();
            LogThread thread = new LogThread();
            thread.setName("logThread");
            thread.start();

            String action = "";
            while (!action.equals("5")) {
                System.out.println("Vyberte jednu z možností zadáním čísla 1 - 5.");
                printMenu();
                //Patient p = new Patient("P012", 87, "emergency");
                //System.out.println(p.getRiskScore());
                //p.printMonitoringInfo();
                action = sc.nextLine();
                switch (action) {
                    case "1":
                        PatientTest.init();
                        break;
                    case "2":
                        PatientGui.init();
                        break;
                    case "3":
                        MonitoringServices.init();
                        break;
                    case "4":
                        if (thread.isAlive()) {
                            thread.interrupt();
                            System.out.println("Logging disabled");
                        } else {
                            thread = new LogThread();
                            thread.setName("logThread");
                            thread.start();
                            System.out.println("Logging enabled");
                        }
                        break;
                }
            }
            if (thread.isAlive()) {
                thread.interrupt();
            }
            System.out.println("Ukončuji program...");
        } catch (IOException e) {
            System.out.println("Chyba při načítání dat ze souboru: " + e.getMessage());
            System.out.println("Ukončuji program...");
        }

        //ruzne moznosti:
//        exam.PatientTest.init();
//        exam.PatientGui.init();
//        exam.MonitoringServices.init();
//        toggleLogging();

    }


    private static void printMenu() {
        System.out.println("1 - OOP otestovani implementace");
        System.out.println("2 - GUI");
        System.out.println("3 - Statistiky");
        System.out.println("4 - Thread Start/stop");
        System.out.println("5 - Konec");
        System.out.print("> ");
    }

    public static boolean doesPatientExist(String patientId) {
        List<String> ids = Run.patients.stream().map(Patient::getId).toList();
        if (ids.contains(patientId)) {
            return true;
        }
        return false;
    }

    private static void toggleLogging() {
        // TODO: spustit / zastavit vlakno (zastavit muzete treba pomoci interrupt(), pozor)
    }
}
