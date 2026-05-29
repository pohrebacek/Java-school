package ctvrtak.PraktickaLite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class TicketHandle {
    static List<SupportTicket> supportTickets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        supportTickets = Files.lines(Paths.get("src\\ctvrtak\\PraktickaLite\\tickets.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(parts -> new SupportTicket(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]), parts[6]))
                .collect(Collectors.toCollection(ArrayList::new));  //při přidání do listu pomocí .add() bez tohohle hází UnsopportedOperationException
        Scanner sc = new Scanner(System.in);


        //sout možností
        String operation = "";
        while (!operation.equals("exit")){
            System.out.println("Vyber možnost zadáním čísla možnosti (1-3). Pro ukončení použij 'exit'. \n" +
                    "1. Vypsat všechny tickety. \n" +
                    "2. Přidat ticket \n" +
                    "3. Vypsat statistiky \n");
            operation = sc.nextLine();

            switch (operation) {
                case ("1"):
                    //vypíše supportTickets
                    supportTickets.forEach(System.out::println);
                    //System.out.println(supportTickets.size());
                    break;
                case ("2"):
                    //spustí GUI pro přidání rezervace
                    new CreateSupportTicket().setVisible(true);
                    break;
                case ("3"):
                    //vypíše stats
                    printStats();
                    break;
            }
        }
        System.out.println("Goodbye :)");

    }

    static void printStats() {
        System.out.println("Tickety za poslední 3 dny:");
        getRecent().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");

        System.out.println("počet ticketů, které byly vytvořeny v 5 hodinách");
        System.out.println(amountin(5));
        System.out.println("-----------------------------------------------------------------");

        System.out.println(" počet ticketů dle jednotlivé kategorie");
        getCategoryTickets();
        System.out.println("-----------------------------------------------------------------");

        System.out.println("kolik procent všech ticketů jsou z oddělení HR");
        System.out.println(getPercentage("HR") + " %");
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Critical tickets od nejstarších");
        getCritical().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");

        System.out.println("kolekce ticketů vůči jednotlivým zaměstnancům");
        System.out.println(employeeTickets());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("kolekce, která drží dvojici Oddělení – průměr hodin od vytvoření");
        System.out.println(dptAverages());
        System.out.println("-----------------------------------------------------------------");
    }


    static List<SupportTicket> getRecent() {
        return supportTickets.stream()
                .filter(t -> t.getCreatedHrsAgo() <= 72)
                .toList();
    }

    static long amountin (int hrs) {
        return supportTickets.stream()
                .filter(t -> t.getCreatedHrsAgo() <= hrs)
                .count();
    }

    static void getCategoryTickets() {
        Map<String, Long> categoryTickets = supportTickets.stream()
                .collect(Collectors.groupingBy(SupportTicket::getCategory, Collectors.counting()));
        System.out.println(categoryTickets);
    }

    static double getPercentage(String dpt) {
        return (double) (supportTickets.stream()
                .filter(t -> t.getDepartment().equals(dpt))
                .count() * 100) / supportTickets.size();
    }

    static List<SupportTicket> getCritical() {
        return supportTickets.stream()
                .filter(t -> t.getPriority().equals("Critical"))
                .sorted(Comparator.comparing(SupportTicket::getCreatedHrsAgo))
                .toList()
                .reversed();
    }

    static Map<String, List<SupportTicket>> employeeTickets() {
        return supportTickets.stream()
                .collect(Collectors.groupingBy(SupportTicket::getEmployeeId)); //, Collectors.toList() nemusí být
    }

    static Map<String, Double> dptAverages() {
        return supportTickets.stream()
                .collect(Collectors.groupingBy(SupportTicket::getDepartment, Collectors.averagingDouble(SupportTicket::getCreatedHrsAgo)));
    }



}
