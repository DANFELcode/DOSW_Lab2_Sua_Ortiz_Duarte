package edu.eci.dosw.challenge5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the CustomTopping class.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */
public class CustomToppingTest {

    private Coffee coffee;

    @BeforeEach
    void setUp() {
        coffee = new SimpleCoffee();
    }

    @Test
    void shouldAddCustomToppingDescription() {
        Coffee customCoffee = new CustomTopping(coffee, "Cinnamon", 800);
        assertEquals("Coffee + Cinnamon", customCoffee.getDescription());
    }

    @Test
    void shouldAddCustomToppingPrice() {
        Coffee customCoffee = new CustomTopping(coffee, "Cinnamon", 800);
        assertEquals(3800, customCoffee.getPrice());
    }
}