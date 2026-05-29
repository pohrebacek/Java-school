package tretak.fileworkss;
//https://gist.github.com/HonzaBoh/a0cd33af3368749590f82b286d0eb685#file-moviespractice-txt
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Kolekce vsech filmu v playlistu
 */
public class Playlist implements Serializable {
    @Serial
    private static final long serialVersionUID = 42L;

    /**
     * Kolekce vsech filmu v playlistu
     */
    List<Movie> programme;
    /**
     * Jmeno pro playlist filmu
     */
    String name;

    /**
     * Konstruktor pro vytvoreni playlistu rovnou s nejakou sadou filmu
     * @param name nazev pro playlist
     * @param programme pocatecni list, do kteroho lze vkladat
     */
    public Playlist(List<Movie> programme, String name){
        this.name = name;
        this.programme = programme;
    }

    /**
     * Konstruktor pro vytvoreni prazdneho playlistu
     * @param name nazev pro playlist
     */
    public Playlist(String name){
        this.name = name;
        this.programme = new ArrayList<>();
    }



        //Vypise ve formatu: PlaylistName (doba trvani ve formatu mm:ss):
        //
        //                      movie1.toString()...


    @Override
    public String toString() {
        return "Playlist{" +
                "programme=" + programme +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Metoda pro celkove doby trvani ve vterinach
     * @return
     */
    public int getTotalDuration(){
        return 0;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<String> lines = Files.readAllLines(Paths.get("inputs\\MoviesPractice.txt"));
        Movie movie;
        ArrayList<Movie> movies = new ArrayList<>();
        for (String line : lines){
            String[] params = line.split(";");
            movie = new Movie(params[0], Integer.parseInt(params[1]), Double.parseDouble(params[2]), Integer.parseInt(params[3]));
            movies.add(movie);
        }
        System.out.println(movies);

        //pokusí se najít lists, jestli nenajde, udělá vlastní playlist
        File file = new File("lists.ser");
        if (!file.exists()){
            System.out.println("nah");
            List<Movie> setOfMovies = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                int movieIndex = (int) (Math.random() * movies.size()-1);
                if (!setOfMovies.contains(movies.get(movieIndex))){
                    setOfMovies.add(movies.get(movieIndex));
                }
            }
            Playlist playlist = new Playlist(setOfMovies, "default");
            System.out.println(playlist.programme);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lists.ser"));
            oos.writeObject(playlist);
            oos.close();
        } else {
            System.out.println("gut");
            Playlist deserialized = null;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lists.ser"));
            deserialized = (Playlist) ois.readObject();

            System.out.println("Importovano: "+deserialized);
        }

    }
}
