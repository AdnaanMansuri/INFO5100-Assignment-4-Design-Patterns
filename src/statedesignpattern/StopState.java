package statedesignpattern;

/**
 * Concrete {@link State} representing a system that has been stopped.
 *
 * @author Adnaan
 * @version 1.0
 */
public class StopState implements State {

    /**
     * Marks the context as stopped and installs this state on it.
     *
     * @param context the {@link Context} to switch into the stopped state
     */
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    /**
     * {@inheritDoc}
     *
     * @return the literal {@code "Stop State"}
     */
    @Override
    public String getName() {
        return "Stop State";
    }
}
