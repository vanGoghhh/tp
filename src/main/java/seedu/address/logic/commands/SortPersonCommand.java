package seedu.address.logic.commands;


import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.information.PersonComparator;

/**
 * Sorts the persons using the specified comparator.
 */
public class SortPersonCommand extends Command {

    public static final String COMMAND_WORD = "sort can";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the candidates in the address book.";

    public static final String MESSAGE_SUCCESS = "Successfully sorted people";

    private final PersonComparator comparator;

    public SortPersonCommand(PersonComparator comparator) {
        this.comparator = comparator;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.updateSortedPersonList(comparator);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
