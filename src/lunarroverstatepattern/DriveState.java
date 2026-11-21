package lunarroverstatepattern;

/**
 * Shared behaviour for every state inside the <b>DRIVE</b> (Movement Control)
 * super-state.
 *
 * <p>The diagram draws {@code flip switch} on the border of the DRIVE mode, so it
 * can fire from any movement sub-state. Capturing that here, once, means none of
 * the concrete drive states has to repeat it &mdash; and it also stops the rover
 * before handing control to TOOLS, as the specification requires.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public abstract class DriveState extends RoverState {

    /**
     * Flips from DRIVE to TOOLS: stops the rover, then re-enters TOOLS at its
     * initial {@link IdleState} (no history is kept).
     *
     * @param rover the rover context
     */
    @Override
    public void onFlipSwitch(LunarRover rover) {
        rover.setSpeed(0);
        System.out.println("      flip / stop rover");
        rover.setState(new IdleState());
    }
}
