package lunarroverstatepattern;

/**
 * DRIVE sub-state <b>Constant Speed</b> &mdash; the rover holds its current forward
 * speed.
 *
 * <p>A right tap is the only listed transition; it begins deaccelerating.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class ConstantSpeedState extends DriveState {

    /**
     * {@inheritDoc}
     *
     * @return {@code "DRIVE / Constant Speed"}
     */
    @Override
    public String name() {
        return "DRIVE / Constant Speed";
    }

    /**
     * Entry action: report the speed being held (speed is unchanged).
     *
     * @param rover the rover context
     */
    @Override
    public void onEntry(LunarRover rover) {
        System.out.println("        do: hold speed=" + rover.getSpeed());
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
