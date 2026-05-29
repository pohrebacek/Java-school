package tretak.finalMore;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {

    public static List<Transaction> transactions = new ArrayList<>();
    public static List<PersonalAccount> accounts = new ArrayList<>();


    public static void loadAccounts(String filePath) {
        try {
            accounts = Files.lines(Paths.get(filePath))
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(params -> new PersonalAccount(
                            Integer.parseInt(params[0]),
                            params[1],
                            Double.parseDouble(params[2])
                    ))
                    .toList();
        } catch (IOException e) {
            System.out.println("Soubor nenalezen");
        }

    }
    public static void loadTransactions(String filePath){
        try {
            transactions = Files.lines(Paths.get(filePath))
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(params -> new Transaction(
                            params[0],
                            params[1],
                            params[2],
                            Double.parseDouble(params[3])
                    ))
                    .toList();
        } catch (IOException e) {
            System.out.println("Soubor nenalezen");
        }
    }

    public static boolean transfer(PersonalAccount from, PersonalAccount to, double amount){
        if (from.withdraw(amount)) {
            to.deposit(amount);
            return true;
        }
        return false;
    }
    public static void processTransactions() throws IOException {
        for (Transaction transaction : transactions) {
            if (transaction.getType().equals("transfer")) {
                PersonalAccount from = null;
                PersonalAccount to = null;
                for (PersonalAccount account : accounts) {
                    if (transaction.getFromAccount() == account.getAccountId()) {
                        from = account;
                    } else if (transaction.getToAccount() == account.getAccountId()) {
                        to = account;
                    }
                }
                if (from == null || to == null) {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("outputs\\invalids.txt"));
                    bw.write(transaction.toString() + "  NONEXISTENT ACCOUNT");
                    bw.newLine();
                    bw.close();
                } else if (!transfer(from, to, transaction.getAmount())) {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("outputs\\invalids.txt"));
                    bw.write(transaction.toString() + " INSUFFICIENT FUNDS");
                    bw.newLine();
                    bw.close();
                }
            }
        }
    }
    public static void printReport(){
        System.out.println("Účtů registrováno: " + accounts.size());

        double bankBalance = accounts.stream()
                .mapToDouble(PersonalAccount::getBalance)
                .sum();
        System.out.println("Celkové množství peněz v bance: " + bankBalance);

        System.out.println(
                accounts.stream()
                        .collect(Collectors.groupingBy(
                                PersonalAccount::getOwner,
                                Collectors.summingDouble(PersonalAccount::getBalance)))
        );
    }


}
