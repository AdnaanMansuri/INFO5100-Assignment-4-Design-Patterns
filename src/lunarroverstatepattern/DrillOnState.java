package lunarroverstatepattern;

/**
 * Drill inner sub-state <b>On</b> &mdash; the drill motor is running.
 *
 * <p>A left tap toggles the motor back off. A right tap leaves the drill; because the
 * motor is running, the exit action powers it off before returning to
 * {@link IdleState}.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class DrillOnState extends ToolsState {

    /**
     * {@inheritDoc}
     *
     * @return {@code "TOOLS / Drill / On"}
     */
    @Override
    public String name() {
        return "TOOLS / Drill / On";
    }

    /**
     * Entry action: start running the motor.
     *
     * @param rover the rover context
     */
    @Override
    public void onEntry(LunarRover rover) {
        System.out.println("        do: run motor");
    }

    /**
     * Left tap turns the drill motor off.
     *
     * @param rover the rover context
     */
    @Override
    public void onLeftTap(LunarRover rover) {
        rover.setState(new DrillOffState());
    }

    /**
     * Right tap powers the motor off and returns to Idle.
     *
     * @param rover the rover context
     */
    @Override
    public void onRightTap(LunarRover rover) {
        System.out.println("        (drill powers off on exit)");
        rover.setState(new IdleState());
    }
}
