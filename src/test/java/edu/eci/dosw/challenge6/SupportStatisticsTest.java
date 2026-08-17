package edu.eci.dosw.challenge6;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Tests for the support ticket statistics calculated with streams.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

class SupportStatisticsTest {
    @Test
    void shouldCountResolvedAndPendingTickets() {
        Ticket resolvedTicket = new Ticket("Login issue", DifficultyLevel.BASIC, Priority.LOW);
        Ticket pendingTicket = new Ticket("Duplicate charge", DifficultyLevel.BASIC, Priority.HIGH);

        List<TicketResolution> resolutions = List.of(
                new TicketResolution(resolvedTicket, "Juan", List.of("Juan")),
                new TicketResolution(pendingTicket, null, List.of("Juan", "Daniel", "David"))
        );

        SupportStatistics statistics = new SupportStatistics(resolutions);

        assertEquals(1, statistics.resolvedTickets());
        assertEquals(1, statistics.pendingTickets());
    }

    @Test
    void shouldCalculateAveragePriorityOfResolvedTickets() {
        Ticket lowPriorityTicket = new Ticket("Login issue", DifficultyLevel.BASIC, Priority.LOW);
        Ticket highPriorityTicket = new Ticket("Fraud alert", DifficultyLevel.ADVANCED, Priority.HIGH);

        List<TicketResolution> resolutions = List.of(
                new TicketResolution(lowPriorityTicket, "Juan", List.of("Juan")),
                new TicketResolution(highPriorityTicket, "David", List.of("Juan", "Daniel", "David"))
        );

        SupportStatistics statistics = new SupportStatistics(resolutions);

        assertEquals(2.0, statistics.averagePriorityOfResolved());
    }

    @Test
    void shouldGroupEntriesByLevel() {
        Ticket basicTicket = new Ticket("Login issue", DifficultyLevel.BASIC, Priority.LOW);
        Ticket advancedTicket = new Ticket("Fraud alert", DifficultyLevel.ADVANCED, Priority.HIGH);

        List<TicketResolution> resolutions = List.of(
                new TicketResolution(basicTicket, "Juan", List.of("Juan")),
                new TicketResolution(advancedTicket, "David", List.of("Juan", "Daniel", "David"))
        );

        SupportStatistics statistics = new SupportStatistics(resolutions);

        assertEquals(1L, statistics.entriesByLevel().get(DifficultyLevel.BASIC));
        assertEquals(1L, statistics.entriesByLevel().get(DifficultyLevel.ADVANCED));
    }
}
