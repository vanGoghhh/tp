package seedu.address.model.information.predicate;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.information.Person;

/**
 * Tests that a {@code Person}'s {@code Experience} matches any of the keywords given.
 */
public class PersonExperienceContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public PersonExperienceContainsKeywordsPredicate(List<String> keywords) {
        assert keywords.stream().allMatch(x -> Double.parseDouble(x) >= 0) : "invalid years of experience";
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .allMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getExperience().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PersonExperienceContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((PersonExperienceContainsKeywordsPredicate) other).keywords)); // state check
    }

}
