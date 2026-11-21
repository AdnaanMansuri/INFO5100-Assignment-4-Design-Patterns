package lunarroverstatepattern;

/**
 * Shared behaviour for every state inside the <b>TOOLS</b> (Camera &amp; Drill
 * Control) super-state.
 *
 * <p>As with {@link DriveState}, {@code flip switch} is a border transition of the
 * whole TOOLS mode, so it is defined once here and inherited by every tool state.
 * Flipping back always restarts DRIVE at its initial {@link RestState}.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public abstract class ToolsState extends RoverState {

    /**
     * Flips from TOOLS back to DRIVE, re-entering DRIVE at its initial
     * {@link RestState} with the rover stopped.
     *
     * @param rover the rover context
     */
    @Override
    public void onFlipSwitch(LunarRover rover) {
        rover.setSpeed(0);
        rover.setState(new RestState());
    }
}
