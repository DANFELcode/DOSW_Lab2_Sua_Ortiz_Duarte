package edu.eci.dosw.challenge2;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the CalculatePrice class.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class CalculatePriceTest {
    @Test
    void shouldIgnoreNegativePrices() {
        List<Ingredient> ingredients = List.of(new Ingredient("Bread", -450),
                new Ingredient("Cheese", 1100));

        int totalPrice = CalculatePrice.calculateTotalPrice(ingredients);
        assertEquals(1100, totalPrice, "The total price should be 1100");
    }
}