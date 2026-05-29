package tretak.finalProcvicovani;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryServices {

    /**
     * Ukazkova metoda pro vypsani a stream dat, pouzivejte promenne products & sales
     */
    static void printInfo(){
        MainHub.products.forEach(System.out::println);
        MainHub.sales.forEach(sale -> System.out.println("platba: " + sale));
    }

    /**
     * Data: Sales
     * @param price cenova hladina
     * @return pocet, kolik prodeju (price * quantity) bylo >= price
     */
    static long getSalesCount(double price){
        return MainHub.sales.stream()
                .filter(sale -> sale.getUnitPrice() * sale.getQuantity() >= price)
                .count();
    }

    /**
     * Data: Sales
     * @return prumerna cena za jednotku napric prodeji
     */
    static double getAverageUnitSale(){
        return MainHub.sales.stream()
                .collect(Collectors.averagingDouble(Sale::getUnitPrice));
    }

    /**
     * Data: Products
     * @param category filtr pro kategorii
     * @return pocet kusu (quantity) produktu, ktere jsou celkem v predane kategorii
     */
    static int getTotalAmount(String category){
        return MainHub.products.stream()
                .filter(product -> product.getCategory().equals(category))
                .mapToInt(p -> p.getQuantity())
                .sum();
    }

    /**
     * Data: Products
     * Vypise do konzole top 5 produktu s nejvetsim poctem kusu v predane kategorii
     * @param category kategorie produktu
     */
static void printTopQuantity(String category){
    MainHub.products.stream()
            .filter(product -> product.getCategory().equals(category))
            .sorted(Comparator.comparingInt(Product::getQuantity).reversed())
            .limit(5)
            .forEach(System.out::println);
}


    /**
     * Data: Products
     * Vypise do konzole, kolik produktu v predane kategorii ma jednotkovou cenu mensi nez parametr
     * @param category kategorie produktu
     * @param limit cenova hladina
     */
static void printCategoryByPrice(String category, double limit){
    long count = MainHub.products.stream()
            .filter(product -> product.getCategory().equals(category))
            .filter(product -> product.getPrice() < limit)
            .count();
    System.out.println("Pocet produktu pod cenou " + limit + " v kategorii " + category + ": " + count);
}


    /**
     * Data: Products
     * Spocita, kolik (Long) typu produktu (tj. ne suma quantity, proste pocet produktu v katalogu)
     * se v datech nachazi dle kategorie (String)
     * @return mapa, kde klic je kategorie, hodnota je pocet produktu v katalogu
     */
static Map<String, Long> getProducts(){
    return MainHub.products.stream()
            .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
}


    /**
     * Data: Products
     * Spocita, kolik (Double) je prumerna cena produktu v kategorii (String)
     * @return mapa, kde klic je kategorie, hodnota je prumerna cena produktu v kategorii
     */
static Map<String, Double> getAvgProductPrice(){
    return MainHub.products.stream()
            .collect(Collectors.groupingBy(
                    Product::getCategory,
                    Collectors.averagingDouble(Product::getPrice)
            ));
}


    /**
     * Zde odkomentovat pro zjisteni hodnot
     */
    public static void init(){

//        System.out.println(getSalesCount(500));
//        System.out.println(getAverageUnitSale());
//        System.out.println(getTotalAmount("Stationery"));
//        printTopQuantity("Electronics");
//        printCategoryByPrice("Electronics", 24.99);
//        System.out.println(getProducts());
//        System.out.println(getAvgProductPrice());
    }
}
