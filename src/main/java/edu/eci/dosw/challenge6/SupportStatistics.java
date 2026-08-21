package edu.eci.dosw.challenge6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Computes resolution statistics from a batch of processed tickets using streams.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class SupportStatistics {
    private final List<TicketResolution> resolutions;

    public SupportStatistics(List<TicketResolution> resolutions) {
        this.resolutions = resolutions;
    }

    public Map<DifficultyLevel, Long> entriesByLevel() {
        return resolutions.stream()
                .collect(Collectors.groupingBy(
                        resolution -> resolution.getTicket().getLevel(),
                        Collectors.counting()));
    }

    public Map<String, Long> resolvedCountByTechnician() {
        return resolutions.stream()
                .filter(TicketResolution::isResolved)
                .collect(Collectors.groupingBy(
                        TicketResolution::getResolvedBy,
                        Collectors.counting()));
    }

    public long passedThroughMoreThanOneTechnician() {
        return resolutions.stream()
                .filter(TicketResolution::passedThroughMoreThanOneTechnician)
                .count();
    }

    public long resolvedTickets() {
        return resolutions.stream()
                .filter(TicketResolution::isResolved)
                .count();
    }

    public long pendingTickets() {
        return resolutions.stream()
                .filter(resolution -> !resolution.isResolved())
                .count();
    }

    public double averagePriorityOfResolved() {
        return resolutions.stream()
                .filter(TicketResolution::isResolved)
                .mapToInt(resolution -> resolution.getTicket().getPriority().ordinal() + 1)
                .average()
                .orElse(0.0);
    }
}
