package edu.eci.dosw.challenge1;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the ReceiptOperations class.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class ReceiptOperationsTest {
    private final FrequentCustomerDiscount frequentCustomerDiscount = new FrequentCustomerDiscount();

    @BeforeEach
    void setUp() {

    }

    @Test
    void shouldCalculateTotalPrice() {
        ReceiptOperations receiptOperations = new ReceiptOperations(new FrequentCustomerDiscount());

        List<Product> productList = List.of(
                new Product("T-shirt", 100000),
                new Product("Cookies", 600),
                new Product("Pants", 30000)
        );

        int totalPrice = receiptOperations.calculateTotalPrice(productList);
        assertEquals(130600, totalPrice);
    }

    @Test
    void shouldCalculateFinalAmountToPay() {
        ReceiptOperations receiptOperations = new ReceiptOperations(new FrequentCustomerDiscount());

        int finalAmount = receiptOperations.calculateFinalAmount(49050, 3000);
        assertEquals(46050, finalAmount);
    }

}