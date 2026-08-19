package edu.eci.dosw.challenge7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the remote control invoker: executing commands and undoing individual actions.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

class RemoteControlTest {
    private RemoteControl remote;
    private Light light;
    private Door door;

    @BeforeEach
    void setUp() {
        remote = new RemoteControl();
        light = new Light();
        door = new Door();
    }

    @Test
    void shouldExecuteCommandAndRecordItInHistory() {
        remote.execute(new TurnOnCommand(light), "Juan", "Turn on light", "Light");

        assertTrue(light.isOn());
        assertEquals(1, remote.getHistory().size());
        assertEquals("Juan", remote.getHistory().get(0).getUser());
    }

    @Test
    void shouldUndoASpecificActionThatIsNotTheLastOne() {
        remote.execute(new TurnOnCommand(light), "Juan", "Turn on light", "Light");
        remote.execute(new OpenDoorCommand(door), "Daniel", "Open door", "Door");

        remote.undo(0);

        assertFalse(light.isOn());
        assertTrue(door.isOpen());
    }

    @Test
    void shouldMarkActionAsUndoneWithoutRemovingItFromHistory() {
        remote.execute(new TurnOnCommand(light), "Juan", "Turn on light", "Light");

        remote.undo(0);

        assertEquals(1, remote.getHistory().size());
        assertTrue(remote.getHistory().get(0).isUndone());
    }
}
