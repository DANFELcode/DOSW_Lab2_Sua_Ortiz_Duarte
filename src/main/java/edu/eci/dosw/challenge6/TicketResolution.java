package edu.eci.dosw.challenge6;

import java.util.List;

/**
 * The outcome of processing a ticket through the technical support chain.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class TicketResolution {
    private final Ticket ticket;
    private final String resolvedBy;
    private final List<String> attemptedBy;

    public TicketResolution(Ticket ticket, String resolvedBy, List<String> attemptedBy) {
        this.ticket = ticket;
        this.resolvedBy = resolvedBy;
        this.attemptedBy = attemptedBy;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String getResolvedBy() {
        return resolvedBy;
    }

    public List<String> getAttemptedBy() {
        return attemptedBy;
    }

    public boolean isResolved() {
        return resolvedBy != null;
    }

    public boolean passedThroughMoreThanOneTechnician() {
        return attemptedBy.size() > 1;
    }
}
