package filterdesignpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link Criteria} that keeps only the female people.
 *
 * @author Adnaan
 * @version 1.0
 */
public class CriteriaFemale implements Criteria {

    /**
     * Filters for a gender equal to {@code "Female"} (case-insensitive).
     *
     * @param persons the candidates to test
     * @return the subset whose gender is female
     */
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> females = new ArrayList<>();
        for (Person person : persons) {
            if ("Female".equalsIgnoreCase(person.getGender())) {
                females.add(person);
            }
        }
        return females;
    }
}
