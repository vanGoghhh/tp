package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindPersonCommand;
import seedu.address.model.information.Person;
import seedu.address.model.information.predicate.PersonNameContainsKeywordsPredicate;

public class FindPersonCommandParserTest {

    private FindPersonCommandParser parser = new FindPersonCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindPersonCommand.MESSAGE_USAGE));
    }

    /*
    @Test
    public void parse_validArgs_returnsFindCommand() {
        // no leading and trailing whitespaces
        FindPersonCommand expectedFindPersonCommand =
                new FindPersonCommand((new Predicate<Person>() {
                    @Override
                    public boolean test(Person person) {
                        return true;
                    }
                }).and(new PersonNameContainsKeywordsPredicate(Arrays.asList("Alice", "Bob"))));
        assertParseSuccess(parser, "find can n/Alice Bob", expectedFindPersonCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n Alice Bob \n \t Bob  \t", expectedFindPersonCommand);
    }

     */
}
