package edu.eci.dosw.challenge1;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the FrequentCustomerDiscount class.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class FrequentCustomerDiscountTest {
    private final FrequentCustomerDiscount frequentCustomerDiscount = new FrequentCustomerDiscount();

    @Test
    void shouldApplyTheDiscountToAPurchase() {
        List<Product> productList = List.of(
                new Product("T-shirt", 150000),
                new Product("Pants", 100000)
        );

        int discount = frequentCustomerDiscount.discountCalculation(productList);
        assertEquals(25000, discount);
    }

    @Test
    void shouldNotApplyDiscountForNoProducts() {
        List<Product> productList = List.of();

        int discount = frequentCustomerDiscount.discountCalculation(productList);
        assertEquals(0, discount);
    }

}