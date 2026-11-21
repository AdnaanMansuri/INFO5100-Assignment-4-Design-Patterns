package statedesignpattern;

/**
 * The <b>Context</b> of the State pattern: the object whose behaviour depends on
 * its current {@link State}.
 *
 * <p>The context keeps a reference to a state object and delegates state-specific
 * work to it. Concrete states swap themselves in through {@link #setState(State)},
 * which is how the context's behaviour changes over time.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class Context {

    /**
     * The context's current state.
     *
     * <p>Starts as {@code null} to model "no state set yet"; it is assigned the
     * first time a concrete state's {@code doAction} runs. Holding the state as a
     * field (rather than, say, a boolean flag) is what allows new states to be
     * added without changing this class.</p>
     */
    private State state;

    /**
     * Creates a context with no state installed yet.
     */
    public Context() {
        this.state = null;
    }

    /**
     * Installs a new current state.
     *
     * @param state the state the context should now be in
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Returns the context's current state.
     *
     * @return the current {@link State}, or {@code null} if none has been set yet
     */
    public State getState() {
        return state;
    }
}
