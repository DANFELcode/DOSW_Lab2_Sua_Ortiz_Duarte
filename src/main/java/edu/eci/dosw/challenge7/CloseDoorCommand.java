package edu.eci.dosw.challenge7;

/**
 * Command that closes a door and can undo that action.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class CloseDoorCommand implements Command {
    private final Door door;
    private boolean previousState;

    public CloseDoorCommand(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        previousState = door.isOpen();
        door.close();
    }

    @Override
    public void undo() {
        if (previousState) {
            door.open();
        } else {
            door.close();
        }
    }
}
