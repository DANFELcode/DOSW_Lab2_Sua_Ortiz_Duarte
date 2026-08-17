package edu.eci.dosw.challenge6;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the technician chain of responsibility.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

class SupportChainTest {
    private SupportChain chain;

    @BeforeEach
    void setUp() {
        Technician juan = new Technician("Juan", DifficultyLevel.BASIC, Priority.LOW);
        Technician daniel = new Technician("Daniel", DifficultyLevel.INTERMEDIATE, Priority.MEDIUM);
        Technician david = new Technician("David", DifficultyLevel.ADVANCED, Priority.HIGH);

        juan.setNext(daniel);
        daniel.setNext(david);

        chain = new SupportChain(juan);
    }

    @Test
    void shouldResolveTicketDirectlyWithFirstTechnician() {
        Ticket ticket = new Ticket("Login issue", DifficultyLevel.BASIC, Priority.LOW);

        TicketResolution resolution = chain.process(List.of(ticket)).get(0);

        assertTrue(resolution.isResolved());
        assertEquals("Juan", resolution.getResolvedBy());
        assertFalse(resolution.passedThroughMoreThanOneTechnician());
    }

    @Test
    void shouldEscalateTicketToNextTechnicianWhenSpecialtyDoesNotMatch() {
        Ticket ticket = new Ticket("Transaction dispute", DifficultyLevel.INTERMEDIATE, Priority.MEDIUM);

        TicketResolution resolution = chain.process(List.of(ticket)).get(0);

        assertTrue(resolution.isResolved());
        assertEquals("Daniel", resolution.getResolvedBy());
        assertTrue(resolution.passedThroughMoreThanOneTechnician());
    }

    @Test
    void shouldMarkTicketAsPendingWhenNoTechnicianCanHandleIt() {
        Ticket ticket = new Ticket("Duplicate charge", DifficultyLevel.BASIC, Priority.HIGH);

        TicketResolution resolution = chain.process(List.of(ticket)).get(0);

        assertFalse(resolution.isResolved());
        assertEquals(3, resolution.getAttemptedBy().size());
    }
}
