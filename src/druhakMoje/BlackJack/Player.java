package BlackJack;

public class Player {
    String name;
    int balance;
    int handValue;

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    void PickACard(){
        int[] values = {1,2,3,4,5,6,7,8,9,10,10,10,10};
        int randomIndex = (int) (Math.random() * values.length);
        int randomValue = values[randomIndex];
        System.out.println("Liznul sis "+randomValue);
        handValue += randomValue;
    }

    void printInfo(){
        System.out.println("V ruce drzis " + handValue);
    }

}
