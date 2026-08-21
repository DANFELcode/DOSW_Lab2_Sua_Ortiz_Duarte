package edu.eci.dosw.challenge1;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the NewCustomerDiscount class.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class NewCustomerDiscountTest {
    private final NewCustomerDiscount newCustomerDiscount = new NewCustomerDiscount();

    @Test
    void shouldReturnNoDiscountForEmptyProductList() {
        List<Product> productList = List.of();

        int discount = newCustomerDiscount.discountCalculation(productList);
        assertEquals(0, discount);
    }

    @Test
    void shouldApplyDiscountForSingleProduct() {
        List<Product> productList = List.of(new Product("Pants", 30400));

        int discount = newCustomerDiscount.discountCalculation(productList);
        assertEquals(1520, discount);
    }

}