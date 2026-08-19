package edu.eci.dosw.challenge7;

/**
 * Command that sets the volume of a music system and can undo that action.
 *
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

public class SetVolumeCommand implements Command {
    private final MusicSystem musicSystem;
    private final int newVolume;
    private int previousVolume;

    public SetVolumeCommand(MusicSystem musicSystem, int newVolume) {
        this.musicSystem = musicSystem;
        this.newVolume = newVolume;
    }

    @Override
    public void execute() {
        previousVolume = musicSystem.getVolume();
        musicSystem.setVolume(newVolume);
    }

    @Override
    public void undo() {
        musicSystem.setVolume(previousVolume);
    }
}
