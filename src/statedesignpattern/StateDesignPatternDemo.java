package statedesignpattern;

/**
 * Runnable demonstration of the State pattern.
 *
 * <p>A single {@link Context} is driven through the start and stop states; its
 * reported state changes even though the client only ever calls
 * {@code doAction} on state objects.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class StateDesignPatternDemo {

    /**
     * Program entry point.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        Context context = new Context();

        State startState = new StartState();
        startState.doAction(context);
        System.out.println("Current state: " + context.getState().getName());

        State stopState = new StopState();
        stopState.doAction(context);
        System.out.println("Current state: " + context.getState().getName());
    }
}
