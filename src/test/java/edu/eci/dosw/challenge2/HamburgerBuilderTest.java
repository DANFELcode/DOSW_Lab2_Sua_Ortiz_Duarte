package edu.eci.dosw.challenge2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Tests for the HamburgerBuilder class.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class HamburgerBuilderTest {
    private HamburgerBuilder hamburgerBuilder;
    private Ingredient bread;
    private Ingredient meat;
    private Ingredient cheese;
    private Ingredient sauces;
    private Ingredient vegetables;

    @BeforeEach
    void setUp() {
        hamburgerBuilder = new HamburgerBuilder();
        bread = new Ingredient("Bread", 1500);
        meat = new Ingredient("Meat", 2000);
        cheese = new Ingredient("Cheese", 1000);
        sauces = new Ingredient("Sauces", 500);
        vegetables = new Ingredient("Vegetables", 300);
    }

    @Test
    void shouldBuildACompleteHamburger() {
        Hamburger hamburger = hamburgerBuilder
                .withBread(bread)
                .withMeat(meat)
                .withCheese(cheese)
                .withSauces(sauces)
                .withVegetables(vegetables)
                .build();

        assertEquals("Bread", hamburger.getBread());
        assertEquals("Meat", hamburger.getMeat());
        assertEquals("Cheese", hamburger.getCheese());
        assertEquals("Sauces", hamburger.getSauces());
        assertEquals("Vegetables", hamburger.getVegetables());
        assertEquals(5300, hamburger.getPrice());
    }

    @Test
    void shouldBuildAnEmptyHamburger() {
        Hamburger hamburger = hamburgerBuilder
                .build();

        assertNull(hamburger.getBread());
        assertNull(hamburger.getMeat());
        assertNull(hamburger.getCheese());
        assertNull(hamburger.getSauces());
        assertNull(hamburger.getVegetables());
        assertEquals(0, hamburger.getPrice());
    }
}