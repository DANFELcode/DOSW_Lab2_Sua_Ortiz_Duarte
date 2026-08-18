package edu.eci.dosw.challenge6;

/**
 * The contract for a link in the technical support chain of responsibility.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public interface SupportHandler {
    TicketResolution handle(Ticket ticket);

    void setNext(SupportHandler next);
}
