package lunarroverstatepattern;

/**
 * Camera inner sub-state <b>Ready</b>, shared by both the colour camera and the
 * 16-mm camera.
 *
 * <p>Rather than duplicate three inner states for each camera, the camera's name is
 * carried as a field so a single set of camera-state classes serves both devices
 * &mdash; the two cameras have identical inner behaviour in the diagram.</p>
 *
 * <p>From Ready: a left tap takes a picture, a 5-second hold starts the self-timer,
 * and a right tap leaves the camera and returns to {@link IdleState}.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class CameraReadyState extends ToolsState {

    /**
     * The owning camera's display name, e.g. {@code "Color Camera"} or
     * {@code "16-mm Camera"}. Stored so one class can represent the Ready state of
     * either camera.
     */
    private final String cameraName;

    /**
     * Creates the Ready state for a specific camera.
     *
     * @param cameraName the display name of the camera this state belongs to
     */
    public CameraReadyState(String cameraName) {
        this.cameraName = cameraName;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@code "TOOLS / <camera> / Ready"}
     */
    @Override
    public String name() {
        return "TOOLS / " + cameraName + " / Ready";
    }

    /**
     * Left tap takes a single picture.
     *
     * @param rover the rover context
     */
    @Override
    public void onLeftTap(LunarRover rover) {
        rover.setState(new CameraCapturingState(cameraName));
    }

    /**
     * Left pedal held ~5 s starts the self-timer (temporizer).
     *
     * @param rover the rover context
     */
    @Override
    public void onLeftHold5s(LunarRover rover) {
        rover.setState(new CameraTemporizerState(cameraName));
    }

    /**
     * Right tap leaves the camera and returns to Idle.
     *
     * @param rover the rover context
     */
    @Override
    public void onRightTap(LunarRover rover) {
        rover.setState(new IdleState());
    }
}
