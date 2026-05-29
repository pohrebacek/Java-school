package tretak.Streaming;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Payment {
    private String transactionId;
    private String userId;
    private double amount;
    private LocalDateTime transactionDate;
    private String paymentMethod;
    private String status;
    private String category;

    public Payment(String transactionId, String userId, double amount, LocalDateTime transactionDate, 
                   String paymentMethod, String status, String category) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.category = category;
    }

    public String getTransactionId() { return transactionId; }
    public String getUserId() { return userId; }
    public double getAmount() { return amount; }
    public LocalDateTime getTransactionDate() { return transactionDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getStatus() { return status; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("Payment{ID=%s, User=%s, Amount=%.2f, Date=%s, Method=%s, Status=%s, Category=%s}",
                transactionId, userId, amount, transactionDate, paymentMethod, status, category);
    }

    public static List<Payment> generateSamplePayments(int count) {
        Random random = new Random();
        List<String> users = Arrays.asList("U001", "U002", "U003", "U004", "U005");
        List<String> paymentMethods = Arrays.asList("Credit Card", "Debit Card", "PayPal", "Bank Transfer");
        List<String> statuses = Arrays.asList("Completed", "Pending", "Failed");
        List<String> categories = Arrays.asList("Groceries", "Entertainment", "Utilities", "Travel", "Shopping");

        return IntStream.range(0, count).mapToObj(i -> new Payment(
                "TXN" + (1000 + i),
                users.get(random.nextInt(users.size())),
                10 + (500 * random.nextDouble()),
                LocalDateTime.now().minusDays(random.nextInt(30)),
                paymentMethods.get(random.nextInt(paymentMethods.size())),
                statuses.get(random.nextInt(statuses.size())),
                categories.get(random.nextInt(categories.size()))
        )).collect(Collectors.toList());
    }
}

public class PaymentDataGenerator {
    public static void main(String[] args) {
        List<Payment> payments = Payment.generateSamplePayments(100);
        payments.forEach(System.out::println);

        //vypsat vsechny completed platby
        System.out.println("vypsat vsechny completed platby");
        payments.stream()
                .filter(payment -> payment.getStatus().equals("Completed"))
                .forEach(System.out::println);

        //vypsat veschny platby ve vysi alespon 200 a seradit dle data
        System.out.println("vypsat veschny platby ve vysi alespon 200 a seradit dle data");
        payments.stream()
                .filter(payment -> payment.getAmount() >= 200)
                .sorted(Comparator.comparing(Payment::getTransactionDate))
                .forEach(System.out::println);

        //vypsat prumernou vysi platby od uzivatele 003
        System.out.println("vypsat prumernou vysi platby od uzivatele 003");
        double avgBruh = payments.stream()
                .filter(payment -> payment.getUserId().equals("U003"))
                .mapToDouble(payment -> payment.getAmount())
                .average()
                .orElse(0);
        System.out.println(avgBruh);

        //vypsat celkovy pocet plateb od 003
        System.out.println("vypsat celkovy pocet plateb od 003");
        System.out.println(payments.stream()
                .filter(payment -> payment.getUserId().equals("U003"))
                .count());

        //vypsat celkovy soucet vsech plateb v kategorii entertainment
        System.out.println("vypsat celkovy soucet vsech plateb v kategorii entertainment");
        System.out.println(
                payments.stream()
                        .filter(payment -> payment.getCategory().equals("Entertainment"))
                        .count()
        );
        //vypsat celkovou sumu ktera je pending za posledni tyden
        System.out.println(
                payments.stream()
                        .filter(payment -> payment.getStatus().equals("Pending"))
                        .filter(payment -> payment.getTransactionDate().isAfter(LocalDateTime.now().minusDays(7)))
                        .mapToDouble(Payment::getAmount)        //vezme amount z každé platby, Pro každý objekt třídy Payment zavolej metodu getAmount() a vrať její výsledek.
                        .sum()
        );

        //statistiky k platbám
        //na gitu


        //Top 3 uživatelé dle útraty
        Map<String, Double> topSpendingUsers = payments.stream()
                .collect(Collectors.groupingBy(
                        Payment::getUserId,
                        Collectors.summingDouble(Payment::getAmount)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("----------------------------------------");
        System.out.println("top 3: " + topSpendingUsers);


        //nejpopulárnější platební metoda uživatelů kteří utratí aplespoň 200
        String mostPopularPaymentMethod = payments.stream()
                .filter(payment -> payment.getAmount() >= 200) // 1️⃣ Filtrované platby (pouze ty s částkou 200+)
                .collect(Collectors.groupingBy(Payment::getPaymentMethod, Collectors.counting())) // 2️⃣ Počet plateb podle metody
                .entrySet().stream() // 3️⃣ Převod mapy na stream (abychom mohli hledat max)
                .max(Map.Entry.comparingByValue()) // 4️⃣ Najdeme záznam s nejvyšším počtem plateb (hodnoty)
                .map(Map.Entry::getKey) // 5️⃣ Získáme jen název metody platby (ne celý záznam)
                .orElse("NELZE URČIT"); // 6️⃣ Pokud žádná metoda nevyhovuje, vrátíme výchozí hodnotu


        System.out.println("-----------------------------------------------------------------------");
        System.out.println(mostPopularPaymentMethod);


        //vlastni kategorie: dnes, v tydnu, posledni mesic
        LocalDate today = LocalDate.now();
        //Map<String, List<Payment>> timePayments = payments.stream()
        //        .collect(Collectors.groupingBy(payment -> {
        //            LocalDate dateOfTransaction = payment.getTransactionDate().toLocalDate();
        //            if (dateOfTransaction.isEqual(today)){
        //                return "today";
        //            }
        //        }))

    }



}
