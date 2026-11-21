package factorydesignpatterndemo;

/**
 * Runnable demonstration of the {@link ShapeFactory} Factory pattern.
 *
 * <p>The client asks the factory for shapes by name and draws whatever comes
 * back, without ever constructing a concrete shape itself.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class FactoryDesignPatternDemo {

    /**
     * Program entry point.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape("CIRCLE");
        System.out.println(circle.draw());

        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        System.out.println(rectangle.draw());

        Shape square = shapeFactory.getShape("SQUARE");
        System.out.println(square.draw());
    }
}
