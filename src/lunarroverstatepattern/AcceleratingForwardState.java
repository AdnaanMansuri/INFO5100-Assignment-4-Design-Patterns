package lunarroverstatepattern;

/**
 * DRIVE sub-state <b>Accelerating Forward</b>.
 *
 * <p>On entry it increases the rover's speed (the state's {@code do} action). From
 * here a right hold &gt; 3 s settles into constant speed, while a right tap begins
 * slowing down.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class AcceleratingForwardState extends DriveState {

    /**
     * {@inheritDoc}
     *
     * @return {@code "DRIVE / Accelerating Forward"}
     */
    @Override
    public String name() {
        return "DRIVE / Accelerating Forward";
    }

    /**
     * Entry action: increase forward speed by one step.
     *
     * @param rover the rover context
     */
    @Override
    public void onEntry(LunarRover rover) {
        rover.changeSpeed(LunarRover.ACCEL_STEP);
        System.out.println("        do: increase speed, speed=" + rover.getSpeed());
    }

    /**
     * Right pedal held &gt; 3 s transitions to constant speed.
     *
     * @param rover the rover context
     */
    @Override
    public void onRightHold3s(LunarRover rover) {
        rover.setState(new ConstantSpeedState());
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
