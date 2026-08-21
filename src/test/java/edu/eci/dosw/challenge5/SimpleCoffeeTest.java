package edu.eci.dosw.challenge5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the SimpleCoffee class.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */
public class SimpleCoffeeTest {

    @Test
    void shouldReturnBaseDescription() {
        Coffee coffee = new SimpleCoffee();
        assertEquals("Coffee", coffee.getDescription());
    }

    @Test
    void shouldReturnBasePrice() {
        Coffee coffee = new SimpleCoffee();
        assertEquals(3000, coffee.getPrice());
    }
}