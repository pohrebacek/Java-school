package tretak.finalProcvicovani;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataLoad {

    static void loadProducts(String path) throws IOException {
        //kdyby tam neco bylo, tak to vynulujeme
        MainHub.products = new ArrayList<>();
        //Sem nyni pridavejte nove BasicProducts, ktere nactete
        MainHub.products = Files.lines(Paths.get("inputs\\finalProcvicovani\\products.txt"))
                .map(line -> line.split(","))
                .map(params -> new BasicProduct(
                        params[0],
                        params[1],
                        Integer.parseInt(params[2]),
                        Double.parseDouble(params[3])
                ))
                .toList();
    }

    static void cleanSales(String path) throws IOException {
        File directory = new File(path);
        ArrayList<File> salesFiles = new ArrayList<>();
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.toString().startsWith("sales") && file.toString().startsWith(".txt")) {
                    salesFiles.add(file);
                }
            }
        }

        StringBuilder cleanSales = new StringBuilder(" ");
        for (File salesFile : salesFiles) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(salesFile));
            if (!bufferedReader.readLine().startsWith("!") || !bufferedReader.readLine().startsWith("customerName")) {
                cleanSales.append(bufferedReader.readLine()+"\n");
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("outputs\\cleanData.txt"));
        bw.write(String.valueOf(cleanSales));
        bw.newLine();
        bw.close();
    }

    static void loadSales(String path) throws IOException {
        //kdyby tam neco bylo, tak to vynulujeme
        MainHub.sales = new ArrayList<>();
        //Sem nyni pridavejte nove Sales, ktere nactete
        MainHub.sales = Files.lines(Paths.get("inputs\\finalProcvicovani\\products.txt"))
                .map(line -> line.split(","))
                .map(params -> new Sale(
                        params[0],
                        params[1],
                        Integer.parseInt(params[2]),
                        Double.parseDouble(params[3])
                ))
                .toList();

    }


    /**
     * Metoda, ktera otestuje spravnost vaseho reseni, pokud odkomentovany kod
     * funguje dle zadani, mate ukol splneny.
     */
    static void init() throws IOException {
        //otestovani, zda se nacetlo spravne mozstvi vseho:
        loadProducts("inputs\\finalProcvicovani\\products.txt");
        cleanSales("inputs\\finalProcvicovani");
        loadSales("inputs\\finalProcvicovani\\cleanData.txt");
        //Produktu je 50 a prodeju 300
        System.out.println("Loaded Products: " + MainHub.products.size());
        System.out.println("Loaded sales: " + MainHub.sales.size());
    }
}

/**
 * Trida reprezentujici prodej produktu nejakemu zakaznikovi
 */
class Sale {
    /** zakaznik **/
    String recipient;
    /** nazev produktu **/
    String product;
    /** pocet prodanych kusu **/
    int quantity;
    /** cena za kus **/
    double unitPrice;

    public Sale(String recipient, String product, int quantity, double unitPrice) {
        this.recipient = recipient;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}

