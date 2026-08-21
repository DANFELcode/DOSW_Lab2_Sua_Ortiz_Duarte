package edu.eci.dosw.challenge6;

import java.util.ArrayList;
import java.util.List;

/**
 * A bank support technician that resolves tickets matching its specialty and
 * escalates the ones it cannot handle to the next technician in the chain.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class Technician implements SupportHandler {
    private final String name;
    private final DifficultyLevel specialty;
    private final Priority maxPriority;
    private SupportHandler next;

    public Technician(String name, DifficultyLevel specialty, Priority maxPriority) {
        this.name = name;
        this.specialty = specialty;
        this.maxPriority = maxPriority;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setNext(SupportHandler next) {
        this.next = next;
    }

    @Override
    public TicketResolution handle(Ticket ticket) {
        if (canResolve(ticket)) {
            return new TicketResolution(ticket, name, List.of(name));
        }

        if (next == null) {
            return new TicketResolution(ticket, null, List.of(name));
        }

        TicketResolution nextResolution = next.handle(ticket);
        List<String> attemptedBy = new ArrayList<>();
        attemptedBy.add(name);
        attemptedBy.addAll(nextResolution.getAttemptedBy());

        return new TicketResolution(ticket, nextResolution.getResolvedBy(), attemptedBy);
    }

    private boolean canResolve(Ticket ticket) {
        boolean specialtyMatches = ticket.getLevel() == specialty;
        boolean priorityWithinRange = ticket.getPriority().compareTo(maxPriority) <= 0;
        return specialtyMatches && priorityWithinRange;
    }
}
