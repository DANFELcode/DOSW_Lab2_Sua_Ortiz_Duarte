package edu.eci.dosw.challenge1;

import java.util.List;

/**
 * Class that has the discount for the frequent customer (10% discount).
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class FrequentCustomerDiscount implements DiscountInterface {
    @Override
    public int discountCalculation(List<Product> products) {
        int discount = products.stream().mapToInt(Product::getPrice).sum();
        return (int) (discount * 0.10);
    }
}
