package edu.eci.dosw.challenge7;

/**
 * An air conditioner that can be turned on and off.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class AirConditioner implements Switchable {
    private boolean on;

    @Override
    public void turnOn() {
        on = true;
    }

    @Override
    public void turnOff() {
        on = false;
    }

    @Override
    public boolean isOn() {
        return on;
    }
}
