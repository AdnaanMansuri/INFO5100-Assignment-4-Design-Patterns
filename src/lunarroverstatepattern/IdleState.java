package lunarroverstatepattern;

/**
 * TOOLS sub-state <b>Idle</b> &mdash; the initial state of the TOOLS mode, where no
 * device is selected.
 *
 * <p>A device can be chosen only from Idle: a 5-second hold selects the colour
 * camera, a 10-second hold the 16-mm camera, and a double-tap the drill.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class IdleState extends ToolsState {

    /**
     * {@inheritDoc}
     *
     * @return {@code "TOOLS / Idle"}
     */
    @Override
    public String name() {
        return "TOOLS / Idle";
    }

    /**
     * Left pedal held ~5 s selects the colour camera.
     *
     * @param rover the rover context
     */
    @Override
    public void onLeftHold5s(LunarRover rover) {
        rover.setState(new CameraReadyState("Color Camera"));
    }

    /**
     * Left pedal held ~10 s selects the 16-mm camera.
     *
     * @param rover the rover context
     */
    @Override
    public void onLeftHold10s(LunarRover rover) {
        rover.setState(new CameraReadyState("16-mm Camera"));
    }

    /**
     * Left double-tap selects the drill.
     *
     * @param rover the rover context
     */
    @Override
    public void onLeftDoubleTap(LunarRover rover) {
        rover.setState(new DrillOffState());
    }
}
