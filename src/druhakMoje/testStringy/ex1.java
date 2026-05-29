package testStringy;

public class ex1 {
    public static void main(String[] args) {
        String[] krestni = {"Karel", "Martin", "Pavel", "Kryštof"};
        String[] prijmeni = {"Novotný", "Novák", "Sobotka", "idk"};

        int index = (int)(Math.random() * krestni.length);
        int index2 = (int)(Math.random() * prijmeni.length);

        System.out.println(krestni[index]+" "+prijmeni[index2]);
    }
}
