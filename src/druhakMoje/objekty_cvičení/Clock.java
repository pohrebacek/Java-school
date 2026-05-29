package objekty_cvičení;

public class Clock {
    int hours;
    int minutes;
    int seconds;

    boolean format24;

    public Clock(int hours, int minutes, int seconds, boolean format24) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.format24 = format24;
    }


    void tick(){
        seconds++;
        if (seconds == 60){
            minutes++;
            seconds = 0;
        }
        if (minutes == 60){
            hours++;
            minutes = 0;
        }
        if (hours == 24 && format24){
            hours = 0;
        } else if (hours == 13 && !format24) {
            hours = 1;
        }
    }
}
