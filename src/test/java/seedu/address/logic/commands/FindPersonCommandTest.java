package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalJobs.getTypicalJobAddressBook;
import static seedu.address.testutil.TypicalPersons.getTypicalPersonAddressBook;

import java.util.Collections;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.information.Person;
import seedu.address.model.information.predicate.PersonEmailContainsKeywordsPredicate;
import seedu.address.model.information.predicate.PersonNameContainsKeywordsPredicate;
import seedu.address.model.information.predicate.PersonPhoneContainsKeywordsPredicate;

/**
 * Contains integration tests (interaction with the Model) for {@code FindCommand}.
 */
public class FindPersonCommandTest {
    private Model model = new ModelManager(getTypicalPersonAddressBook(), getTypicalJobAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalPersonAddressBook(), getTypicalJobAddressBook(),
            new UserPrefs());

    @Test
    public void equals() {
        Predicate<Person> firstPredicate = unused -> true;
        firstPredicate.and(new PersonNameContainsKeywordsPredicate(Collections.singletonList("Alice")));
        Predicate<Person> secondPredicate = unused -> true;
        secondPredicate.and(new PersonNameContainsKeywordsPredicate(Collections.singletonList("Bob")));

        FindPersonCommand findFirstCommand = new FindPersonCommand(firstPredicate);
        FindPersonCommand findSecondCommand = new FindPersonCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        FindPersonCommand findFirstCommandCopy = new FindPersonCommand(firstPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }

    @Test
    public void execute_nullModel_throwsNullPointerException() {
        Predicate<Person> predicate = unused -> true;
        predicate.and(new PersonNameContainsKeywordsPredicate(Collections.singletonList("Alice")));
        FindPersonCommand command = new FindPersonCommand(predicate);
        assertThrows(NullPointerException.class, () -> command.execute(null));
    }

    @Test
    public void execute_predicateAcceptedByModel_findSuccessful() {
        // matching keyword found
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 7);
        Predicate<Person> firstPredicate = unused -> true;
        firstPredicate = firstPredicate.and(new PersonEmailContainsKeywordsPredicate(Collections.singletonList("@")));
        FindPersonCommand command = new FindPersonCommand(firstPredicate);
        expectedModel.updateFilteredPersonList(firstPredicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(expectedModel.getFilteredPersonList(), model.getFilteredPersonList());

        // no matching keyword found
        expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 0);
        Predicate<Person> secondPredicate = unused -> true;
        secondPredicate = secondPredicate.and(new PersonPhoneContainsKeywordsPredicate(Collections.singletonList("00000000")));
        command = new FindPersonCommand(secondPredicate);
        expectedModel.updateFilteredPersonList(secondPredicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(expectedModel.getFilteredPersonList(), model.getFilteredPersonList());
    }
}
