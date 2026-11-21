package lunarroverstatepattern;

/**
 * External inputs to the Lunar Rover &mdash; the pedal / switch gestures that have
 * already been decoded by the input layer.
 *
 * <p>These are the same events as the Assignment&nbsp;3 state machine. The point of
 * the State-pattern redesign is that each {@link RoverState} decides, on its own,
 * what each of these events means; the {@link LunarRover} context no longer
 * contains the giant {@code switch} that used to interpret them.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public enum Event {

    /** Left pedal pressed once (a short tap). */
    LEFT_TAP,

    /** Left pedal tapped twice in quick succession. */
    LEFT_DOUBLE_TAP,

    /** Left pedal held for more than three seconds. */
    LEFT_HOLD_3S,

    /** Left pedal held for about five seconds. */
    LEFT_HOLD_5S,

    /** Left pedal held for about ten seconds. */
    LEFT_HOLD_10S,

    /** Right pedal pressed once (a short tap). */
    RIGHT_TAP,

    /** Right pedal held for more than three seconds. */
    RIGHT_HOLD_3S,

    /** The mode switch is thrown, toggling DRIVE and TOOLS. */
    FLIP_SWITCH
}
