package facadedesignpattern;

/**
 * A concrete {@link Shape} representing a rectangle.
 *
 * @author Adnaan
 * @version 1.0
 */
public class Rectangle implements Shape {

    /**
     * Draws a rectangle.
     *
     * @return the tag {@code "Rectangle::draw()"}
     */
    @Override
    public String draw() {
        return "Rectangle::draw()";
    }
}
