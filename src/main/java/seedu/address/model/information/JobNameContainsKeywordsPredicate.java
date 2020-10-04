package seedu.address.model.information;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Job}'s {@code Name} matches any of the keywords given.
 */
public class JobNameContainsKeywordsPredicate implements Predicate<Job> {
    private final List<String> keywords;

    public JobNameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Job job) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(job.getJobTitle().fullName, keyword)
                        || StringUtil.containsWordIgnoreCase(job.getCompanyName().fullName, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof JobNameContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((JobNameContainsKeywordsPredicate) other).keywords)); // state check
    }

}
