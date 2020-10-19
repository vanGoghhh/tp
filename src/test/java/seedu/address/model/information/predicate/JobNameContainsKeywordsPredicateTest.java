package seedu.address.model.information.predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.information.predicate.JobNameContainsKeywordsPredicate;
import seedu.address.testutil.JobBuilder;

public class JobNameContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        JobNameContainsKeywordsPredicate firstPredicate =
                new JobNameContainsKeywordsPredicate(firstPredicateKeywordList);
        JobNameContainsKeywordsPredicate secondPredicate =
                new JobNameContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        JobNameContainsKeywordsPredicate firstPredicateCopy =
                new JobNameContainsKeywordsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_nameContainsKeywords_returnsTrue() {
        // One keyword
        JobNameContainsKeywordsPredicate predicate =
                new JobNameContainsKeywordsPredicate(Collections.singletonList("Google"));
        assertTrue(predicate.test(new JobBuilder().withCompanyName("Google").build()));

        // Multiple keywords
        predicate = new JobNameContainsKeywordsPredicate(Arrays.asList("Google", "Software", "engineer"));
        assertTrue(predicate.test(new JobBuilder().withCompanyName("Google")
                .withJobTitle("Software engineer").build()));

        // Only one matching keyword
        predicate = new JobNameContainsKeywordsPredicate(Arrays.asList("Google", "Facebook"));
        assertTrue(predicate.test(new JobBuilder().withCompanyName("Google").build()));

        // Mixed-case keywords
        predicate = new JobNameContainsKeywordsPredicate(Arrays.asList("gOOgLe", "sOftWaRE", "enGiNEer"));
        assertTrue(predicate.test(new JobBuilder().withCompanyName("Google")
                .withJobTitle("Software engineer").build()));
    }

    @Test
    public void test_nameDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        JobNameContainsKeywordsPredicate predicate =
                new JobNameContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new JobBuilder().withCompanyName("Google").build()));

        // Non-matching keyword
        predicate = new JobNameContainsKeywordsPredicate(Arrays.asList("Facebook"));
        assertFalse(predicate.test(new JobBuilder().withCompanyName("Google").build()));

        // Keywords match phone, email and address, but does not match job title and company name
        predicate =
                new JobNameContainsKeywordsPredicate(Arrays.asList("Facebook", "Human", "Resource", "91111111",
                        "hr@gmail.com", "Pasir", "Ris"));
        assertFalse(predicate.test(new JobBuilder().withCompanyName("Google").withJobTitle("Marketing Personnel")
                .withEmail("hr@gmail.com").withPhone("91111111").withAddress("Pasir Ris").build()));
    }
}
