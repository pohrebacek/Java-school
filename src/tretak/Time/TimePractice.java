package tretak.Time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimePractice {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime lessonStart = LocalTime.of(9,50); //automaticky nepíše sekundy pokud jsou 0
        System.out.println(lessonStart);

        LocalTime from = LocalTime.from(lessonStart);   //vezme obecny casovy format a prevede na HH:MM(:SS)
        System.out.println(from);

        LocalTime constants = LocalTime.NOON;
        System.out.println(constants);

        //kolik uplynulo času od zacatku hodiny
        System.out.println(time.toSecondOfDay() - lessonStart.toSecondOfDay());
        System.out.println(time.minusSeconds(lessonStart.toSecondOfDay()));

        System.out.println(Duration.between(from, time));


        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(LocalDateTime.of(2025,1,31,2,50));


    }
}
