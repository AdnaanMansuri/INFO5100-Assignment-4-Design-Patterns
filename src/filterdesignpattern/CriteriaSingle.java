package filterdesignpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link Criteria} that keeps only the single people.
 *
 * @author Adnaan
 * @version 1.0
 */
public class CriteriaSingle implements Criteria {

    /**
     * Filters for a marital status equal to {@code "Single"} (case-insensitive).
     *
     * @param persons the candidates to test
     * @return the subset whose marital status is single
     */
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singles = new ArrayList<>();
        for (Person person : persons) {
            if ("Single".equalsIgnoreCase(person.getMaritalStatus())) {
                singles.add(person);
            }
        }
        return singles;
    }
}
