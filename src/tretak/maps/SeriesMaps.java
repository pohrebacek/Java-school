package tretak.maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeriesMaps {

    static void printStructure(List<Series> series){
        series.forEach(s -> {
            System.out.println(s.getTitle());

            Map<Integer, List<Episode>> seasonsMap = s.getEpisodes().stream()
                    .collect(Collectors.groupingBy(Episode::getSeason));

            seasonsMap.forEach((season, episode) -> {
                System.out.println("\tS:"+season);
                episode.forEach(e -> System.out.println("\t\t"+e.toString()));
            });

        });
    }

    public static void main(String[] args) throws IOException {
        List<Series> seriesList = Files.lines(Paths.get("inputs\\series.csv"))  //už vrací stream
                .skip(1)
                .map(line -> line.split(";"))
                .map(splitline -> new Series(
                        splitline[0],
                        splitline[1]
                ))
                .toList();

        List<Episode> episodeList = Files.lines(Paths.get("inputs\\episodes.csv"))
                .skip(1)
                .map(line -> line.split(";"))
                .map(parts -> new Episode(
                        Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        Double.parseDouble(parts[2]),
                        parts[3]
                ))
                .toList();


        seriesList.forEach(series -> {  //forEach už zajebe stream sám
            episodeList.stream()
                    .filter(episode -> episode.getEpisodeID().equals(series.getSeriesID()))
                    .forEach(series::addEpisode);
        });

        System.out.println(seriesList);

        //výpis v tree podobě

    }
}

class Series {
    String seriesID;
    String title;
    List<Episode> episodes;

    public Series(String seriesID, String title) {
        this.seriesID = seriesID;
        this.title = title;
        this.episodes = new ArrayList<>();
    }



    void addEpisode(Episode e) {
        this.episodes.add(e);
    }

    public String getSeriesID() {
        return seriesID;
    }

    public String getTitle() {
        return title;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }
}
class Episode {
    String episodeID;   //ono je to spíš id toho seroše ke kterymu to patri
    int episodeNumber;
    double rating;
    int season;

    public Episode(int season, int episodeNumber, double rating, String episodeID) {
        this.episodeID = episodeID;
        this.episodeNumber = episodeNumber;
        this.rating = rating;
        this.season = season;
    }


    @Override
    public String toString() {
        return "S:"+getSeason() + "E"+getEpisodeNumber();
    }
    public String getEpisodeID() {
        return episodeID;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public double getRating() {
        return rating;
    }

    public int getSeason() {
        return season;
    }
}
