package factorydesignpatterndemo;

/**
 * A concrete {@link Shape} product: a square.
 *
 * @author Adnaan
 * @version 1.0
 */
public class Square implements Shape {

    /**
     * Draws a square.
     *
     * @return the tag {@code "Square::draw()"}
     */
    @Override
    public String draw() {
        return "Square::draw()";
    }
}
