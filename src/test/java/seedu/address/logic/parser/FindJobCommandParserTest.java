package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_IRAS;
import static seedu.address.logic.commands.CommandTestUtil.COMPANY_NAME_DESC_IRAS;
import static seedu.address.logic.commands.CommandTestUtil.JOB_TITLE_DESC_IRAS;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_IRAS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_IRAS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COMPANY_NAME_IRAS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_JOB_TITLE_IRAS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_IRAS;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.FindJobCommand;
import seedu.address.model.information.Job;
import seedu.address.model.information.predicate.JobAddressContainsKeywordsPredicate;
import seedu.address.model.information.predicate.JobCompanyNameContainsKeywordsPredicate;
import seedu.address.model.information.predicate.JobJobTitleContainsKeywordsPredicate;
import seedu.address.model.information.predicate.JobPhoneContainsKeywordsPredicate;

public class FindJobCommandParserTest {

    private FindJobCommandParser parser = new FindJobCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindJobCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_emptyPreamble_throwsParseException() {
        assertParseFailure(parser, "n/Software Engineer",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindJobCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindPersonCommand() {

        // one field
        List<Predicate<Job>> predicates = new ArrayList<>();
        predicates.add(new JobJobTitleContainsKeywordsPredicate(parser.splitInput(VALID_JOB_TITLE_IRAS)));
        Command expectedFindPersonCommand = new FindJobCommand(predicates);
        assertParseSuccess(parser, JOB_TITLE_DESC_IRAS, expectedFindPersonCommand);

        // multiple fields
        predicates = new ArrayList<>();
        predicates.add(new JobJobTitleContainsKeywordsPredicate(parser.splitInput(VALID_JOB_TITLE_IRAS)));
        predicates.add(new JobCompanyNameContainsKeywordsPredicate(parser.splitInput(VALID_COMPANY_NAME_IRAS)));
        predicates.add(new JobPhoneContainsKeywordsPredicate(parser.splitInput(VALID_PHONE_IRAS)));
        predicates.add(new JobAddressContainsKeywordsPredicate(parser.splitInput(VALID_ADDRESS_IRAS)));
        expectedFindPersonCommand = new FindJobCommand(predicates);
        assertParseSuccess(parser, JOB_TITLE_DESC_IRAS + COMPANY_NAME_DESC_IRAS + PHONE_DESC_IRAS + ADDRESS_DESC_IRAS,
                expectedFindPersonCommand);
    }
}
