package oopTestVol2;

public class Geolocation {
    double x;
    double y;

    public Geolocation(double x, double y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
