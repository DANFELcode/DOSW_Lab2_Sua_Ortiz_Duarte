package edu.eci.dosw.challenge6;

import java.util.List;
import java.util.Map;

/**
 * This is the bank's technical support system that routes tickets through a
 * chain of technicians until one of them is able to resolve them.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public final class Challenge6TechnicalSupport {
    private Challenge6TechnicalSupport() {
    }

    public static void run() {
        System.out.println("Running Challenge 6 - Talk to Technical Support...");

        Technician juan = new Technician("Juan", DifficultyLevel.BASIC, Priority.LOW);
        Technician daniel = new Technician("Daniel", DifficultyLevel.INTERMEDIATE, Priority.MEDIUM);
        Technician david = new Technician("David", DifficultyLevel.ADVANCED, Priority.HIGH);

        juan.setNext(daniel);
        daniel.setNext(david);

        List<Ticket> tickets = List.of(
                new Ticket("Customer cannot log in to online banking", DifficultyLevel.BASIC, Priority.LOW),
                new Ticket("Debit card blocked due to multiple failed attempts", DifficultyLevel.BASIC, Priority.MEDIUM),
                new Ticket("Update customer contact information", DifficultyLevel.INTERMEDIATE, Priority.LOW),
                new Ticket("Unrecognized transaction dispute", DifficultyLevel.INTERMEDIATE, Priority.MEDIUM),
                new Ticket("Suspected account fraud", DifficultyLevel.ADVANCED, Priority.HIGH),
                new Ticket("Failure in the interbank transfer system", DifficultyLevel.ADVANCED, Priority.MEDIUM),
                new Ticket("Customer reports duplicate charge on credit card", DifficultyLevel.BASIC, Priority.HIGH),
                new Ticket("Request to increase credit card limit", DifficultyLevel.INTERMEDIATE, Priority.HIGH)
        );

        SupportChain chain = new SupportChain(juan);
        List<TicketResolution> resolutions = chain.process(tickets);
        SupportStatistics statistics = new SupportStatistics(resolutions);
        Map<String, Long> resolvedByTechnician = statistics.resolvedCountByTechnician();

        System.out.println("\nResolution summary:");
        List.of(juan, daniel, david).forEach(technician ->
                System.out.println(technician.getName() + " resolved "
                        + resolvedByTechnician.getOrDefault(technician.getName(), 0L) + " ticket(s)"));
        System.out.println("Unresolved (pending escalation): " + statistics.pendingTickets());
        System.out.println("Tickets that passed through more than one technician: "
                + statistics.passedThroughMoreThanOneTechnician());

        System.out.println("\nStatistics:");
        System.out.println("Entries by level: " + statistics.entriesByLevel());
        System.out.println("Resolved tickets: " + statistics.resolvedTickets());
        System.out.println("Pending tickets: " + statistics.pendingTickets());
        System.out.println("Average priority of resolved tickets: " + statistics.averagePriorityOfResolved());
    }
}
