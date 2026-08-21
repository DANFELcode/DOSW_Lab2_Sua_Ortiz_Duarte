package edu.eci.dosw.challenge7;

/**
 * The contract for an action that can be executed and undone on a home device.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public interface Command {
    void execute();

    void undo();
}
