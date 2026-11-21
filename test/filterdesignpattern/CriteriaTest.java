package filterdesignpattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the Filter / Criteria pattern.
 *
 * <p>A fixed population is built before each test; each test then applies a criterion
 * (or a combination) and checks how many people and which people come back.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class CriteriaTest {

    /** Shared test population, rebuilt fresh before every test. */
    private List<Person> persons;

    /**
     * Default constructor.
     */
    public CriteriaTest() {
    }

    /**
     * Builds the population used by every test: 4 males / 2 females, 4 single / 2
     * married.
     */
    @Before
    public void setUp() {
        persons = new ArrayList<>();
        persons.add(new Person("Robert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));
    }

    /**
     * Test of meetCriteria method, of class CriteriaMale.
     */
    @Test
    public void testMale() {
        System.out.println("meetCriteria - Male");
        Criteria male = new CriteriaMale();
        List<Person> result = male.meetCriteria(persons);
        assertEquals(4, result.size());
        for (Person p : result) {
            assertEquals("Male", p.getGender());
        }
    }

    /**
     * Test of meetCriteria method, of class CriteriaFemale.
     */
    @Test
    public void testFemale() {
        System.out.println("meetCriteria - Female");
        Criteria female = new CriteriaFemale();
        List<Person> result = female.meetCriteria(persons);
        assertEquals(2, result.size());
        for (Person p : result) {
            assertEquals("Female", p.getGender());
        }
    }

    /**
     * Test of meetCriteria method, of class CriteriaSingle.
     */
    @Test
    public void testSingle() {
        System.out.println("meetCriteria - Single");
        Criteria single = new CriteriaSingle();
        List<Person> result = single.meetCriteria(persons);
        assertEquals(4, result.size());
        for (Person p : result) {
            assertEquals("Single", p.getMaritalStatus());
        }
    }

    /**
     * Test of meetCriteria method, of class AndCriteria (single AND male).
     */
    @Test
    public void testAndSingleMale() {
        System.out.println("meetCriteria - Single AND Male");
        Criteria singleMale = new AndCriteria(new CriteriaSingle(), new CriteriaMale());
        List<Person> result = singleMale.meetCriteria(persons);
        assertEquals(3, result.size()); // Robert, Mike, Bobby
        for (Person p : result) {
            assertEquals("Male", p.getGender());
            assertEquals("Single", p.getMaritalStatus());
        }
    }

    /**
     * Test of meetCriteria method, of class OrCriteria (single OR female).
     */
    @Test
    public void testOrSingleFemale() {
        System.out.println("meetCriteria - Single OR Female");
        Criteria singleOrFemale = new OrCriteria(new CriteriaSingle(), new CriteriaFemale());
        List<Person> result = singleOrFemale.meetCriteria(persons);
        // 4 singles (Robert, Diana, Mike, Bobby) + Laura (female, married) = 5
        assertEquals(5, result.size());
        for (Person p : result) {
            assertTrue("Single".equalsIgnoreCase(p.getMaritalStatus())
                    || "Female".equalsIgnoreCase(p.getGender()));
        }
    }
}
