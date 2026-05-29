package exam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Vlakno zapisující log každých 5 sekund.
 */
public class LogThread extends Thread{
    // TODO: zajistit, aby tato trida byla spustitelne vlakno
    //[2026-04-28T07:05:29.106846500] Patients: 50, Measurements: 1000, Critical: 120
    @Override
    public void run() {
        String logText = LocalDateTime.now() + " " + "Patients: " + Run.patients.size() + ", Measurements: " + Run.measurements.size();
        try {
            Thread.sleep(5000);
            BufferedWriter bw = new BufferedWriter(new FileWriter("monitoring-log.txt", true));
            bw.write(logText);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Chyba při zapisování do log.txt");
        } catch (InterruptedException ex) {
            System.out.println("Chyba s vláknem při zapisování do log.txt");
        }
    }

}
