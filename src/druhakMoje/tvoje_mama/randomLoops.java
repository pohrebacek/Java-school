package tvoje_mama;

public class randomLoops {
    public static void main(String[] args) {
        //vygeneruj dvě (020) random čísla, vypiš na kolikatej pokus byly shodný
        int num1 = (int)(Math.random()*21);
        int num2 = (int)(Math.random()*21);
        int tries = 1;
        System.out.println(num1+", "+num2);
        while (num2 != num1){
            num1 = (int)(Math.random()*21);
            num2 = (int)(Math.random()*21);
            System.out.println(num1+", "+num2);
            tries++;
        }
        System.out.println("Trvalo to "+tries+" pokusů");

        //generuje 100x dvě random čísla (0-20), vypiš kolikrát byly shodný
        System.out.println("----------------------------");
        int counter = 0;
        for (int i = 0; i < 100; i++) {
            num1 = (int)(Math.random()*21);
            num2 = (int)(Math.random()*21);
            System.out.println(num1+", "+num2);
            if (num1 == num2){
                counter++;
            }
        }
        System.out.println("totožná čísla padla "+counter+" x");
    }
}
