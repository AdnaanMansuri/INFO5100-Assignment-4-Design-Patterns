package lunarroverstatepattern;

/**
 * Camera inner sub-state <b>Temporizer</b> (the self-timer).
 *
 * <p>Transient: on entry it counts down and then, after the delay, transitions to
 * {@link CameraCapturingState} &mdash; which in turn takes the picture and returns
 * the camera to Ready.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class CameraTemporizerState extends ToolsState {

    /** The owning camera's display name, carried through to the capturing state. */
    private final String cameraName;

    /**
     * Creates the Temporizer state for a specific camera.
     *
     * @param cameraName the display name of the camera this state belongs to
     */
    public CameraTemporizerState(String cameraName) {
        this.cameraName = cameraName;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@code "TOOLS / <camera> / Temporizer"}
     */
    @Override
    public String name() {
        return "TOOLS / " + cameraName + " / Temporizer";
    }

    /**
     * Entry action: count down, then transition to Capturing
     * (guard {@code [after delay]}).
     *
     * @param rover the rover context
     */
    @Override
    public void onEntry(LunarRover rover) {
        System.out.println("        do: count down");
        for (int t = 3; t >= 1; t--) {
            System.out.println("        countdown " + t + "...");
        }
        rover.setState(new CameraCapturingState(cameraName));
    }
}
