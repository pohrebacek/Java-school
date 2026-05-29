package tretak.maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SongProcessing {
    static class Track {
        String name;
        int duration;

        public Track(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }

        public String getName() {
            return name;
        }

        public int getDuration() {
            return duration;
        }
    }

    static class Album {
        String name;
        List<Track> songs;
        int id;

        public Album(String name, List<Track> songs) {
            this.name = name;
            this.songs = songs;
        }

        public Album(String name, int id) { //novej konstruktor protože??
            this.name = name;
            this.id = id;   //id přidam jenom tady protože nejdřív je to prázdný tak tomu to id dam na začátku
            this.songs = new ArrayList<>();
        }

        void addSong(Track toAdd) {
            this.songs.add(toAdd);
        }

        public String getName() {
            return name;
        }

        public List<Track> getSongs() {
            return songs;
        }
    }

    static class Artist {
        int id;
        String name;
        List<Album> albums;

        public Artist(String name, List<Album> albums) {
            this.name = name;
            this.albums = albums;
        }

        public Artist(int id, String name) {
            this.name = name;
            this.id = id;
            this.albums = new ArrayList<>();
        }

        void addAlbum(Album toAdd) {
            this.albums.add(toAdd);
        }

        public String getName() {
            return name;
        }

        public List<Album> getAlbums() {
            return albums;
        }

        public int getId() {
            return id;
        }
    }

    public static void main(String[] args) throws IOException {
        //Load & Parse
        //podle toho co načtu prvně tak tomu přidam id z toho datasetu -> všechno první chce id
        List<Artist> bands = Files.lines(Paths.get("inputs\\songs\\artists.csv"))
                .skip(1)
                .map(line -> line.split(";"))
                .map(splitLine -> new Artist(
                        Integer.parseInt(splitLine[0]),
                        splitLine[1]
                )).toList();

    }
}
