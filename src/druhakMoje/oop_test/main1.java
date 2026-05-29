package oop_test;

public class main1 {
    public static void main(String[] args) {
        Slotmachine casino = new Slotmachine(10000);
        casino.bet(5000);
        casino.getBalance();
        casino.loan(1500);
        casino.getBalance();
    }
}
