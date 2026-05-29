package tretak.Streaming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieStreaming {
    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("inputs\\movieList.txt"));
            String[] params;
            for (String line: lines) {
                params = line.split(";");
                movies.add(new Movie(params[0], Integer.parseInt(params[1]), params[2], Double.parseDouble(params[3])));
            }

            movies.stream()
                    .filter(movie -> movie.getYear() > 2000)
                    .forEach(System.out::println);

            movies.stream()
                    .sorted(Comparator.comparingDouble(Movie::getRating))
                    .forEach(System.out::println);

            double avgRating = movies.stream()
                    .filter(movie -> movie.genre.equals("Horror"))
                    .mapToDouble(movie -> movie.rating)
                    .average()
                    .orElse(0);

            List<Movie> actionMovies = movies.stream()
                    .filter(movie -> movie.genre.equals("Action") && movie.year > 2000)
                    .distinct() //kdyby náhodou tam byl duplikát
                    .toList();
        } catch (IOException e) {
            System.out.println("Nepodarilo se najit soubor");
            System.out.println(e.getMessage());
        }
    }
}

class Movie {
    String name;
    int year;
    String genre;
    double rating;

    public Movie(String name, int year, String genre, double rating) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}
