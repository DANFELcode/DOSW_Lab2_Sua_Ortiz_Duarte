package edu.eci.dosw.challenge7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Executes commands on home devices and keeps a history that can be audited or undone.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class RemoteControl {
    private final List<ExecutedAction> history = new ArrayList<>();

    public void execute(Command command, String user, String description, String device) {
        command.execute();
        history.add(new ExecutedAction(command, user, description, device));
    }

    public void undo(int actionIndex) {
        ExecutedAction action = history.get(actionIndex);
        action.getCommand().undo();
        action.markUndone();
    }

    public List<ExecutedAction> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
