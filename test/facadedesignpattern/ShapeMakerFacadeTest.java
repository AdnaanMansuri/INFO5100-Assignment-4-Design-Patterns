package facadedesignpattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 * JUnit tests for {@link ShapeMakerFacade}, the Façade pattern.
 *
 * <p>Each test drives a shape purely through the façade and checks the returned draw
 * tag with a positive assertion and a matching negative assertion.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class ShapeMakerFacadeTest {

    /**
     * Default constructor.
     */
    public ShapeMakerFacadeTest() {
    }

    /**
     * Test of drawCircle method, of class ShapeMakerFacade.
     */
    @Test
    public void testDrawCircle() {
        System.out.println("drawCircle");
        ShapeMakerFacade instance = new ShapeMakerFacade();

        String expResult;
        String result;

        // positive
        expResult = "Circle::draw()";
        result = instance.drawCircle();
        assertEquals(expResult, result);

        // negative
        expResult = "Rectangle::draw()";
        result = instance.drawCircle();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of drawRectangle method, of class ShapeMakerFacade.
     */
    @Test
    public void testDrawRectangle() {
        System.out.println("drawRectangle");
        ShapeMakerFacade instance = new ShapeMakerFacade();

        String expResult;
        String result;

        // positive
        expResult = "Rectangle::draw()";
        result = instance.drawRectangle();
        assertEquals(expResult, result);

        // negative
        expResult = "Circle::draw()";
        result = instance.drawRectangle();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of drawSquare method, of class ShapeMakerFacade.
     */
    @Test
    public void testDrawSquare() {
        System.out.println("drawSquare");
        ShapeMakerFacade instance = new ShapeMakerFacade();

        String expResult;
        String result;

        // positive
        expResult = "Square::draw()";
        result = instance.drawSquare();
        assertEquals(expResult, result);

        // negative
        expResult = "Circle::draw()";
        result = instance.drawSquare();
        assertNotEquals(expResult, result);
    }
}
