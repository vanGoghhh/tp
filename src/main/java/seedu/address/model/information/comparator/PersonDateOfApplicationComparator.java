package seedu.address.model.information.comparator;

import java.util.Comparator;

import seedu.address.model.information.Person;

/**
 * Compares any two {@code Person}'s {@code Date} using the the supplied sorting criteria.
 */
public class PersonDateOfApplicationComparator extends PersonComparator implements Comparator<Person> {

    public static final String SORT_CRITERIA = "doa";

    @Override
    public int compare(Person person1, Person person2) {
        return person1.getDateOfApplication().date.compareTo(person2.getDateOfApplication().date);
    }
}
