package lunarroverstatepattern;

/**
 * DRIVE sub-state <b>Rest</b> &mdash; the rover is stopped (speed 0). This is the
 * initial state of the whole machine.
 *
 * <p>From Rest the astronaut can start moving forward (left tap) or backward (left
 * hold &gt; 3 s). Everything else is ignored.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class RestState extends DriveState {

    /**
     * {@inheritDoc}
     *
     * @return {@code "DRIVE / Rest"}
     */
    @Override
    public String name() {
        return "DRIVE / Rest";
    }

    /**
     * Left tap starts accelerating forward.
     *
     * @param rover the rover context
     */
    @Override
    public void onLeftTap(LunarRover rover) {
        rover.setState(new AcceleratingForwardState());
    }

    /**
     * Left pedal held &gt; 3 s starts accelerating backward.
     *
     * @param rover the rover context
     */
    @Override
    public void onLeftHold3s(LunarRover rover) {
        rover.setState(new AcceleratingBackwardState());
    }
}
