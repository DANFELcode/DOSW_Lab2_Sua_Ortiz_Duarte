package edu.eci.dosw.challenge2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the HamburgerDecorator class.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class HamburgerDecoratorTest {
    private HamburgerComponent hamburgerComponent;

    @BeforeEach
    void setUp() {
        Hamburger hamburger = new HamburgerBuilder()
                .withBread(new Ingredient("Bread", 2300))
                .withMeat(new Ingredient("Meat", 3000))
                .build();

        hamburgerComponent = new HamburgerBaseComponent(hamburger);
    }

    @Test
    void shouldHaveTheOriginalPriceFromBaseHamburger() {
        assertEquals(5300, hamburgerComponent.getPrice());
    }

    @Test
    void shouldAddAnExtraIngredientAndSumCorrectly() {
        HamburgerComponent decorated = new HamburgerConcreteDecorator(hamburgerComponent, "Bacon", 1200);

        assertEquals("Bread, Meat, Bacon", decorated.getIngredient());
        assertEquals(6500, decorated.getPrice());
    }
}