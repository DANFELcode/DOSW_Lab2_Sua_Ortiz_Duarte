package edu.eci.dosw.challenge7;

import java.util.List;
import java.util.Map;

/**
 * This is the magic remote control system that executes and audits actions
 * performed on home devices.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public final class Challenge7MagicRemoteControl {
    private Challenge7MagicRemoteControl() {
    }

    public static void run() {
        System.out.println("Running Challenge 7 - The Magic Remote Control...");

        Television television = new Television();
        MusicSystem musicSystem = new MusicSystem();
        Door door = new Door();
        WindowBlind windowBlind = new WindowBlind();
        Light light = new Light();
        AirConditioner airConditioner = new AirConditioner();

        RemoteControl remote = new RemoteControl();

        remote.execute(new TurnOnCommand(television), "Juan", "Turn on TV", "Television");
        remote.execute(new SetVolumeCommand(musicSystem, 70), "David", "Set music volume to 70", "MusicSystem");
        remote.execute(new OpenDoorCommand(door), "Daniel", "Open door", "Door");
        remote.execute(new SetBlindPositionCommand(windowBlind, 40), "Juan", "Set blind position to 40", "WindowBlind");
        remote.execute(new TurnOnCommand(airConditioner), "David", "Turn on air conditioner", "AirConditioner");
        remote.execute(new TurnOnCommand(light), "Daniel", "Turn on light", "Light");
        remote.execute(new SetVolumeCommand(musicSystem, 30), "Juan", "Set music volume to 30", "MusicSystem");
        remote.execute(new CloseDoorCommand(door), "David", "Close door", "Door");

        remote.undo(4);
        remote.undo(5);

        List<ExecutedAction> history = remote.getHistory();
        RemoteControlAudit audit = new RemoteControlAudit(history);

        System.out.println("\nExecution history (who executed each action):");
        for (int i = 0; i < history.size(); i++) {
            ExecutedAction action = history.get(i);
            String status = action.isUndone() ? "UNDONE" : "ACTIVE";
            System.out.println((i + 1) + ". " + action.getUser() + ": " + action.getDescription() + " (" + status + ")");
        }

        System.out.println("\nUndone actions: " + audit.undoneActions().size());
        audit.undoneActions().forEach(action ->
                System.out.println("- " + action.getDescription() + " (" + action.getUser() + ")"));

        System.out.println("\nDevice audit (user who last modified each device):");
        Map<String, String> lastUserPerDevice = audit.lastUserPerDevice();
        lastUserPerDevice.forEach((device, user) -> System.out.println(device + ": " + user));
    }
}
