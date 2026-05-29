package objekty_cvičení;

public class nhsfghsfhgfhdcgh {
    int bottles;
    int balance;

    final int PRICE_PER_SELL = 500; //final znamená že je to konstanta (vlastně const v js)
    final int PRICE_PER_BUY = 250;


    //konstruktor
    public nhsfghsfhgfhdcgh(int bottles, int balance){
        this.bottles = bottles; //to this je že to pracuje s tou vlastností bottles, to druhý je argument
        this.balance = balance;
    }

    void sell(int bottles){
        if (this.bottles < bottles){
            System.out.println("nepodařilo se prodat");
        } else {
            this.bottles -= bottles;
            balance += PRICE_PER_SELL * bottles;
        }


    }

    void buy(int bottles){
        if (balance >= PRICE_PER_BUY * bottles){
            this.balance -= PRICE_PER_BUY * bottles;
            this.bottles += bottles;
        } else {
            System.out.println("nepodařilo se nakoupit");
        }

    }

    void printInfo(){
        System.out.println("Na sklade " + bottles);
        System.out.println("Na ucte " + balance);
    }

}
