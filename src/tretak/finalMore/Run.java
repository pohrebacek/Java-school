package tretak.finalMore;

import java.io.IOException;

public class Run {
    public static void main(String[] args) throws IOException {
        TransactionService.loadAccounts("inputs\\final\\accounts.csv");
        TransactionService.loadTransactions("inputs\\final\\transactions.csv");
        TransactionService.processTransactions();
        TransactionService.printReport();
    }
}
