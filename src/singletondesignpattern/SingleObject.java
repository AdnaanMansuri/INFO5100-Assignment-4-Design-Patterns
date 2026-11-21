package singletondesignpattern;

/**
 * Demonstrates the <b>Singleton</b> creational design pattern.
 *
 * <p>A Singleton guarantees that a class has <em>exactly one</em> instance and
 * provides a single, global point of access to it. This is useful for objects
 * that coordinate shared state or represent a unique resource (a configuration
 * registry, a logger, a connection pool, etc.) where creating more than one copy
 * would be wasteful or incorrect.</p>
 *
 * <p>The pattern is enforced here by three collaborating elements:</p>
 * <ul>
 *   <li>a {@code private static final} field that holds the one-and-only object,</li>
 *   <li>a {@code private} constructor so no other class can call {@code new}, and</li>
 *   <li>a {@code public static} accessor that always returns that same field.</li>
 * </ul>
 *
 * @author Adnaan
 * @version 1.0
 */
public class SingleObject {

    /**
     * The single shared instance of this class.
     *
     * <p>Declared {@code static} so it belongs to the class rather than to any
     * object, and {@code final} so the reference can never be reassigned. It is
     * created eagerly when the class is loaded, which makes the initialization
     * inherently thread-safe without any explicit locking.</p>
     */
    private static final SingleObject INSTANCE = new SingleObject();

    /**
     * Private constructor.
     *
     * <p>Made private precisely so that code outside this class cannot create
     * additional objects with {@code new SingleObject()}; the only way to obtain
     * the object is through {@link #getInstance()}.</p>
     */
    private SingleObject() {
    }

    /**
     * Returns the one shared instance of {@code SingleObject}.
     *
     * <p>Every call returns the very same object reference, which is what the
     * accompanying unit test verifies.</p>
     *
     * @return the single shared {@code SingleObject} instance (never {@code null})
     */
    public static SingleObject getInstance() {
        return INSTANCE;
    }

    /**
     * Produces a demonstration message from the singleton.
     *
     * @return the fixed greeting {@code "Hello Singleton Class!"}
     */
    public String showMessage() {
        return "Hello Singleton Class!";
    }
}
