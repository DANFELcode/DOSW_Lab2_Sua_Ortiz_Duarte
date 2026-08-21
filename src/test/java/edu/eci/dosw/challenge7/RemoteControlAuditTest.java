package edu.eci.dosw.challenge7;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the audit report generated over the remote control's execution history.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

class RemoteControlAuditTest {
    @Test
    void shouldListOnlyUndoneActions() {
        RemoteControl remote = new RemoteControl();
        Light light = new Light();
        Door door = new Door();

        remote.execute(new TurnOnCommand(light), "Juan", "Turn on light", "Light");
        remote.execute(new OpenDoorCommand(door), "Daniel", "Open door", "Door");
        remote.undo(0);

        RemoteControlAudit audit = new RemoteControlAudit(remote.getHistory());
        List<ExecutedAction> undone = audit.undoneActions();

        assertEquals(1, undone.size());
        assertEquals("Turn on light", undone.get(0).getDescription());
    }

    @Test
    void shouldReturnLastUserWhoModifiedEachDevice() {
        RemoteControl remote = new RemoteControl();
        MusicSystem musicSystem = new MusicSystem();

        remote.execute(new SetVolumeCommand(musicSystem, 70), "David", "Set music volume to 70", "MusicSystem");
        remote.execute(new SetVolumeCommand(musicSystem, 30), "Juan", "Set music volume to 30", "MusicSystem");

        RemoteControlAudit audit = new RemoteControlAudit(remote.getHistory());
        Map<String, String> lastUserPerDevice = audit.lastUserPerDevice();

        assertEquals("Juan", lastUserPerDevice.get("MusicSystem"));
    }
}
