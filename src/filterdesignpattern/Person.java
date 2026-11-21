package filterdesignpattern;

/**
 * A simple data object that the <b>Filter</b> (a.k.a. Criteria) pattern filters.
 *
 * <p>Each person carries just enough attributes &mdash; name, gender and marital
 * status &mdash; for the various criteria to select on.</p>
 *
 * @author Adnaan
 * @version 1.0
 */
public class Person {

    /** The person's name; used only for display and identification. */
    private final String name;

    /** The person's gender, e.g. {@code "Male"} or {@code "Female"}; a filter key. */
    private final String gender;

    /** The person's marital status, e.g. {@code "Single"} or {@code "Married"}; a filter key. */
    private final String maritalStatus;

    /**
     * Creates a person.
     *
     * @param name          the person's name
     * @param gender        the person's gender (filtered by {@link CriteriaMale} /
     *                      {@link CriteriaFemale})
     * @param maritalStatus the person's marital status (filtered by
     *                      {@link CriteriaSingle})
     */
    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    /**
     * Returns the person's name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the person's gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Returns the person's marital status.
     *
     * @return the marital status
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }
}
