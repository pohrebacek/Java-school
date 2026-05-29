package tretak.fileworkss;

public class Movie {
    String name;
    int yearOfRelease;
    double rating;
    int duraiton;

    public Movie(String name, int yearOfRelease, double rating, int duraiton) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.duraiton = duraiton;
    }

    @Override
    public String toString() {
        return name + " (" + yearOfRelease + ")";
    }

    //a vse pro vas potrebne
}
