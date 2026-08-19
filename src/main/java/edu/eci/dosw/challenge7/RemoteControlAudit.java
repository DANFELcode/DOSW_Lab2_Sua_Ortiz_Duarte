package edu.eci.dosw.challenge7;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Answers the audit questions required by the challenge using streams over the executed actions.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class RemoteControlAudit {
    private final List<ExecutedAction> history;

    public RemoteControlAudit(List<ExecutedAction> history) {
        this.history = history;
    }

    public List<ExecutedAction> undoneActions() {
        return history.stream()
                .filter(ExecutedAction::isUndone)
                .collect(Collectors.toList());
    }

    public Map<String, String> lastUserPerDevice() {
        return history.stream()
                .collect(Collectors.toMap(
                        ExecutedAction::getDevice,
                        ExecutedAction::getUser,
                        (firstUser, lastUser) -> lastUser,
                        LinkedHashMap::new));
    }
}
