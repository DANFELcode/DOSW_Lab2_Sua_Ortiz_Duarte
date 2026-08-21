package edu.eci.dosw.challenge3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for the LandVehicleFactory class.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */
public class LandVehicleFactoryTest {

    private LandVehicleFactory factory;
    private Category economy;

    @BeforeEach
    void setUp() {
        factory = new LandVehicleFactory();
        economy = new Category("Economy", 1.0, 1.0, "no extra equipment");
    }

    @Test
    void shouldCreateCar() {
        Vehicle vehicle = factory.createVehicle("car", economy);
        assertInstanceOf(Car.class, vehicle);
    }

    @Test
    void shouldCreateBicycle() {
        Vehicle vehicle = factory.createVehicle("bicycle", economy);
        assertInstanceOf(Bicycle.class, vehicle);
    }

    @Test
    void shouldCreateMotorcycle() {
        Vehicle vehicle = factory.createVehicle("motorcycle", economy);
        assertInstanceOf(Motorcycle.class, vehicle);
    }

    @Test
    void shouldThrowExceptionForUnknownModel() {
        assertThrows(IllegalArgumentException.class, () -> factory.createVehicle("boat", economy));
    }
}