package edu.eci.dosw.challenge1;

import java.util.List;

/**
 * This is the receipt of the customer.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class Receipt {
    private final List<Product> productsList;
    private final int totalPrice;
    private final double finalPayingAmount;

    public Receipt(List<Product> productsList, int totalPrice, double finalPayingAmount) {
        this.productsList = productsList;
        this.totalPrice = totalPrice;
        this.finalPayingAmount = finalPayingAmount;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getFinalPayingAmount() {
        return finalPayingAmount;
    }
}
