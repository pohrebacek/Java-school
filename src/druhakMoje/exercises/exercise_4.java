package exercises;

public class exercise_4 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 100000; i++) {
            int randInt = (int) (Math.random() * 100 + 1); //čísla od 1 do 100
            System.out.println(randInt);
            if (randInt == 42){
                count = count+1;
            }
        }
        System.out.println("Číslo 42 padlo "+(count)+" krát.");
    }
}
