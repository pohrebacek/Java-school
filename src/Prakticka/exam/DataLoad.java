package exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Nacitaní dat ze souboru.
 */
public class DataLoad {

    static void loadPatients(String path) throws IOException {
        Run.patients = Files.lines(Paths.get(path))
                .map(line -> line.split(";"))
                .map(params -> new Patient(
                        params[0],
                        Integer.parseInt(params[1]),
                        params[2]
                ))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    static void cleanMeasurements(String directoryPath) throws IOException {
        // TODO: vytvorit cleanMeasurements.txt
        Path p = Paths.get(directoryPath);
        Stream<Path> fileStream = Files.walk(p);
        List<Path> filePaths = fileStream
                .filter(Files::isRegularFile)
                .filter(file -> file.getFileName().toString().startsWith("measurements") && file.toString().endsWith(".csv"))
                .toList();
        //System.out.println(filePaths);


        StringBuilder valid = new StringBuilder();
        for (Path fp : filePaths) {
            valid.append(Files.lines(Paths.get(fp.toUri()))
                        .filter(line -> !line.toString().startsWith("!"))
                        .toString()
            );

        }

    }


    static void loadMeasurements(String path) throws IOException {
        // TODO: načíst měření
        Run.measurements = Files.lines(Paths.get(path))
                .map(line -> line.split(";"))
                .map(params -> new Measurement(
                        params[0],
                        Integer.parseInt(params[1]),
                        Double.parseDouble(params[2]),
                        Integer.parseInt(params[3]),
                        Integer.parseInt(params[4]),
                        Integer.parseInt(params[5])
                ))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    static void init() throws IOException {

        // TODO: Spusteni nacteni:

        loadPatients("data/patients.txt");
        //cleanMeasurements("data");
        loadMeasurements("data/cleanMeasurements.csv");
        System.out.println("Nacteno pacientu: " + Run.patients.size());
        System.out.println("Nacteno mereni: " + Run.measurements.size());
    }
}
