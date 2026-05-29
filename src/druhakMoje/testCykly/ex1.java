package testCykly;

public class ex1 {
    public static void main(String[] args) {
        int hp = 1500;
        int dmg = (int) (Math.random() * 1.5 + 100);
        int count = 1;
        while (hp > 0){
            hp -= dmg;
            System.out.println(count+". útok byl za "+dmg);
            count++;
            dmg = (int) (Math.random() * 1.5 + 100);
        }
        System.out.println("Postava byla zabita za "+count+" útoků");
    }
}
