package filterdesignpattern;

import java.util.List;

/**
 * Common type for every filtering rule in the <b>Filter / Criteria</b> pattern.
 *
 * <p>The pattern lets a set of objects be filtered using different criteria and
 * then chained together in a decoupled way through logical operations. Because
 * every rule implements this one interface, rules can be combined
 * ({@link AndCriteria}, {@link OrCriteria}) without any rule knowing about the
 * others.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public interface Criteria {

    /**
     * Selects the people from the input list that satisfy this criterion.
     *
     * @param persons the list of candidates to test (not modified)
     * @return a new list containing only the people who meet this criterion
     */
    List<Person> meetCriteria(List<Person> persons);
}
