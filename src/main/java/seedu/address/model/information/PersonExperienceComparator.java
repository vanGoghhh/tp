package seedu.address.model.information;

import java.util.Comparator;

/**
 * Compares any two {@code Person}'s {@code Experience} using the the supplied sorting criteria.
 */
public class PersonExperienceComparator implements Comparator<Person> {

    private final String sortCriteria;

    public PersonExperienceComparator(String sortCriteria) {
        this.sortCriteria = sortCriteria;
    }

    @Override
    public int compare(Person person1, Person person2) {

        double person1Experience = person1.getExperience().experienceInYears;
        double person2Experience = person2.getExperience().experienceInYears;

        if (person1Experience < person2Experience) {
            return -1;
        } else if (person1Experience > person2Experience) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof PersonExperienceComparator
                && sortCriteria.equals(((PersonExperienceComparator) other).sortCriteria));
    }


}
