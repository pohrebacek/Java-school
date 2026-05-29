package tretak.oopPolymorphism;

import java.util.ArrayList;
import java.util.Comparator;

import fileworks.DataImport;

public class testBruh {
    public static void main(String[] args) {
        ArrayList<Movie2> movies = new ArrayList<>();
        DataImport di = new DataImport("Movies.txt");
        String line;
        String[] info;
        while (di.hasNext()) {
            line = di.readLine();
            info = line.split(";");
            Movie2 movie = new Movie2(info[0],
                    Integer.parseInt(info[1]),
                    Double.parseDouble(info[2]),
                    Integer.parseInt(info[3])
            );
            movies.add(movie);
        }
        di.finishImport();
        movies.sort(Movie2.BY_NAME);
        System.out.println("By name: ");
        System.out.println(movies);
        movies.sort(Movie2.BY_YEAR_OF_RELEASE.reversed());
        System.out.println("By year of release: ");
        System.out.println(movies);
        movies.sort(Movie2.BY_RATING.reversed());
        System.out.println("By rating TOP 10: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(movies.get(i));
        }

    }

}

class Movie2 {
    String name;
    int yearOfRelease;
    double rating;
    int duration;

    public Movie2(String name, int yearOfRelease, double rating, int duration) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "\n"+name+";"+yearOfRelease+";"+rating+";"+duration;
    }

    static final Comparator<Movie2> BY_NAME = new Comparator<Movie2>() {

        @Override
        public int compare(Movie2 o1, Movie2 o2) {
            return o1.name.compareTo(o2.name);
        }
    };

    static final Comparator<Movie2> BY_YEAR_OF_RELEASE = new Comparator<Movie2>() {

        @Override
        public int compare(Movie2 o1, Movie2 o2) {
            return Integer.compare(o1.yearOfRelease, o2.yearOfRelease);
        }
    };

    static final Comparator<Movie2> BY_RATING = new Comparator<Movie2>() {

        @Override
        public int compare(Movie2 o1, Movie2 o2) {
            return Double.compare(o1.rating, o2.rating);
        }
    };
}
