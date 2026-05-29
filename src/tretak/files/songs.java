package tretak.files;

import fileworks.DataExport;
import fileworks.DataImport;

public class songs {
    public static void main(String[] args) {
        DataImport di = new DataImport("Tracks.txt");
        DataExport de = new DataExport("exportedTracks.txt");
        String line;
        String[] params;
        Song s;
        while (di.hasNext()){
            line = di.readLine();
            params = line.split(";");
            s = new Song(params[0], Integer.parseInt(params[1]), Double.parseDouble(params[1]), Integer.parseInt(params[3]));
            de.writeLine(s.toString());
            System.out.println(s);
        }

        de.finishExport();
        di.finishImport();
    }
}


class Song{
    String name;
    int year;
    double rating;
    int seconds;

    public Song(String name, int year, double rating, int seconds) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", seconds=" + seconds +
                '}';
    }

    String timeFormat(){
        return (seconds/60) + ":" + seconds%60;
    }
}
