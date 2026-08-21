package edu.eci.dosw.challenge3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for the WaterVehicleFactory class.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */
public class WaterVehicleFactoryTest {

    private WaterVehicleFactory factory;
    private Category economy;

    @BeforeEach
    void setUp() {
        factory = new WaterVehicleFactory();
        economy = new Category("Economy", 1.0, 1.0, "no extra equipment");
    }

    @Test
    void shouldCreateBoat() {
        Vehicle vehicle = factory.createVehicle("boat", economy);
        assertInstanceOf(Boat.class, vehicle);
    }

    @Test
    void shouldCreateSailBoat() {
        Vehicle vehicle = factory.createVehicle("sailboat", economy);
        assertInstanceOf(SailBoat.class, vehicle);
    }

    @Test
    void shouldCreateJetSki() {
        Vehicle vehicle = factory.createVehicle("jetski", economy);
        assertInstanceOf(JetSki.class, vehicle);
    }

    @Test
    void shouldThrowExceptionForUnknownModel() {
        assertThrows(IllegalArgumentException.class, () -> factory.createVehicle("car", economy));
    }
}