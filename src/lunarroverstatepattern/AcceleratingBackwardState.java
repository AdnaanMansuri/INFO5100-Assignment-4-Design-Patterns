package lunarroverstatepattern;

/**
 * DRIVE sub-state <b>Accelerating Backward</b> (reverse).
 *
 * <p>On entry it increases reverse speed. There is no constant-reverse state in the
 * design, so reverse simply keeps accelerating until the astronaut slows down with a
 * right tap.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class AcceleratingBackwardState extends DriveState {

    /**
     * {@inheritDoc}
     *
     * @return {@code "DRIVE / Accelerating Backward"}
     */
    @Override
    public String name() {
        return "DRIVE / Accelerating Backward";
    }

    /**
     * Entry action: increase reverse speed by one step (speed goes negative).
     *
     * @param rover the rover context
     */
    @Override
    public void onEntry(LunarRover rover) {
        rover.changeSpeed(-LunarRover.ACCEL_STEP);
        System.out.println("        do: reverse, speed=" + rover.getSpeed());
    }

    /**
     * Right tap begins deaccelerating.
     *
     * @param rover the rover context
     */
    @Override
    public void onRightTap(LunarRover rover) {
        rover.setState(new DeacceleratingState());
    }
}
