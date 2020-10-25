package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BLACKLIST;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE_OF_APPLICATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EXPERIENCE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SALARY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_URL_LINK;

import java.util.Collections;
import java.util.function.Predicate;
import java.util.stream.Stream;

import seedu.address.logic.commands.FindPersonCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.information.Person;
import seedu.address.model.information.predicate.PersonAddressContainsKeywordsPredicate;
import seedu.address.model.information.predicate.PersonApplicationContainsKeywordsPredicate;
import seedu.address.model.information.predicate.PersonBlacklistContainsKeywordsPredicate;
import seedu.address.model.information.predicate.PersonEmailContainsKeywordsPredicate;
import seedu.address.model.information.predicate.PersonExperienceContainsKeywordsPredicate;
import seedu.address.model.information.predicate.PersonNameContainsKeywordsPredicate;
import seedu.address.model.information.predicate.PersonPhoneContainsKeywordsPredicate;
import seedu.address.model.information.predicate.PersonSalaryContainsKeywordsPredicate;
import seedu.address.model.information.predicate.PersonTagsContainKeywordsPredicate;
import seedu.address.model.information.predicate.PersonUrlLinkContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindPersonCommand object
 */
public class FindPersonCommandParser implements Parser<FindPersonCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the FindPersonCommand
     * and returns a FindPersonCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindPersonCommand parse(String args) throws ParseException {

        Predicate<Person> predicate = unused -> true;

        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindPersonCommand.MESSAGE_USAGE));
        }

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS,
                        PREFIX_EXPERIENCE, PREFIX_DATE_OF_APPLICATION, PREFIX_SALARY, PREFIX_BLACKLIST,
                        PREFIX_URL_LINK, PREFIX_TAG);

        if (!argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindPersonCommand.MESSAGE_USAGE));
        }

        if (arePrefixesPresent(argMultimap, PREFIX_NAME)) {
            predicate = predicate.and(new PersonNameContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_NAME).get())));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_PHONE)) {
            predicate = predicate.and(new PersonPhoneContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_PHONE).get())));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_EMAIL)) {
            predicate = predicate.and(new PersonEmailContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_EMAIL).get())));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_ADDRESS)) {
            predicate = predicate.and(new PersonAddressContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_ADDRESS).get())));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_EXPERIENCE)) {
            predicate = predicate.and(new PersonExperienceContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_EXPERIENCE).get())));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_DATE_OF_APPLICATION)) {
            predicate = predicate.and(new PersonApplicationContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_DATE_OF_APPLICATION).get())));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_SALARY)) {
            predicate = predicate.and(new PersonSalaryContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_SALARY).get())));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_BLACKLIST)) {
            predicate = predicate.and(new PersonBlacklistContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_BLACKLIST).get())));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_URL_LINK)) {
            predicate = predicate.and(new PersonUrlLinkContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_URL_LINK).get())));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_TAG)) {
            predicate = predicate.and(new PersonTagsContainKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_TAG).get())));
        }

        return new FindPersonCommand(predicate);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
