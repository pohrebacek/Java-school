package objektově_orientovaný_kok;

public class BankAccount {
    String owner;
    double balance;

    void printBalace(){
        System.out.println("Account owner: "+ owner);
        System.out.println("Account balance: "+ balance);
    }

    void deposit(double amount){
        balance += amount;
        System.out.println("Na ucet pribilo: "+ amount);
    }

    void withdraw(double amount){
        if (balance > amount){
            balance -= amount;
            System.out.println("Z uctu bylo vybrano: "+ amount);
        } else {
            System.out.println("Vyber neprobehl, maly zustatek na ucte");
        }

    }


    void transfer(double amount, BankAccount beneficiary){
        if (balance >= amount){
            balance -= amount;
            beneficiary.balance += amount;
        } else {
            System.out.println("prevod neprobehl z duvodu nedostatku financi");
        }
    }

}
