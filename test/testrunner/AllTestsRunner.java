package testrunner;

import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Convenience runner that executes every JUnit test class in the project and prints
 * a per-pattern pass/fail summary.
 *
 * <p>While each test class runs, the tests' own {@code System.out} output is
 * temporarily silenced so the final summary reads like the green/red bar of an IDE's
 * JUnit panel. This is only a reporting aid; the tests themselves are ordinary JUnit 4
 * tests that can also be run one class at a time from any IDE.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class AllTestsRunner {

    /**
     * Runs all test classes and prints a summary.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        Class<?>[] tests = {
            singletondesignpattern.SingleObjectTest.class,
            facadedesignpattern.ShapeMakerFacadeTest.class,
            factorydesignpatterndemo.ShapeFactoryTest.class,
            statedesignpattern.StateTest.class,
            filterdesignpattern.CriteriaTest.class,
            lunarroverstatepattern.LunarRoverTest.class
        };

        System.out.println("================ JUnit test run ================");
        PrintStream realOut = System.out;
        int totalRun = 0;
        int totalFail = 0;

        for (Class<?> t : tests) {
            // Silence test chatter so the summary stays clean.
            System.setOut(new PrintStream(new OutputStream() {
                @Override
                public void write(int b) {
                    // discard
                }
            }));
            Result r = JUnitCore.runClasses(t);
            System.setOut(realOut);

            totalRun += r.getRunCount();
            totalFail += r.getFailureCount();
            System.out.printf("%-30s  tests=%2d  failures=%d   %s%n",
                    t.getSimpleName(), r.getRunCount(), r.getFailureCount(),
                    r.wasSuccessful() ? "PASS" : "FAIL");
            for (Failure f : r.getFailures()) {
                System.out.println("    FAILED: " + f.getTestHeader() + " -> " + f.getMessage());
            }
        }

        System.out.println("------------------------------------------------");
        System.out.printf("TOTAL   tests=%d   failures=%d   ->   %s%n",
                totalRun, totalFail, (totalFail == 0 ? "ALL TESTS PASS" : "SOME TESTS FAILED"));
        System.out.println("================================================");
    }
}
