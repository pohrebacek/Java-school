package BlackJack;

import java.util.Scanner;

public class BlackJack {
    Player player;
    int dealerValue;
    int bet;

    public BlackJack(Player player) {
        this.player = player;
    }

    void setDealerValue() {
        this.dealerValue = (int) (Math.random() * 8 + 13);
    }


    void setBet() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kolik chces vsadit?");
        int input = sc.nextInt();
        while (player.balance < input){
            System.out.println("Zadej castku, kterou si muzes dovolit");
            input = sc.nextInt();
        }
        bet = 2 * input;
        player.balance -= input;
    }
    
    
    void start(){
        setBet();
        setDealerValue();
        System.out.println("CHEAT: " + dealerValue);
        String ask = "";
        Scanner sc = new Scanner(System.in);
        player.PickACard();
        do {
            System.out.println("Pokracovat?");
            ask = sc.nextLine();
            if (!ask.equals("ano")){
                break;
            }
            player.PickACard();
            player.printInfo();
        } while (player.handValue < 21);
        printGameResult();
    }
    
    void printGameResult() {
        System.out.println("Dealer: " + dealerValue);
        System.out.println("Ty máš: "+player.handValue);
        if (player.handValue > 21){
            System.out.println("Hrac prohral");
        } else if (player.handValue == 21) {
            System.out.println("hrac vyhral " + bet);
            player.balance += bet;
        } else if (player.handValue > dealerValue) {
            System.out.println("Hrac vyhral " + bet);
            player.balance += bet;
        }
    }

    public static void main(String[] args) {
        Player p = new Player("Joel", 1000);
        BlackJack blackJack = new BlackJack(p);
        blackJack.start();
    }
    
}
