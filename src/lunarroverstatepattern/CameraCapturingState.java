package lunarroverstatepattern;

/**
 * Camera inner sub-state <b>Capturing</b>.
 *
 * <p>Transient: on entry it runs the {@code do / take picture} action and then, once
 * the capture is complete, returns to {@link CameraReadyState} for the same camera.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class CameraCapturingState extends ToolsState {

    /** The owning camera's display name, carried so the state can return to that camera's Ready. */
    private final String cameraName;

    /**
     * Creates the Capturing state for a specific camera.
     *
     * @param cameraName the display name of the camera this state belongs to
     */
    public CameraCapturingState(String cameraName) {
        this.cameraName = cameraName;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@code "TOOLS / <camera> / Capturing"}
     */
    @Override
    public String name() {
        return "TOOLS / " + cameraName + " / Capturing";
    }

    /**
     * Entry action: take the picture, then transition back to Ready
     * (guard {@code [capture complete]}).
     *
     * @param rover the rover context
     */
    @Override
    public void onEntry(LunarRover rover) {
        System.out.println("        *click* picture captured");
        rover.setState(new CameraReadyState(cameraName));
    }
}
