import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static int number = 0;
    static List<Product> products = new ArrayList<>();

    public static void addItem(Product product) {
        products.add(product);
        total();
        success(product);
    }

    private static void success(Product product) {
        System.out.println("Товар " + product.productName + " стоимостью " + product.getProductPrice() + " " + Labeling.label(product.getProductPrice()) + " добавлен.");

    }

    static float total() {
        float sum = 0;
        for (Product p : products) {
            sum += p.productPrice;
        }
        return sum;
    }

    public static String printTotal() {
        return total() + " " + Labeling.label(total());
    }

    public static String divided() {
        double d = total() / number;
        NumberFormat formatter = new DecimalFormat("#0.00");
        String formatted = (formatter.format(d));
        return formatted + " " + Labeling.label((float) d);
    }

    public static void printCheck() {
        System.out.println("Добавленные товары:");
        for (Product p : products) {
            System.out.println(p.getProductName() + "    " + p.getProductPrice() + " " + Labeling.label(p.productPrice));
        }
    }

    private static class Labeling {
        public static String label(float productPrice) {
            double f = Math.floor(productPrice);
            int lastCharacter = (int) f % 10;
            String label = "";
            if (lastCharacter == 0 || lastCharacter > 4) {
                label = "рублей";
            } else if (lastCharacter > 1 && lastCharacter < 5) {
                label = "рубля";
            } else if (lastCharacter == 1) {
                label = "рубль";
            }
            return label;
        }
    }
}
