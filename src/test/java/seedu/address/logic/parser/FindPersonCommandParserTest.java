package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.EXPERIENCE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EXPERIENCE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.FindPersonCommand;
import seedu.address.model.information.Person;
import seedu.address.model.information.predicate.PersonEmailContainsKeywordsPredicate;
import seedu.address.model.information.predicate.PersonExperienceContainsKeywordsPredicate;
import seedu.address.model.information.predicate.PersonNameContainsKeywordsPredicate;
import seedu.address.model.information.predicate.PersonPhoneContainsKeywordsPredicate;

public class FindPersonCommandParserTest {

    private FindPersonCommandParser parser = new FindPersonCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindPersonCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_emptyPreamble_throwsParseException() {
        assertParseFailure(parser, "n/Alice",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindPersonCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindPersonCommand() {

        // one field
        List<Predicate<Person>> predicates = new ArrayList<>();
        predicates.add(new PersonNameContainsKeywordsPredicate(Collections.singletonList(VALID_NAME_AMY)));
        Command expectedFindPersonCommand = new FindPersonCommand(predicates);
        assertParseSuccess(parser, NAME_DESC_AMY, expectedFindPersonCommand);

        // multiple fields
        predicates = new ArrayList<>();
        predicates.add(new PersonNameContainsKeywordsPredicate(Collections.singletonList(VALID_NAME_AMY)));
        predicates.add(new PersonPhoneContainsKeywordsPredicate(Collections.singletonList(VALID_PHONE_AMY)));
        predicates.add(new PersonEmailContainsKeywordsPredicate(Collections.singletonList(VALID_EMAIL_AMY)));
        predicates.add(new PersonExperienceContainsKeywordsPredicate(Collections.singletonList(VALID_EXPERIENCE_AMY)));
        expectedFindPersonCommand = new FindPersonCommand(predicates);
        assertParseSuccess(parser, NAME_DESC_AMY + PHONE_DESC_AMY + EMAIL_DESC_AMY + EXPERIENCE_DESC_AMY,
                expectedFindPersonCommand);
    }
}
