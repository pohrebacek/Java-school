package Reference;

public class BankAccount {
    double balance;
    long bankID;
    Person owner;

    public BankAccount(double balance, long bankID, Person owner) {
        this.balance = balance;
        this.bankID = bankID;
        this.owner = owner;
    }

    void deposit(double amount){
        balance += amount;
    }

    boolean withdraw(double amount){
        if (balance >= amount){
            balance -= amount;
            return true;
        }
        System.out.println("Uživatel "+owner.name+" nemohl vybrat peníze");
        return false;
    }

    boolean transaction(double amount, BankAccount other){
        if (withdraw(amount)){
            other.deposit(amount);
            return true;
        }
        System.out.println("nefacha");
        return false;
    }

    public static void main(String[] args) {
        Person p1 = new Person("kokot", "v prdeli");
        Person p2 = new Person("Radim", "most");

        BankAccount account1 = new BankAccount(40000, 2131, p1);
        BankAccount account2 = new BankAccount(20000, 168561861, p2);
        account1.withdraw(20000);
        if (account1.transaction(50000,account2)){
            System.out.println("penize prevedeny");
        }





    }








}
