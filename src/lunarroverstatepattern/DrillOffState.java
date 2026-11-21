package lunarroverstatepattern;

/**
 * Drill inner sub-state <b>Off</b> &mdash; the drill is selected but its motor is not
 * running. This is the drill's initial state.
 *
 * <p>A left tap toggles the motor on; a right tap leaves the drill and returns to
 * {@link IdleState}.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class DrillOffState extends ToolsState {

    /**
     * {@inheritDoc}
     *
     * @return {@code "TOOLS / Drill / Off"}
     */
    @Override
    public String name() {
        return "TOOLS / Drill / Off";
    }

    /**
     * Left tap turns the drill motor on.
     *
     * @param rover the rover context
     */
    @Override
    public void onLeftTap(LunarRover rover) {
        rover.setState(new DrillOnState());
    }

    /**
     * Right tap leaves the drill and returns to Idle.
     *
     * @param rover the rover context
     */
    @Override
    public void onRightTap(LunarRover rover) {
        rover.setState(new IdleState());
    }
}
