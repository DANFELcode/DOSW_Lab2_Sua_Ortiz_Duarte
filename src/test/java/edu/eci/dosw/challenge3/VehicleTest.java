package edu.eci.dosw.challenge3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the Vehicle class, using Car as a concrete implementation.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */
public class VehicleTest {

    private Category economy;
    private Category luxury;

    @BeforeEach
    void setUp() {
        economy = new Category("Economy", 1.0, 1.0, "no extra equipment");
        luxury = new Category("Luxury", 1.5, 1.2, "premium package");
    }

    @Test
    void shouldReturnBasePriceWhenEconomyCategory() {
        Vehicle car = new Car(economy);
        assertEquals(35000, car.getFinalPrice());
    }

    @Test
    void shouldApplyPriceMultiplierWhenLuxuryCategory() {
        Vehicle car = new Car(luxury);
        assertEquals(52500, car.getFinalPrice());
    }

    @Test
    void shouldApplySpeedMultiplier() {
        Vehicle car = new Car(luxury);
        assertEquals(180.0, car.getFinalSpeed(), 0.001);
    }

    @Test
    void shouldReturnType() {
        Vehicle car = new Car(economy);
        assertEquals("Car", car.getType());
    }

    @Test
    void shouldReturnCategory() {
        Vehicle car = new Car(luxury);
        assertEquals("Luxury", car.getCategory().getName());
    }

    @Test
    void shouldReturnSpecialEquipmentAccordingToCategory() {
        Vehicle economyCar = new Car(economy);
        assertEquals("radio fm", economyCar.getSpecialEquipment());
    }
}