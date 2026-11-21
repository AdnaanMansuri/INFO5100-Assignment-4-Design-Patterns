package filterdesignpattern;

import java.util.List;

/**
 * A composite {@link Criteria} that unions the results of two criteria, giving the
 * logical <b>OR</b> of them.
 *
 * <p>Like {@link AndCriteria}, this is itself a {@code Criteria} and can be nested
 * inside further combinations.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class OrCriteria implements Criteria {

    /** The first rule whose matches are included. */
    private final Criteria criteria;

    /** The second rule whose matches are added if not already present. */
    private final Criteria other;

    /**
     * Combines two criteria with a logical OR.
     *
     * @param criteria the first criterion
     * @param other    the second criterion
     */
    public OrCriteria(Criteria criteria, Criteria other) {
        this.criteria = criteria;
        this.other = other;
    }

    /**
     * Returns the people who satisfy <em>either</em> wrapped criterion, with no
     * duplicates.
     *
     * @param persons the candidates to test
     * @return the union of the two criteria's results
     */
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaItems = criteria.meetCriteria(persons);
        List<Person> otherCriteriaItems = other.meetCriteria(persons);

        for (Person person : otherCriteriaItems) {
            if (!firstCriteriaItems.contains(person)) {
                firstCriteriaItems.add(person);
            }
        }
        return firstCriteriaItems;
    }
}
