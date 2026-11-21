package lunarroverstatepattern;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the State-pattern Lunar Rover (Assignment&nbsp;4, Part&nbsp;II).
 *
 * <p>Each test feeds a sequence of {@link Event}s into a fresh {@link LunarRover} and
 * asserts the resulting state name (and, where it matters, the speed). Together they
 * cover the DRIVE movement cycle, the mode switch, both cameras, the drill, and the
 * "unlisted events are ignored" rule.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class LunarRoverTest {

    /** Fresh rover for each test. */
    private LunarRover rover;

    /**
     * Default constructor.
     */
    public LunarRoverTest() {
    }

    /**
     * Creates a new rover before each test so tests never share state.
     */
    @Before
    public void setUp() {
        rover = new LunarRover();
    }

    /**
     * Feeds a series of events to the rover under test.
     *
     * @param events the events to apply in order
     */
    private void send(Event... events) {
        for (Event e : events) {
            rover.handle(e);
        }
    }

    /**
     * A brand-new rover starts in DRIVE / Rest with speed 0.
     */
    @Test
    public void testInitialState() {
        assertEquals("DRIVE / Rest", rover.getStateName());
        assertEquals(0, rover.getSpeed());
    }

    /**
     * Rest -> Accelerating Forward on a left tap, and speed increases.
     */
    @Test
    public void testRestToAcceleratingForward() {
        send(Event.LEFT_TAP);
        assertEquals("DRIVE / Accelerating Forward", rover.getStateName());
        assertEquals(LunarRover.ACCEL_STEP, rover.getSpeed());
    }

    /**
     * Accelerating Forward -> Constant Speed on a right hold &gt; 3 s.
     */
    @Test
    public void testAcceleratingForwardToConstantSpeed() {
        send(Event.LEFT_TAP, Event.RIGHT_HOLD_3S);
        assertEquals("DRIVE / Constant Speed", rover.getStateName());
        assertEquals(LunarRover.ACCEL_STEP, rover.getSpeed());
    }

    /**
     * A right tap deaccelerates and the completion transition returns to Rest at
     * speed 0.
     */
    @Test
    public void testRightTapDeacceleratesToRest() {
        send(Event.LEFT_TAP, Event.RIGHT_HOLD_3S, Event.RIGHT_TAP);
        assertEquals("DRIVE / Rest", rover.getStateName());
        assertEquals(0, rover.getSpeed());
    }

    /**
     * Rest -> Accelerating Backward on a left hold &gt; 3 s; speed goes negative, then
     * a right tap stops the rover back at Rest.
     */
    @Test
    public void testReverseThenStop() {
        send(Event.LEFT_HOLD_3S);
        assertEquals("DRIVE / Accelerating Backward", rover.getStateName());
        assertEquals(-LunarRover.ACCEL_STEP, rover.getSpeed());

        send(Event.RIGHT_TAP);
        assertEquals("DRIVE / Rest", rover.getStateName());
        assertEquals(0, rover.getSpeed());
    }

    /**
     * An event that is not listed for the current state is ignored and leaves the
     * state unchanged.
     */
    @Test
    public void testUnlistedEventIsIgnored() {
        send(Event.RIGHT_HOLD_3S); // not valid at Rest
        assertEquals("DRIVE / Rest", rover.getStateName());
        assertEquals(0, rover.getSpeed());
    }

    /**
     * Flipping the switch from DRIVE stops the rover and enters TOOLS / Idle.
     */
    @Test
    public void testFlipSwitchEntersTools() {
        send(Event.LEFT_TAP, Event.FLIP_SWITCH);
        assertEquals("TOOLS / Idle", rover.getStateName());
        assertEquals(0, rover.getSpeed());
    }

    /**
     * From Idle, a 5-second hold selects the colour camera (Ready).
     */
    @Test
    public void testSelectColorCamera() {
        send(Event.FLIP_SWITCH, Event.LEFT_HOLD_5S);
        assertEquals("TOOLS / Color Camera / Ready", rover.getStateName());
    }

    /**
     * From Idle, a 10-second hold selects the 16-mm camera (Ready).
     */
    @Test
    public void testSelectSixteenMmCamera() {
        send(Event.FLIP_SWITCH, Event.LEFT_HOLD_10S);
        assertEquals("TOOLS / 16-mm Camera / Ready", rover.getStateName());
    }

    /**
     * Taking a picture (left tap) runs through Capturing and auto-returns to Ready.
     */
    @Test
    public void testCameraCaptureReturnsToReady() {
        send(Event.FLIP_SWITCH, Event.LEFT_HOLD_5S, Event.LEFT_TAP);
        assertEquals("TOOLS / Color Camera / Ready", rover.getStateName());
    }

    /**
     * The self-timer (5-second hold in Ready) runs Temporizer -> Capturing -> Ready.
     */
    @Test
    public void testCameraTemporizerReturnsToReady() {
        send(Event.FLIP_SWITCH, Event.LEFT_HOLD_5S, Event.LEFT_HOLD_5S);
        assertEquals("TOOLS / Color Camera / Ready", rover.getStateName());
    }

    /**
     * A right tap inside a camera returns to Idle.
     */
    @Test
    public void testCameraRightTapReturnsToIdle() {
        send(Event.FLIP_SWITCH, Event.LEFT_HOLD_5S, Event.RIGHT_TAP);
        assertEquals("TOOLS / Idle", rover.getStateName());
    }

    /**
     * The drill: double-tap selects it (Off), then left taps toggle On / Off.
     */
    @Test
    public void testDrillToggle() {
        send(Event.FLIP_SWITCH, Event.LEFT_DOUBLE_TAP);
        assertEquals("TOOLS / Drill / Off", rover.getStateName());

        send(Event.LEFT_TAP);
        assertEquals("TOOLS / Drill / On", rover.getStateName());

        send(Event.LEFT_TAP);
        assertEquals("TOOLS / Drill / Off", rover.getStateName());
    }

    /**
     * Leaving the drill (right tap) returns to Idle, powering the motor off on exit.
     */
    @Test
    public void testDrillExitReturnsToIdle() {
        send(Event.FLIP_SWITCH, Event.LEFT_DOUBLE_TAP, Event.LEFT_TAP, Event.RIGHT_TAP);
        assertEquals("TOOLS / Idle", rover.getStateName());
    }

    /**
     * Flipping the switch back from TOOLS restarts DRIVE at Rest.
     */
    @Test
    public void testFlipBackToDrive() {
        send(Event.FLIP_SWITCH, Event.FLIP_SWITCH);
        assertEquals("DRIVE / Rest", rover.getStateName());
        assertEquals(0, rover.getSpeed());
    }
}
