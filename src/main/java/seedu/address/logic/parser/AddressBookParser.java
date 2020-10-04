package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeletePersonCommand;
import seedu.address.logic.commands.EditPersonCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern COMPLEX_COMMAND_FORMAT = Pattern.compile("(?<firstCommandWord>\\S+) (?<secondCommandWord>\\S+)(?<arguments>.*)");
    private static final Pattern SIMPLE_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {

        final Matcher simpleMatcher = SIMPLE_COMMAND_FORMAT.matcher(userInput.trim());
        final Matcher complexMatcher = COMPLEX_COMMAND_FORMAT.matcher(userInput.trim());

        if (simpleMatcher.matches()) {
            // Simple command
            return parseSimpleCommand(simpleMatcher);
        } else if (complexMatcher.matches()) {
            // Complex command
            return parseComplexCommand(complexMatcher);
        } else {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }
    }

    /**
     * Parses user input into complex command for execution.
     * This is to be used for commands with more than 1 command word.
     *
     * @param complexCommandMatcher Matcher that stores the complex command
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    private Command parseComplexCommand(Matcher complexCommandMatcher) throws ParseException {

        final String firstCommandWord = complexCommandMatcher.group("firstCommandWord");
        final String secondCommandWord = complexCommandMatcher.group("secondCommandWord");
        final String fullCommandWord = firstCommandWord + " " + secondCommandWord;
        final String arguments = complexCommandMatcher.group("arguments");
        switch (fullCommandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditPersonCommand.COMMAND_WORD:
            return new EditPersonCommandParser().parse(arguments);

        case DeletePersonCommand.COMMAND_WORD:
            return new DeletePersonCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    /**
     * Parses user input into simple command for execution.
     * This is to be used for commands with only 1 command word and no arguments.
     *
     * @param simpleCommandMatcher Matcher that stores the complex command
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    private Command parseSimpleCommand(Matcher simpleCommandMatcher) throws ParseException {
        final String commandWord = simpleCommandMatcher.group("commandWord");
        switch (commandWord) {

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
