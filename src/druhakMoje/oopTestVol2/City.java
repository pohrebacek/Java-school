package oopTestVol2;

public class City {
    String name;
    Geolocation location;

    public City(String name, Geolocation location) {
        this.name = name;
        this.location = location;
    }


    @Override
    public String toString() {
        return name + " ("+location.x+", "+location.y+")";
    }
}
