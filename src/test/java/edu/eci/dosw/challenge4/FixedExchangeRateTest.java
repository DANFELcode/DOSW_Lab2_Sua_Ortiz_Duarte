package edu.eci.dosw.challenge4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for the FixedExchangeRate class.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */
public class FixedExchangeRateTest {

    private FixedExchangeRate exchangeRate;

    @BeforeEach
    void setUp() {
        exchangeRate = new FixedExchangeRate();
    }

    @Test
    void shouldReturnOneForSameCurrency() {
        assertEquals(1.0, exchangeRate.getRate("USD", "USD"));
    }

    @Test
    void shouldReturnCorrectRateBetweenTwoCurrencies() {
        Double rate = exchangeRate.getRate("USD", "EUR");
        assertEquals(0.86, rate);
    }

    @Test
    void shouldCalculateIndirectRateBetweenNonUsdCurrencies() {
        Double rate = exchangeRate.getRate("COP", "EUR");
        assertEquals(0.86 / 3130.97, rate, 0.0001);
    }

    @Test
    void shouldThrowExceptionForUnsupportedOrigin() {
        assertThrows(IllegalArgumentException.class, () -> exchangeRate.getRate("XYZ", "USD"));
    }

    @Test
    void shouldThrowExceptionForUnsupportedDestination() {
        assertThrows(IllegalArgumentException.class, () -> exchangeRate.getRate("USD", "XYZ"));
    }
}