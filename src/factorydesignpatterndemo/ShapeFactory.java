package factorydesignpatterndemo;

/**
 * The <b>Factory</b> that creates {@link Shape} objects.
 *
 * <p>The Factory pattern moves the {@code new} decision out of the client and into
 * one place. The client passes a descriptive string and receives a ready-made
 * object, never naming a concrete class such as {@link Circle} itself. Adding a new
 * shape later means editing only this factory, not every call site.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class ShapeFactory {

    /**
     * Creates and returns a {@link Shape} for the requested type.
     *
     * <p>The comparison is case-insensitive, so {@code "circle"}, {@code "Circle"}
     * and {@code "CIRCLE"} all produce a {@link Circle}.</p>
     *
     * @param shapeType the kind of shape to build; one of {@code "CIRCLE"},
     *                  {@code "RECTANGLE"} or {@code "SQUARE"} (any letter case)
     * @return a new {@link Shape} of the requested type, or {@code null} if
     *         {@code shapeType} is {@code null} or not recognised
     */
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
