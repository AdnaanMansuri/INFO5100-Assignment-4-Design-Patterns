package facadedesignpattern;

/**
 * The <b>Façade</b> for the shape subsystem.
 *
 * <p>The Façade pattern provides one simplified, high-level interface to a set of
 * finer-grained classes. Here the client never has to know about the
 * {@link Circle}, {@link Rectangle} and {@link Square} classes or how to build
 * them &mdash; it simply asks this façade to {@link #drawCircle()},
 * {@link #drawRectangle()} or {@link #drawSquare()}. The façade owns the concrete
 * objects and delegates each request to the right one.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class ShapeMakerFacade {

    /**
     * Pre-built circle the façade delegates circle requests to.
     * Kept as a field so the object is created once and reused.
     */
    private final Shape circle;

    /** Pre-built rectangle the façade delegates rectangle requests to. */
    private final Shape rectangle;

    /** Pre-built square the façade delegates square requests to. */
    private final Shape square;

    /**
     * Builds the façade and, with it, the whole shape subsystem.
     *
     * <p>All of the concrete shapes are instantiated here so the client is
     * completely shielded from that wiring.</p>
     */
    public ShapeMakerFacade() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
        this.square = new Square();
    }

    /**
     * Draws a circle through the façade.
     *
     * @return the circle's draw tag, {@code "Circle::draw()"}
     */
    public String drawCircle() {
        return circle.draw();
    }

    /**
     * Draws a rectangle through the façade.
     *
     * @return the rectangle's draw tag, {@code "Rectangle::draw()"}
     */
    public String drawRectangle() {
        return rectangle.draw();
    }

    /**
     * Draws a square through the façade.
     *
     * @return the square's draw tag, {@code "Square::draw()"}
     */
    public String drawSquare() {
        return square.draw();
    }
}
