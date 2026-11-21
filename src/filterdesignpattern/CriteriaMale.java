package filterdesignpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link Criteria} that keeps only the male people.
 *
 * @author Adnaan
 * @version 1.0
 */
public class CriteriaMale implements Criteria {

    /**
     * Filters for a gender equal to {@code "Male"} (case-insensitive).
     *
     * @param persons the candidates to test
     * @return the subset whose gender is male
     */
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> males = new ArrayList<>();
        for (Person person : persons) {
            if ("Male".equalsIgnoreCase(person.getGender())) {
                males.add(person);
            }
        }
        return males;
    }
}
