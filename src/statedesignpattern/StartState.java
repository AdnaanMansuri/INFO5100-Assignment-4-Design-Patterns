package statedesignpattern;

/**
 * Concrete {@link State} representing a system that has been started.
 *
 * @author Adnaan
 * @version 1.0
 */
public class StartState implements State {

    /**
     * Marks the context as started and installs this state on it.
     *
     * @param context the {@link Context} to switch into the started state
     */
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    /**
     * {@inheritDoc}
     *
     * @return the literal {@code "Start State"}
     */
    @Override
    public String getName() {
        return "Start State";
    }
}
