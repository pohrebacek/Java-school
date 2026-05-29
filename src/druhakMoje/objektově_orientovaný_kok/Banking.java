package objektově_orientovaný_kok;

public class Banking {
    public static void main(String[] args) {
        BankAccount fanda = new BankAccount();
        fanda.balance = 5000;
        fanda.owner = "Franta";
        //fanda.printBalace();
        //fanda.deposit(5500.50);
        //fanda.printBalace();
//
        //fanda.withdraw(2000);
        //fanda.withdraw(999999);

        BankAccount pepa = new BankAccount();
        pepa.owner = "Pepa";
        pepa.balance = 1234;

        fanda.transfer(500, pepa);
        fanda.printBalace();
    }
}
