package tretak.oopPolymorphism;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Hlavni trida pro ukol, pouziva pomocne rozhrani a dve tridy umistene v souboru
 * Trida TextMSG je pro ukazku, funkcionalitu doplnujete zde (GreatTale) a do Tridy {@code Book}
 */
public class GreatTale {

    /**
     * Tato metoda by mela zvladnout praci s TextMsg i Book
     */
    //static int wordCount(Object o){
    //    String[] words;
    //    if (o instanceof TextMsg) {
    //        words = ((TextMsg) o).text.split(" ");
    //        return words.length;
    //    } else {
    //        words = ((Book) o).getText().split(" ");
    //        return words.length+((Book) o).pages.size()-1;
    //    }
    //}

    static int wordCount(Readable toCount) {
        String read = toCount.getText();
        return  read.split(" ").length;
    }

    static void init(){
        ArrayList<String> LOTR = new ArrayList<>();
        LOTR.add("One Ring to rule them all."); //stranka #1
        LOTR.add("Folk takes their peril with them into Lorien.");
        LOTR.add("Hinder me? Thou fool. No living man may hinder me!");
        LOTR.add("Don’t the great tales never end?"); //stranka #4

        TextMsg msg = new TextMsg("Johnny", "27-06-2003", "Oh, Hi Mark!");
        Book LordOTR = new Book("Lord of the rings", "J. R. R. Tolkien", "29-07-1968", 243, LOTR);
        Book LordOfTheRings = new Book("Lord of the rings", "John Ronald Reuel Tolkien", "29-07-1968", 243, LOTR);
        System.out.println(LordOTR.equals(LordOfTheRings));//melo by vratit True, maji stejne knizni ID (IBM)

        System.out.println("Wordcount for LOTR: "  + wordCount(LordOTR));
        System.out.println("Wordcount for Msg: " + wordCount(msg));
        System.out.println("LOTR read:");
        LordOfTheRings.read();
        //System.out.println(LordOfTheRings.getText());

        System.out.println("Message read:");
        msg.read();
    }

    public static void main(String[] args) {
        init();
    }


}
interface Readable {
    void read();

    String getText();

}

/**
 * Zde je vas ukol pro implementaci dle zadani
 */
class Book implements Readable{
    String name;
    String author;
    String releaseDate;
    int IBM;
    ArrayList<String> pages;

    public Book(String name, String author, String releaseDate, int IBM, ArrayList<String> pages) {
        this.name = name;
        this.author = author;
        this.releaseDate = releaseDate;
        this.IBM = IBM;
        this.pages = pages;
    }

    @Override
    public void read() {
        System.out.println(this.name+"by"+this.author);
        for (int i = 1; i < this.pages.size()+1; i++) {
            System.out.println(i+"/"+this.pages.size());
            System.out.println(this.pages.get(i-1));
        }
    }

    @Override
    public String getText() {
        String text = "";
        for (int i = 0; i < this.pages.size(); i++) {
            text += this.pages.get(i) + "\n"; //nebo .append
        }
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return IBM == book.IBM;
    }

    @Override
    public int hashCode() {
        return Objects.hash(IBM);
    }
}

class TextMsg  implements Readable, Comparable<TextMsg>{
    String sender;
    String date;
    String text;


    public TextMsg(String sender, String date, String text) {
        this.sender = sender;
        this.date = date;
        this.text = text;
    }

    @Override
    public int compareTo(TextMsg o) {
        String another = o.sender;
        return this.sender.compareTo(another);
    }

    @Override
    public void read() {
        System.out.println("Message received " + date);
        System.out.println(sender + " wrote: ");
        System.out.println(text);
    }

    @Override
    public String getText() {
        return this.text;

    }
}
