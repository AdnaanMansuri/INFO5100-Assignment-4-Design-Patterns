package filterdesignpattern;

import java.util.List;

/**
 * A composite {@link Criteria} that applies two criteria in sequence, giving the
 * logical <b>AND</b> of them.
 *
 * <p>This is what makes the Filter pattern composable: an {@code AndCriteria} is
 * itself a {@code Criteria}, so it can be combined again with other rules.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class AndCriteria implements Criteria {

    /** The first rule to apply; its output is fed into {@link #other}. */
    private final Criteria criteria;

    /** The second rule, applied to whatever the first rule returned. */
    private final Criteria other;

    /**
     * Combines two criteria with a logical AND.
     *
     * @param criteria the first criterion to apply
     * @param other    the second criterion, applied to the first one's result
     */
    public AndCriteria(Criteria criteria, Criteria other) {
        this.criteria = criteria;
        this.other = other;
    }

    /**
     * Returns the people who satisfy <em>both</em> wrapped criteria.
     *
     * @param persons the candidates to test
     * @return the subset meeting both criteria
     */
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        return other.meetCriteria(firstCriteriaPersons);
    }
}
