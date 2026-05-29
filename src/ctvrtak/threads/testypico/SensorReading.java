package ctvrtak.threads.testypico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SensorReading {

    static List<Reading> readings = Collections.synchronizedList(new ArrayList<>());
    static List<InvalidReading> invalidReadings = Collections.synchronizedList(new ArrayList<>());

    static void processReadingFile(String fileName) throws IOException {
        //zpracuje jeden soubor a ulozi do listu informace
        String line;
        String[] attributes;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        Reading r;
        int lineNum = 1;
        while ((line = br.readLine()) != null) {
            attributes = line.split(",");
            r = new Reading(attributes[0], Integer.parseInt(attributes[1]));
            if (r.value <= 20000 && r.value >= -20000) {
                readings.add(r);
            } else {
                invalidReadings.add(new InvalidReading(r, fileName, lineNum));
            }
            lineNum++;
        }
        br.close();
    }

    public static void main(String[] args) throws InterruptedException {
        String basename = "inputs\\readings\\sensors_";

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i <= 50; i++) {
            int fileIndex = i+1;
            executorService.submit(() -> {
                try {
                    processReadingFile(basename + fileIndex + ".txt");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        System.out.println("Cteni celkem: " +readings.size());
        System.out.println("Invalid: " + invalidReadings.size());
        for (InvalidReading ir : invalidReadings) {
            System.out.println(ir.toString());
        }
    }
}
class Reading{

    String sensorID;
    int value;
    public Reading(String sensorID, int value) {
        this.sensorID = sensorID;
        this.value = value;
    }
    @Override
    public String toString() {
        return sensorID + ": " + value;
    }
}

class InvalidReading{
    Reading reading;
    String fileName;
    int lineNum;

    public InvalidReading(Reading reading, String fileName, int lineNum) {
        this.reading = reading;
        this.fileName = fileName;
        this.lineNum = lineNum;
    }

    @Override
    public String toString() {
        return "reading:" + reading.sensorID +
                ", fileName='" + fileName +
                ", lineNum=" + lineNum;
    }
}
