package edu.eci.dosw.challenge1;

import java.util.List;

/**
 * Class that calculates the total price, discount and final amount to pay.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class ReceiptOperations {
    private DiscountInterface discount;

    public ReceiptOperations(DiscountInterface discount) {
        this.discount = discount;
    }

    public int calculateTotalPrice(List<Product> products) {
        return products.stream().mapToInt(Product::getPrice).sum();
    }

    public int calculateClientDiscount(List<Product> products) {
        return discount.discountCalculation(products);
    }

    public int calculateFinalAmount(int totalPrice, int discount) {
        return totalPrice - discount;
    }
}