package lunarroverstatepattern;

/**
 * DRIVE sub-state <b>Deaccelerating</b>.
 *
 * <p>This is a transient state: its {@code do} action reduces the speed toward zero
 * and, once {@code speed == 0}, it immediately performs the completion transition
 * back to {@link RestState}. Because all of that happens in {@link #onEntry}, the
 * rover is already at Rest by the time control returns to the caller &mdash; which is
 * exactly the behaviour of the Assignment&nbsp;3 machine.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class DeacceleratingState extends DriveState {

    /**
     * {@inheritDoc}
     *
     * @return {@code "DRIVE / Deaccelerating"}
     */
    @Override
    public String name() {
        return "DRIVE / Deaccelerating";
    }

    /**
     * Entry action: reduce the magnitude of the speed one step at a time until it
     * reaches zero, then transition to {@link RestState} (guard {@code [speed == 0]}).
     *
     * @param rover the rover context
     */
    @Override
    public void onEntry(LunarRover rover) {
        System.out.println("        do: reduce speed");
        while (rover.getSpeed() != 0) {
            int speed = rover.getSpeed();
            int step = Integer.signum(speed) * Math.min(Math.abs(speed), LunarRover.ACCEL_STEP);
            rover.setSpeed(speed - step);
            System.out.println("        ...reducing, speed = " + rover.getSpeed());
        }
        rover.setState(new RestState());
    }
}
