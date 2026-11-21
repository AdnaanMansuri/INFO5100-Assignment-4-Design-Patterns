package singletondesignpattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

/**
 * JUnit tests for {@link SingleObject}, the Singleton pattern.
 *
 * <p>For a Singleton the key property to prove is that only one object can ever
 * exist, so the central test checks that two {@code getInstance()} calls hand back
 * the very same reference.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class SingleObjectTest {

    /**
     * Default constructor.
     */
    public SingleObjectTest() {
    }

    /**
     * Test of getInstance method, of class SingleObject.
     *
     * <p>Verifies that repeated calls return one and the same, non-null instance,
     * which is the defining guarantee of the Singleton pattern.</p>
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");

        SingleObject expResult = SingleObject.getInstance();
        SingleObject result = SingleObject.getInstance();

        assertNotNull(result);
        assertEquals(expResult, result);
        assertSame("Both references must point to the same object", expResult, result);
    }

    /**
     * Test of showMessage method, of class SingleObject.
     *
     * <p>Verifies the message the singleton produces.</p>
     */
    @Test
    public void testShowMessage() {
        System.out.println("showMessage");

        SingleObject so = SingleObject.getInstance();
        String expResult = "Hello Singleton Class!";
        String result = so.showMessage();

        assertEquals(expResult, result);
    }
}
