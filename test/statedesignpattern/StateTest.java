package statedesignpattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * JUnit tests for the State pattern ({@link State}, {@link StartState},
 * {@link StopState}, {@link Context}).
 *
 * <p>The tests confirm that calling a concrete state's {@code doAction} makes the
 * context report that state, which is how the State pattern changes behaviour.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class StateTest {

    /**
     * Default constructor.
     */
    public StateTest() {
    }

    /**
     * Test that a brand-new context has no state installed yet.
     */
    @Test
    public void testContextInitialStateIsNull() {
        System.out.println("initial state");
        Context context = new Context();
        assertNull(context.getState());
    }

    /**
     * Test of doAction method, of class StartState.
     */
    @Test
    public void testDoActionStartState() {
        System.out.println("doAction - StartState");
        Context context = new Context();

        State startState = new StartState();
        startState.doAction(context);

        assertTrue(context.getState() instanceof StartState);
        assertEquals("Start State", context.getState().getName());
    }

    /**
     * Test of doAction method, of class StopState.
     */
    @Test
    public void testDoActionStopState() {
        System.out.println("doAction - StopState");
        Context context = new Context();

        State stopState = new StopState();
        stopState.doAction(context);

        assertTrue(context.getState() instanceof StopState);
        assertEquals("Stop State", context.getState().getName());
    }

    /**
     * Test that the context's state actually changes when moving from start to stop.
     */
    @Test
    public void testTransitionStartToStop() {
        System.out.println("transition start -> stop");
        Context context = new Context();

        new StartState().doAction(context);
        assertEquals("Start State", context.getState().getName());

        new StopState().doAction(context);
        assertEquals("Stop State", context.getState().getName());
    }
}
