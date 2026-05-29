package tretak.finalProcvicovani;

import java.io.IOException;
import java.util.List;

public class MainHub {
    public static List<Sale> sales;
    static List<BasicProduct> products;
    public static void main(String[] args) throws IOException {
        ProductManagement.init();
        DataLoad.init();
    }
}
