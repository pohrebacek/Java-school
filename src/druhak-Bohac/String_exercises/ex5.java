package String_exercises;

public class ex5 {
    public static void main(String[] args) {
        String[] names = {"Jan", "Karel", "František Dlouhojmenný", "Pablo Diego José Francisco de Paula Juan Nepomuceno María de los Remedios Cipriano de la Sanơsima Trinidad Ruiz y Picasso", "Eva"};
        int longest = 0;
        for (int i = 1; i < names.length; i++) {    //longest je nula takže se začíná porovnávat od jedničky
            if ((int)names[longest].length() < (int)names[i].length()){
                longest = i;
            }
        }
        System.out.println(names[longest]);

    }
}
