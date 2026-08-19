package edu.eci.dosw.challenge7;

/**
 * Command that turns on a switchable device and can undo that action.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class TurnOnCommand implements Command {
    private final Switchable device;
    private boolean previousState;

    public TurnOnCommand(Switchable device) {
        this.device = device;
    }

    @Override
    public void execute() {
        previousState = device.isOn();
        device.turnOn();
    }

    @Override
    public void undo() {
        if (previousState) {
            device.turnOn();
        } else {
            device.turnOff();
        }
    }
}
