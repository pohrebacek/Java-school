package tretak.oopPolymorphism;

public class HourShop {

    static void callPrint(Clock c){
        c.printTime();
    }
    public static void main(String[] args) {
        HourClock hours = new HourClock();
        hours.seconds = 7700;
        hours.printTime();
        Timer timer = new Timer();
        timer.seconds = 550;
        timer.printTime();

        Clock[] clocks = {timer, hours};
    }
} class HourClock implements Clock{

    int seconds;
    @Override
    public void printTime() {
        //HH:mm:ss
        int hours = seconds / 3600;
        int mins = (seconds % 3600) / 60;
        int secs = seconds % 60;
        System.out.println(hours + ":" + mins + ":" + secs);
    }

    @Override
    public int getTime() {
        return seconds;
    }
}


class Timer implements Clock {
    int seconds;

    @Override
    public void printTime() {
        System.out.println((seconds/60) + ":" + (seconds%60));
    }

    @Override
    public int getTime() {
        return seconds;
    }
}