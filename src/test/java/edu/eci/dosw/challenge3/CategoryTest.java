package edu.eci.dosw.challenge3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the Category class.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */
public class CategoryTest {

    private Category luxury;

    @BeforeEach
    void setUp() {
        luxury = new Category("Luxury", 1.5, 1.2, "premium package");
    }

    @Test
    void shouldReturnName() {
        assertEquals("Luxury", luxury.getName());
    }

    @Test
    void shouldReturnPriceMultiplier() {
        assertEquals(1.5, luxury.getPriceMultiplier());
    }

    @Test
    void shouldReturnSpeedMultiplier() {
        assertEquals(1.2, luxury.getSpeedMultiplier());
    }

    @Test
    void shouldReturnEquipment() {
        assertEquals("premium package", luxury.getEquipment());
    }
}