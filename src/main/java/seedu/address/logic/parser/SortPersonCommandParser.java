package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import seedu.address.logic.commands.SortPersonCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.information.PersonComparator;
import seedu.address.model.information.PersonExperienceComparator;

/**
 * Parses input arguments and creates a sort command object.
 */
public class SortPersonCommandParser implements Parser<SortPersonCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SortCommand
     * and returns a SortCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format.
     */
    public SortPersonCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            SortPersonCommand.MESSAGE_USAGE));
        }

        String sortCriteria = trimmedArgs.split("\\s")[0];

        PersonComparator comparatorToBeUsed = selectComparator(sortCriteria);
        return new SortPersonCommand(comparatorToBeUsed);
    }

    private PersonComparator selectComparator(String sortCriteria) throws ParseException {

        switch (sortCriteria) {

        case PersonExperienceComparator.SORT_CRITERIA:
            return new PersonExperienceComparator();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }
}
