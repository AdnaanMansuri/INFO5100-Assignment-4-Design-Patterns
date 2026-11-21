package statedesignpattern;

/**
 * Common type for every state in the <b>State</b> behavioural pattern.
 *
 * <p>The State pattern lets an object alter its behaviour when its internal state
 * changes, so that the object appears to change its class. Each concrete state
 * ({@link StartState}, {@link StopState}) encapsulates the behaviour that belongs
 * to that state and knows how to install itself on the {@link Context}.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public interface State {

    /**
     * Performs this state's behaviour and makes the given context adopt this state.
     *
     * @param context the {@link Context} whose current state is being set
     */
    void doAction(Context context);

    /**
     * Returns a human-readable name for this state, used in assertions and output.
     *
     * @return the display name of the state, e.g. {@code "Start State"}
     */
    String getName();
}
