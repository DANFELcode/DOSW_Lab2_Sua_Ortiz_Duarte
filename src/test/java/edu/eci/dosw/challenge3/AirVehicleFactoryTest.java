package edu.eci.dosw.challenge3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for the AirVehicleFactory class.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */
public class AirVehicleFactoryTest {

    private AirVehicleFactory factory;
    private Category economy;

    @BeforeEach
    void setUp() {
        factory = new AirVehicleFactory();
        economy = new Category("Economy", 1.0, 1.0, "no extra equipment");
    }

    @Test
    void shouldCreateAirplane() {
        Vehicle vehicle = factory.createVehicle("airplane", economy);
        assertInstanceOf(Airplane.class, vehicle);
    }

    @Test
    void shouldCreateLightAircraft() {
        Vehicle vehicle = factory.createVehicle("lightaircraft", economy);
        assertInstanceOf(LightAircraft.class, vehicle);
    }

    @Test
    void shouldCreateHelicopter() {
        Vehicle vehicle = factory.createVehicle("helicopter", economy);
        assertInstanceOf(Helicopter.class, vehicle);
    }

    @Test
    void shouldThrowExceptionForUnknownModel() {
        assertThrows(IllegalArgumentException.class, () -> factory.createVehicle("boat", economy));
    }
}