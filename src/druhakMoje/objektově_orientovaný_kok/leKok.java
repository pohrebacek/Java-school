package objektově_orientovaný_kok;

public class leKok {
    public static void main(String[] args) {
        KFC_people dream = new KFC_people();
        dream.name = "Dream on";
        dream.author = "Aerosmith";
        dream.yearOfRelease = 1973;
        dream.rating = 9.8;

        System.out.println("Nazev: "+dream.name);
        dream.printInfo();
    }
}
