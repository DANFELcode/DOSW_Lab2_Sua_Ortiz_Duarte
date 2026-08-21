package edu.eci.dosw.challenge4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for the RateSwitcher class.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */
public class RateSwitcherTest {

    private RateSwitcher rateSwitcher;

    @BeforeEach
    void setUp() {
        rateSwitcher = new RateSwitcher(new FixedExchangeRate());
    }

    @Test
    void shouldConvertToSingleDestination() {
        Transaction transaction = rateSwitcher.convert(100.0, "USD", "EUR");
        assertEquals(100.0, transaction.getOriginalAmount());
        assertEquals("USD", transaction.getSourceCurrency());
        assertEquals(86.0, transaction.getConvertedAmount());
        assertEquals("EUR", transaction.getDestinationCurrency());
    }

    @Test
    void shouldConvertToMultipleDestinations() {
        List<Transaction> results = rateSwitcher.convert(100.0, "USD", List.of("EUR", "JPY"));
        assertEquals(2, results.size());
        assertEquals("EUR", results.get(0).getDestinationCurrency());
        assertEquals("JPY", results.get(1).getDestinationCurrency());
    }

    @Test
    void shouldThrowExceptionForInvalidCurrency() {
        assertThrows(IllegalArgumentException.class, () -> rateSwitcher.convert(100.0, "USD", "XYZ"));
    }
}