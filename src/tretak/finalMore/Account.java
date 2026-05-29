package tretak.finalMore;

public interface Account {

    boolean withdraw(double amount);
    void deposit(double amount);
    double getBalance();
}
