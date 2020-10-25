package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Comparator;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.information.Person;
import seedu.address.model.information.comparator.PersonComparator;

/**
 * Sorts the persons using the specified comparator.
 */
public class SortPersonCommand extends Command {

    public static final String COMMAND_WORD = "sort can";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the candidates in the address book.";

    public static final String MESSAGE_SUCCESS = "Successfully sorted people";

    public static final String MESSAGE_SORT_TYPE_INVALID = "Invalid Sort Type";

    private static final Logger logger = LogsCenter.getLogger(SortPersonCommand.class);

    private final Comparator<Person> comparator;

    /**
     * Constructor for SortPersonCommand. Checks the order of sort required
     * and producers the appropriate comparator.
     */
    public SortPersonCommand(Comparator<Person> comparator, Boolean isAscending) {
        assert (comparator != null);
        if (!isAscending) {
            this.comparator = comparator.reversed();
        } else {
            this.comparator = comparator;
        }
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.updateSortedPersonList(comparator);
        logger.info("Sorting People");
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SortPersonCommand)) {
            return false;
        }

        // state check
        SortPersonCommand s = (SortPersonCommand) other;
        return comparator.equals(s.comparator);
    }
}
