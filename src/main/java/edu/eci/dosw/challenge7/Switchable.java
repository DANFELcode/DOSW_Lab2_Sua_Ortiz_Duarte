package edu.eci.dosw.challenge7;

/**
 * The contract for a device that can be turned on and off.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public interface Switchable {
    void turnOn();

    void turnOff();

    boolean isOn();
}
