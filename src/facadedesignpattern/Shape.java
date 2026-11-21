package facadedesignpattern;

/**
 * Common type for every drawable shape in the Façade example.
 *
 * <p>Defining a single interface lets the {@link ShapeMakerFacade} treat all the
 * concrete shapes ({@link Circle}, {@link Rectangle}, {@link Square}) uniformly
 * while hiding their individual classes from client code.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public interface Shape {

    /**
     * Renders the shape.
     *
     * @return a short text tag identifying the concrete shape that was drawn,
     *         e.g. {@code "Circle::draw()"}
     */
    String draw();
}
