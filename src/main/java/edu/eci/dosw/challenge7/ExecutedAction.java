package edu.eci.dosw.challenge7;

/**
 * A record of one executed action, used for the remote control's audit trail.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class ExecutedAction {
    private final Command command;
    private final String user;
    private final String description;
    private final String device;
    private boolean undone;

    public ExecutedAction(Command command, String user, String description, String device) {
        this.command = command;
        this.user = user;
        this.description = description;
        this.device = device;
    }

    public Command getCommand() {
        return command;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public String getDevice() {
        return device;
    }

    public boolean isUndone() {
        return undone;
    }

    public void markUndone() {
        undone = true;
    }
}
