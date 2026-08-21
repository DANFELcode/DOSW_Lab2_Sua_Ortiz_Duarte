package edu.eci.dosw.challenge5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the ToppingDecorator subclasses.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */
public class ToppingDecoratorTest {

    private Coffee coffee;

    @BeforeEach
    void setUp() {
        coffee = new SimpleCoffee();
    }

    @Test
    void shouldAddMilkTopping() {
        Coffee milkCoffee = new MilkTopping(coffee);
        assertEquals("Coffee + Milk", milkCoffee.getDescription());
        assertEquals(4000, milkCoffee.getPrice());
    }

    @Test
    void shouldAddChocolateTopping() {
        Coffee chocolateCoffee = new ChocolateTopping(coffee);
        assertEquals("Coffee + Chocolate", chocolateCoffee.getDescription());
        assertEquals(4500, chocolateCoffee.getPrice());
    }

    @Test
    void shouldAddCaramelTopping() {
        Coffee caramelCoffee = new CaramelTopping(coffee);
        assertEquals("Coffee + Caramel", caramelCoffee.getDescription());
        assertEquals(4200, caramelCoffee.getPrice());
    }

    @Test
    void shouldAddWhippedCreamTopping() {
        Coffee whippedCreamCoffee = new WhippedCreamTopping(coffee);
        assertEquals("Coffee + Whipped Cream", whippedCreamCoffee.getDescription());
        assertEquals(5000, whippedCreamCoffee.getPrice());
    }

    @Test
    void shouldAddMintTopping() {
        Coffee mintCoffee = new MintTopping(coffee);
        assertEquals("Coffee + Mint", mintCoffee.getDescription());
        assertEquals(4300, mintCoffee.getPrice());
    }

    @Test
    void shouldStackMultipleToppings() {
        Coffee combo = new ChocolateTopping(new MilkTopping(coffee));
        assertEquals("Coffee + Milk + Chocolate", combo.getDescription());
        assertEquals(5500, combo.getPrice());
    }
}