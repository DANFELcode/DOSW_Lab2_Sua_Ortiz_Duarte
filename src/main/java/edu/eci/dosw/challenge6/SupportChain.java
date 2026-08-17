package edu.eci.dosw.challenge6;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Processes a batch of tickets through the technician chain of responsibility.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class SupportChain {
    private final SupportHandler firstTechnician;

    public SupportChain(SupportHandler firstTechnician) {
        this.firstTechnician = firstTechnician;
    }

    public List<TicketResolution> process(List<Ticket> tickets) {
        return tickets.stream()
                .map(firstTechnician::handle)
                .collect(Collectors.toList());
    }
}
