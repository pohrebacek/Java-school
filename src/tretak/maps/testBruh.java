package tretak.maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class testBruh {

    static double getAverageScore(List<Student> results, String name) {
        return results.stream()
                .filter(student -> student.getName().equals(name))
                .mapToDouble(Student::getScore)
                .average()
                .orElse(0);
    }
    public static void main(String[] args) throws IOException {
        List<Student> students = Files.lines(Paths.get("inputs\\student_scores.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(params -> new Student(
                        params[0],
                        params[1],
                        Double.parseDouble(params[2]),
                        Integer.parseInt(params[3])
                ))
                .toList();
        //System.out.println(students);


        System.out.println(
                students.stream()
                        .map(Student::getName)
                        .distinct()
                        .count()
        );


        Map<String, Long> studentsPerSubject = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getSubject,
                        Collectors.counting()
                ));
        System.out.println(studentsPerSubject);

        Map<String, Double> testTime = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getSubject,
                        Collectors.averagingDouble(Student::getTimeSpent))
                );
        System.out.println(testTime);

        System.out.println(getAverageScore(students, "Fiona Johnson"));



        //Map<String, List<String>> scoreCategories = students.stream()
          //      .map(s -> s.getName())
            //    .collect(Collectors.groupingBy(
              //          student -> {
                //            if (stude ){
//
   //                          }
     //                   }
       //         ));

        //správný řešení
        Map<String, List<String>> scoreCategories = students.stream()
                .map(Student::getName)
                .distinct()
                .collect(Collectors.groupingBy(
                        name -> {
                            double avg = getAverageScore(students, name);
                            if (avg >= 85) return "Best";
                            if (avg >= 65) return "Good";
                            return "Avegrage";

                        },
                        Collectors.toList()
                ));
        System.out.println(scoreCategories);



    }
}

class Student {
    String name, subject;
    double score;
    int timeSpent;

    public Student(String name, String subject, double score, int timeSpent) {
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
