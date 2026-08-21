package edu.eci.dosw.challenge6;

/**
 * A technical support ticket submitted by a bank customer.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class Ticket {
    private final String description;
    private final DifficultyLevel level;
    private final Priority priority;

    public Ticket(String description, DifficultyLevel level, Priority priority) {
        this.description = description;
        this.level = level;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public DifficultyLevel getLevel() {
        return level;
    }

    public Priority getPriority() {
        return priority;
    }
}
