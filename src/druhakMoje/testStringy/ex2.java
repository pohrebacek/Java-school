package testStringy;

public class ex2 {
    public static void main(String[] args) {
        String věta = "Cau more jak to jde? Idk co sem napsat. Idk co sem napsat! Cau more jak to jde?";
        int count = 0;

        for (int i = 0; i < věta.length(); i++) {
            if (věta.charAt(i) == '.' || věta.charAt(i) == '!' || věta.charAt(i) == '?'){
                count += 1;
            }
        }
        System.out.println(count);
    }
}
