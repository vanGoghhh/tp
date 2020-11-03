package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ViewJobCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input and creates a new ViewPersonCommand object.
 */
public class ViewJobCommandParser implements Parser<ViewJobCommand> {

    public ViewJobCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new ViewJobCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewJobCommand.MESSAGE_USAGE), pe);
        }
    }
}
