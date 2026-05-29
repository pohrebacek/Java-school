package tretak.maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class anotherMapExam {
    static class Sale {
        String name, pharmacy;
        int pieces, month;
        boolean insurance_paid;

        public Sale(String name, String pharmacy, int pieces, int month, boolean insurance_paid) {
            this.name = name;
            this.pharmacy = pharmacy;
            this.pieces = pieces;
            this.month = month;
            this.insurance_paid = insurance_paid;
        }

        public String getName() {
            return name;
        }

        public String getPharmacy() {
            return pharmacy;
        }

        public int getPieces() {
            return pieces;
        }

        public int getMonth() {
            return month;
        }

        public boolean isInsurance_paid() {
            return insurance_paid;
        }

        @Override
        public String toString() {
            return "Sale{" +
                    "name='" + name + '\'' +
                    ", pharmacy='" + pharmacy + '\'' +
                    ", pieces=" + pieces +
                    ", month=" + month +
                    ", insurance_paid=" + insurance_paid +
                    '}';
        }
    }


    static int soldIn(List<Sale> sales, int from, int to) {
        return sales.stream()
                .filter(sale -> sale.month >= from && sale.month <= to).mapToInt(Sale::getPieces).sum();
    }
    public static void main(String[] args) throws IOException {
        List<Sale> sales = Files.lines(Paths.get("inputs\\meds_sales.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(splitLine -> new Sale(
                        splitLine[0],
                        splitLine[2],
                        Integer.parseInt(splitLine[1]),
                        Integer.parseInt(splitLine[3]),
                        Boolean.parseBoolean(splitLine[4])
                )).toList();
        System.out.println(sales.size());

        //Vytvořte seznam UniqueMeds, do něj uložte pouze unikátní názvy léků.
        List<String> uniqueMeds = sales.stream()
                .map(Sale::getName)
                .distinct()
                .toList();
        System.out.println(uniqueMeds.size());


        //Vytvořte (a vypište) mapy:
        //1. Počet objednávek k lékárně, které hradila pojišťovna
        Map<String, Long> paidByInsurance = sales.stream()
                .filter(sale -> sale.isInsurance_paid())
                .collect(Collectors.groupingBy(Sale::getPharmacy, Collectors.counting()));
        System.out.println(paidByInsurance);

        //2. Počet prodaných kusů léků v lékarně
        Map<String, Long> medsByPharmacy = sales.stream()
                .collect(Collectors.groupingBy(Sale::getPharmacy, Collectors.summingLong(Sale::getPieces)));
        System.out.println(medsByPharmacy);




        //Vytvořte mapování dle vlastní kategorie na kvartální období:
        //Q1: měsíce 1-3
        //Q2: měsíce 4-6
        //Q3: měsíce 7-9
        //Q4: měsíce 10-12
        Map<String, Integer> salesByMonth = sales.stream()
                .collect(Collectors.groupingBy(
                        sale -> {
                            if (sale.month >= 10) return "Q4";
                            if (sale.month >= 9) return "Q3";
                            if (sale.month >= 6) return "Q2";
                            return "Q1";
                        },Collectors.summingInt(Sale::getPieces)
                ));
        System.out.println(salesByMonth);
    }
}
