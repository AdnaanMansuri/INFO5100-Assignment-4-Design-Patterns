package factorydesignpatterndemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * JUnit tests for {@link ShapeFactory}, the Factory pattern.
 *
 * <p>Because the factory returns objects, the tests compare the <em>runtime class</em>
 * of the object it builds against the expected concrete class.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class ShapeFactoryTest {

    /**
     * Default constructor.
     */
    public ShapeFactoryTest() {
    }

    /**
     * Test of getShape method, of class ShapeFactory, for a circle.
     */
    @Test
    public void testGetShapeCircle() {
        System.out.println("getShape - Circle");
        String shapeType = "CIRCLE";
        ShapeFactory instance = new ShapeFactory();

        Shape expResult = new Circle();
        Shape result = instance.getShape(shapeType);

        assertEquals(expResult.getClass(), result.getClass());
    }

    /**
     * Test of getShape method, of class ShapeFactory, for a rectangle.
     */
    @Test
    public void testGetShapeRectangle() {
        System.out.println("getShape - Rectangle");
        String shapeType = "RECTANGLE";
        ShapeFactory instance = new ShapeFactory();

        Shape expResult = new Rectangle();
        Shape result = instance.getShape(shapeType);

        assertEquals(expResult.getClass(), result.getClass());
    }

    /**
     * Test of getShape method, of class ShapeFactory, for a square, also proving the
     * lookup is case-insensitive.
     */
    @Test
    public void testGetShapeSquareCaseInsensitive() {
        System.out.println("getShape - Square (mixed case)");
        String shapeType = "SqUAre";
        ShapeFactory instance = new ShapeFactory();

        Shape expResult = new Square();
        Shape result = instance.getShape(shapeType);

        assertEquals(expResult.getClass(), result.getClass());
    }

    /**
     * Test of getShape method, of class ShapeFactory, verifying the produced object is
     * usable through the {@link Shape} interface.
     */
    @Test
    public void testGetShapeDraws() {
        System.out.println("getShape - draw()");
        ShapeFactory instance = new ShapeFactory();

        Shape result = instance.getShape("CIRCLE");
        assertTrue(result instanceof Shape);
        assertEquals("Circle::draw()", result.draw());
    }

    /**
     * Test of getShape method, of class ShapeFactory, for unknown / null input.
     */
    @Test
    public void testGetShapeInvalidReturnsNull() {
        System.out.println("getShape - invalid");
        ShapeFactory instance = new ShapeFactory();

        assertNull(instance.getShape("TRIANGLE"));
        assertNull(instance.getShape(null));
    }
}
