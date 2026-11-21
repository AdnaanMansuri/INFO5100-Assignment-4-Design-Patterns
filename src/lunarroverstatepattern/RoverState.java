package lunarroverstatepattern;

/**
 * Base type for every state of the Lunar Rover in the <b>State</b> pattern redesign.
 *
 * <p>In Assignment&nbsp;3 the rover kept its configuration in enums and interpreted
 * every event inside one large {@code handle} method. Here each state of the UML
 * state machine becomes its own class that extends {@code RoverState} and overrides
 * only the events it actually reacts to. Every other event falls through to the
 * default implementations below, which simply report the event as ignored &mdash;
 * exactly the "unlisted events are ignored" rule from the diagram.</p>
 *
 * <p>Two abstract sub-types, {@link DriveState} and {@link ToolsState}, capture the
 * behaviour the two super-states share (most importantly what {@code FLIP_SWITCH}
 * does), and the concrete leaf states extend those.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public abstract class RoverState {

    /**
     * Returns the fully-qualified display name of this state, such as
     * {@code "DRIVE / Accelerating Forward"}. Used in console output and in the
     * unit-test assertions.
     *
     * @return the state's display name
     */
    public abstract String name();

    /**
     * Entry / "do" action executed when the context switches into this state.
     *
     * <p>The default does nothing. States that perform an action on entry (for
     * example changing speed, running a countdown, or auto-completing to another
     * state) override this. It is invoked by {@link LunarRover#setState(RoverState)}.</p>
     *
     * @param rover the rover context that has just entered this state
     */
    public void onEntry(LunarRover rover) {
    }

    /**
     * Handles a single left-pedal tap. Default: ignored.
     *
     * @param rover the rover context
     */
    public void onLeftTap(LunarRover rover) {
        rover.ignored(Event.LEFT_TAP);
    }

    /**
     * Handles a left-pedal double-tap. Default: ignored.
     *
     * @param rover the rover context
     */
    public void onLeftDoubleTap(LunarRover rover) {
        rover.ignored(Event.LEFT_DOUBLE_TAP);
    }

    /**
     * Handles a left-pedal hold &gt; 3 s. Default: ignored.
     *
     * @param rover the rover context
     */
    public void onLeftHold3s(LunarRover rover) {
        rover.ignored(Event.LEFT_HOLD_3S);
    }

    /**
     * Handles a left-pedal hold of ~5 s. Default: ignored.
     *
     * @param rover the rover context
     */
    public void onLeftHold5s(LunarRover rover) {
        rover.ignored(Event.LEFT_HOLD_5S);
    }

    /**
     * Handles a left-pedal hold of ~10 s. Default: ignored.
     *
     * @param rover the rover context
     */
    public void onLeftHold10s(LunarRover rover) {
        rover.ignored(Event.LEFT_HOLD_10S);
    }

    /**
     * Handles a single right-pedal tap. Default: ignored.
     *
     * @param rover the rover context
     */
    public void onRightTap(LunarRover rover) {
        rover.ignored(Event.RIGHT_TAP);
    }

    /**
     * Handles a right-pedal hold &gt; 3 s. Default: ignored.
     *
     * @param rover the rover context
     */
    public void onRightHold3s(LunarRover rover) {
        rover.ignored(Event.RIGHT_HOLD_3S);
    }

    /**
     * Handles the mode switch being thrown. This has no default because its effect
     * depends on the current mode, so {@link DriveState} and {@link ToolsState}
     * each provide it.
     *
     * @param rover the rover context
     */
    public abstract void onFlipSwitch(LunarRover rover);
}
