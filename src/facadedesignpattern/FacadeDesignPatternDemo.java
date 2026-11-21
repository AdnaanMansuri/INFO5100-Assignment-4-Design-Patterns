package facadedesignpattern;

/**
 * Runnable demonstration of the {@link ShapeMakerFacade} Façade pattern.
 *
 * <p>The client talks only to the façade; it never references {@link Circle},
 * {@link Rectangle} or {@link Square} directly.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class FacadeDesignPatternDemo {

    /**
     * Program entry point.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        ShapeMakerFacade shapeMaker = new ShapeMakerFacade();

        System.out.println(shapeMaker.drawCircle());
        System.out.println(shapeMaker.drawRectangle());
        System.out.println(shapeMaker.drawSquare());
    }
}
