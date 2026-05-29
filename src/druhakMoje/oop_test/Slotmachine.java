package oop_test;

public class Slotmachine {
    int balance;
    double debt = 0;

    public Slotmachine(int balance) {
        this.balance = balance;
    }

    void bet(int money){
        if (balance > 150){
            balance -= 150;
            int num1 = (int)(Math.random() * 7 + 1);
            int num2 = (int)(Math.random() * 7 + 1);
            int num3 = (int)(Math.random() * 7 + 1);

            if (num2 == num1 && num3 == num1){
                System.out.println("VÝHRA!");
                balance += 1500;
            } else {
                System.out.println("prohra");
            }
        } else {
            System.out.println("Nemáte dostatek peněz");
        }
    }


    void getBalance(){
        System.out.println("Balance: " + balance);
        System.out.println("Debt: " + debt);
    }

    void loan(int money){
        balance += money;
        debt += money*1.5;
    }

}
