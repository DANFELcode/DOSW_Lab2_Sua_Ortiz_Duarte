package edu.eci.dosw.challenge1;

/**
 * The products of the client.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class Product {
    private final String productName;
    private final int price;

    public Product(String name, int price) {
        this.productName = name;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }
}
