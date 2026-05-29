package tretak.maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenreMapping {

    static ArrayList<Movie> loadData(String path){
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            ArrayList<Movie> movies = new ArrayList<>();

            String[] params;
            for (String line : lines) {
                params = line.split(";");
                movies.add(new Movie(params[0], Integer.parseInt(params[1]), params[2], Double.parseDouble(params[3])));
            }
            return movies;
        } catch (IOException e) {
            System.out.println("Error data load: " + e.getMessage());
            return null;
        }

    }
    public static void main(String[] args) {
        ArrayList<Movie> movies = loadData("inputs\\movieList.txt");

        HashMap<String, List<Movie>> genreMap = new HashMap<>();

        for (Movie movie : movies) {
            if (genreMap.containsKey(movie.getGenre())) {
                genreMap.get(movie.getGenre()).add(movie);
            } else {    //ten žánr tam ještě neni
                ArrayList<Movie> newGenre = new ArrayList<>();
                newGenre.add(movie);
                genreMap.put(movie.getGenre(), newGenre);
            }
        }



        for (String genre : genreMap.keySet()) {
            System.out.println(genre + ":");
            for (Movie movie : genreMap.get(genre)) {
                System.out.println("|-" + movie);
            }
        }

        //mapa zanr - seznam nazvu filmu
        Map<String, List<String>> alt = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre,
                        Collectors.mapping(Movie::getName, Collectors.toList())));

        //zjednodušený kod pro vytvoření naplnění HashMap genreMap -> mapa zanr - filmy jako celek
        Map<String, List<Movie>> alsoAnother = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre)); //rozdělí filmy do skupin podle žánru, u každého žádndu bude list objektů Movie

        for(String genre : genreMap.keySet()) {
            System.out.println("Genre: ");
            double average = genreMap.get(genre).stream()
                    .mapToDouble(Movie::getRating)
                    .average()
                    .orElse(0);
            System.out.println("Average: " + average);
        }

        //nebo
        Map<String, Double> avgRatingGenre = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.averagingDouble(Movie::getRating))); //Rozdělí průměrný rating podle žánru, u každého ážnru bude jeho avg rating
        System.out.println(avgRatingGenre);

        //ekvivalentni postup
        //na gitu


        Map<String, List<Movie>> ratingCategories = movies.stream()
                .collect(Collectors.groupingBy(
                        movie -> {
                            if (movie.getRating() < 5){
                                return "Bad";
                            } else if (movie.getRating() < 7.5) {
                                return "Good";
                            } else {
                                return "Great";
                            }
                        }
                ));
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
