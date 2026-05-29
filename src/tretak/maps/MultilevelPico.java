package tretak.maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MultilevelPico {
    public static void main(String[] args) throws IOException {

        List<StudentResult> results = Files.lines(Paths.get("inputs\\student_scores.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(params -> new StudentResult(
                        params[0],
                        params[1],
                        Double.parseDouble(params[2]),
                        Integer.parseInt(params[3])
                ))
                .toList();

        //mapa: student: [predmet] - {score}
        //mapa co má klíč jméno studenta, value je mapa co má klíč název předmětu a value je seznam avg skore
        Map<String, Map<String, List<Double>>> grouped = results.stream()
                .collect(Collectors.groupingBy(StudentResult::getName,  //prvni mapa, prvni klíč
                        Collectors.groupingBy(StudentResult::getSubject,
                                Collectors.mapping(StudentResult::getScore, Collectors.toList()))
                ));

        grouped.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((subject, scores) -> {
                System.out.println("\t"+subject);
                scores.forEach(score -> System.out.println("\t\t" + score));
            });
        });

        //pouze prumery
        Map<String, Map<String, Double>> averages = results.stream()
                .collect(Collectors.groupingBy(StudentResult::getName,  //prvni mapa, prvni klíč
                        Collectors.groupingBy(StudentResult::getSubject,
                                Collectors.averagingDouble(StudentResult::getScore))
                ));

        averages.forEach((student, subjectScores) -> {
            System.out.println(student);
            subjectScores.forEach((subject, score) ->System.out.println("\t" + subject + ": " + score));
        });

    }
}

class StudentResult {
    String name, subject;
    double score;
    int timeSpent;

    public StudentResult(String name, String subject, double score, int timeSpent) {
        this.name = name;
        this.subject = subject;
        this.score = score;
        this.timeSpent = timeSpent;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public double getScore() {
        return score;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                ", timeSpent=" + timeSpent +
                '}';
    }
}
