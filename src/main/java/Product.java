public class Product {

    String productName;
    float productPrice;

    public Product(String productName, float productPrice) {
        this.productName=productName;
        this.productPrice=productPrice;
    }
    public String getProductName() {
        return productName;
    }

    public float getProductPrice() {
        return productPrice;
    }
}
