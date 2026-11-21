package facadedesignpattern;

/**
 * A concrete {@link Shape} representing a circle.
 *
 * @author Adnaan
 * @version 1.0
 */
public class Circle implements Shape {

    /**
     * Draws a circle.
     *
     * @return the tag {@code "Circle::draw()"}
     */
    @Override
    public String draw() {
        return "Circle::draw()";
    }
}
