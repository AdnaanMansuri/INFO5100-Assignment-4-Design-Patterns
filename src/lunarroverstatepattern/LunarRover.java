package lunarroverstatepattern;

/**
 * The <b>Context</b> of the Lunar Rover State pattern (Assignment&nbsp;4, Part&nbsp;II).
 *
 * <p>This is the Assignment&nbsp;3 Lunar Rover redesigned with the GoF State pattern.
 * Instead of holding its configuration in enums and interpreting every event inside
 * one large {@code handle} method, the rover now keeps a reference to a single
 * {@link RoverState} object and <em>delegates</em> each event to it. The current
 * state decides what the event means and installs the next state through
 * {@link #setState(RoverState)}. Adding or changing a state no longer means editing a
 * central switch &mdash; it means adding or editing a {@code RoverState} subclass.</p>
 *
 * <p>The rover keeps only the data that genuinely spans states &mdash; its speed
 * &mdash; and the small set of helpers the states use to report transitions.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class LunarRover {

    /**
     * Speed change applied by one acceleration or deacceleration step.
     * A constant keeps the forward, reverse and slow-down logic consistent.
     */
    public static final int ACCEL_STEP = 20;

    /**
     * The rover's current state object &mdash; the heart of the State pattern.
     * All event handling is delegated to whatever {@code RoverState} this refers to.
     */
    private RoverState state;

    /**
     * Current speed: positive is forward, negative is reverse, zero is stopped.
     * It is the one piece of configuration shared across the movement states, so it
     * lives on the context rather than inside any single state.
     */
    private int speed;

    /**
     * Creates a rover in its initial configuration: DRIVE mode, {@link RestState},
     * speed zero. The initial state is assigned directly (rather than through
     * {@link #setState(RoverState)}) so that no spurious transition line is printed
     * before the machine has done anything.
     */
    public LunarRover() {
        this.speed = 0;
        this.state = new RestState();
    }

    /**
     * Feeds one decoded {@link Event} into the state machine.
     *
     * <p>This method is a pure dispatcher: it forwards the event to the matching
     * handler on the current state. None of the transition logic lives here &mdash;
     * that is the whole point of the State pattern.</p>
     *
     * @param e the event to handle
     */
    public void handle(Event e) {
        System.out.println("  event: " + e + "   (state: " + where() + ")");
        switch (e) {
            case LEFT_TAP:        state.onLeftTap(this);       break;
            case LEFT_DOUBLE_TAP: state.onLeftDoubleTap(this); break;
            case LEFT_HOLD_3S:    state.onLeftHold3s(this);    break;
            case LEFT_HOLD_5S:    state.onLeftHold5s(this);    break;
            case LEFT_HOLD_10S:   state.onLeftHold10s(this);   break;
            case RIGHT_TAP:       state.onRightTap(this);      break;
            case RIGHT_HOLD_3S:   state.onRightHold3s(this);   break;
            case FLIP_SWITCH:     state.onFlipSwitch(this);    break;
            default:              ignored(e);
        }
    }

    /**
     * Switches the rover into a new state and runs that state's entry action.
     *
     * <p>Called by the state classes themselves to perform a transition. The new
     * state's name is printed, then its {@link RoverState#onEntry(LunarRover)} runs
     * &mdash; which may immediately chain into a further transition (for example
     * Deaccelerating &rarr; Rest, or Capturing &rarr; Ready).</p>
     *
     * @param newState the state to switch into
     */
    public void setState(RoverState newState) {
        this.state = newState;
        System.out.println("      -> " + newState.name());
        newState.onEntry(this);
    }

    /**
     * Returns the rover's current state object.
     *
     * @return the current {@link RoverState}
     */
    public RoverState getState() {
        return state;
    }

    /**
     * Returns the display name of the current state, used by tests and output.
     *
     * @return the current state's name, e.g. {@code "DRIVE / Rest"}
     */
    public String getStateName() {
        return state.name();
    }

    /**
     * Returns the rover's current speed.
     *
     * @return the speed (positive forward, negative reverse, zero stopped)
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets the rover's speed directly. Used by the deaccelerating and flip-switch
     * logic that need to drive the speed to a specific value.
     *
     * @param speed the new speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Adjusts the rover's speed by a signed amount.
     *
     * @param delta the amount to add (negative to slow down or reverse)
     */
    public void changeSpeed(int delta) {
        this.speed += delta;
    }

    /**
     * Reports that an event had no effect in the current state, matching the
     * diagram's "unlisted events are ignored" rule.
     *
     * @param e the event that was ignored
     */
    public void ignored(Event e) {
        System.out.println("      (" + e + " ignored in " + where() + ")");
    }

    /**
     * Builds a human-readable description of the rover's current configuration,
     * appending the speed while in a movement (DRIVE) state.
     *
     * @return a description such as {@code "DRIVE / Rest (speed=0)"} or
     *         {@code "TOOLS / Idle"}
     */
    public String where() {
        if (state instanceof DriveState) {
            return state.name() + " (speed=" + speed + ")";
        }
        return state.name();
    }

    /**
     * Sample run &mdash; exercises every transition in the Assignment&nbsp;3 diagram,
     * now driven entirely through the State-pattern objects.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        LunarRover rover = new LunarRover();
        System.out.println("=== Lunar Rover State-Pattern demo ===");
        System.out.println("Initial state: " + rover.where());
        System.out.println();

        Event[] script = {
            // ---- DRIVE ----
            Event.LEFT_TAP,        // Rest -> Accelerating Forward
            Event.RIGHT_HOLD_3S,   // Accelerating Forward -> Constant Speed
            Event.RIGHT_TAP,       // Constant Speed -> Deaccelerating -> Rest
            Event.LEFT_HOLD_3S,    // Rest -> Accelerating Backward
            Event.RIGHT_TAP,       // Accelerating Backward -> Deaccelerating -> Rest
            Event.RIGHT_HOLD_3S,   // (ignored at Rest) — unlisted events are ignored

            Event.FLIP_SWITCH,     // DRIVE -> TOOLS (Idle)

            // ---- TOOLS: Color Camera ----
            Event.LEFT_HOLD_5S,    // Idle -> Color Camera (Ready)
            Event.LEFT_TAP,        // take picture (Capturing -> Ready)
            Event.LEFT_HOLD_5S,    // Temporizer countdown -> Capturing -> Ready
            Event.RIGHT_TAP,       // back to Idle

            // ---- TOOLS: 16-mm Camera ----
            Event.LEFT_HOLD_10S,   // Idle -> 16-mm Camera (Ready)
            Event.LEFT_TAP,        // take picture
            Event.RIGHT_TAP,       // back to Idle

            // ---- TOOLS: Drill ----
            Event.LEFT_DOUBLE_TAP, // Idle -> Drill (Off)
            Event.LEFT_TAP,        // Drill On
            Event.LEFT_TAP,        // Drill Off
            Event.RIGHT_TAP,       // back to Idle

            Event.FLIP_SWITCH      // TOOLS -> DRIVE (Rest)
        };

        int step = 1;
        for (Event e : script) {
            System.out.println("STEP " + step++ + ":");
            rover.handle(e);
            System.out.println();
        }
        System.out.println("Final state: " + rover.where());
    }
}
