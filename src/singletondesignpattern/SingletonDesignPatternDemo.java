package singletondesignpattern;

/**
 * Runnable demonstration of the {@link SingleObject} Singleton pattern.
 *
 * <p>It fetches the singleton twice and shows that both references point to the
 * same object, then prints the singleton's message.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class SingletonDesignPatternDemo {

    /**
     * Program entry point.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        SingleObject first = SingleObject.getInstance();
        SingleObject second = SingleObject.getInstance();

        System.out.println("first  = " + first);
        System.out.println("second = " + second);
        System.out.println("Same object? " + (first == second));
        System.out.println("Message    : " + first.showMessage());
    }
}
