package filterdesignpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Runnable demonstration of the Filter / Criteria pattern.
 *
 * <p>It builds a small population and prints the results of several criteria,
 * including AND / OR combinations.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class FilterDesignPatternDemo {

    /**
     * Program entry point.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Robert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singleOrFemale = new OrCriteria(single, female);

        System.out.println("Males: " + names(male.meetCriteria(persons)));
        System.out.println("Females: " + names(female.meetCriteria(persons)));
        System.out.println("Single: " + names(single.meetCriteria(persons)));
        System.out.println("Single Males: " + names(singleMale.meetCriteria(persons)));
        System.out.println("Single Or Females: " + names(singleOrFemale.meetCriteria(persons)));
    }

    /**
     * Joins the names of a list of people into a readable string.
     *
     * @param persons the people to list
     * @return a comma-separated string of their names
     */
    private static String names(List<Person> persons) {
        StringBuilder sb = new StringBuilder();
        for (Person person : persons) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(person.getName());
        }
        return sb.toString();
    }
}
