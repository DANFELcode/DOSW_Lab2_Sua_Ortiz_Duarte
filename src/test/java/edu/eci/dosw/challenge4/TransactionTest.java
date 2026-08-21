package edu.eci.dosw.challenge4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the Transaction class.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */
public class TransactionTest {

    private Transaction transaction;

    @BeforeEach
    void setUp() {
        transaction = new Transaction(100.0, "USD", 86.0, "EUR");
    }

    @Test
    void shouldReturnOriginalAmount() {
        assertEquals(100.0, transaction.getOriginalAmount());
    }

    @Test
    void shouldReturnSourceCurrency() {
        assertEquals("USD", transaction.getSourceCurrency());
    }

    @Test
    void shouldReturnConvertedAmount() {
        assertEquals(86.0, transaction.getConvertedAmount());
    }

    @Test
    void shouldReturnDestinationCurrency() {
        assertEquals("EUR", transaction.getDestinationCurrency());
    }
}