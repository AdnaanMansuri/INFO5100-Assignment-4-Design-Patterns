package factorydesignpatterndemo;

/**
 * Common type for the products built by the {@link ShapeFactory}.
 *
 * <p>Because every product implements this one interface, the factory can hand
 * back any concrete shape as a {@code Shape}, and client code can use it without
 * knowing which concrete class was actually created.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public interface Shape {

    /**
     * Renders the shape.
     *
     * @return a short text tag identifying the concrete shape, e.g.
     *         {@code "Circle::draw()"}
     */
    String draw();
}
