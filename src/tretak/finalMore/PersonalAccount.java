package tretak.finalMore;

public class PersonalAccount implements Account{
    int accountId;
    String owner;
    double balance;

    public PersonalAccount(int accountId, String owner, double balance) {
        this.accountId = accountId;
        this.owner = owner;
        this.balance = balance;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
