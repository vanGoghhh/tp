package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COMPANY_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOB_TITLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRIORITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_VACANCY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import seedu.address.logic.commands.AddJobCommand;
import seedu.address.logic.commands.FindJobCommand;
import seedu.address.logic.commands.FindPersonCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.information.Job;
import seedu.address.model.information.predicate.JobAddressContainsKeywordsPredicate;
import seedu.address.model.information.predicate.JobCompanyNameContainsKeywordsPredicate;
import seedu.address.model.information.predicate.JobEmailContainsKeywordsPredicate;
import seedu.address.model.information.predicate.JobJobTitleContainsKeywordsPredicate;
import seedu.address.model.information.predicate.JobPhoneContainsKeywordsPredicate;
import seedu.address.model.information.predicate.JobPriorityContainsKeywordsPredicate;
import seedu.address.model.information.predicate.JobTagsContainKeywordsPredicate;
import seedu.address.model.information.predicate.JobVacancyContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindJobCommand object
 */
public class FindJobCommandParser implements Parser<FindJobCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the FindJobCommand
     * and returns a FindJobCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindJobCommand parse(String args) throws ParseException {

        List<Predicate<Job>> predicates = new ArrayList<>();

        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindJobCommand.MESSAGE_USAGE));
        }

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_JOB_TITLE, PREFIX_COMPANY_NAME, PREFIX_PHONE, PREFIX_EMAIL,
                        PREFIX_ADDRESS, PREFIX_TAG, PREFIX_PRIORITY, PREFIX_VACANCY);

        if (!argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindJobCommand.MESSAGE_USAGE));
        }

        if (arePrefixesPresent(argMultimap, PREFIX_JOB_TITLE)) {
            predicates.add(new JobJobTitleContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_JOB_TITLE).orElse(""))));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_COMPANY_NAME)) {
            predicates.add(new JobCompanyNameContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_COMPANY_NAME).orElse(""))));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_PHONE)) {
            predicates.add(new JobPhoneContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_PHONE).orElse(""))));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_EMAIL)) {
            predicates.add(new JobEmailContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_EMAIL).orElse(""))));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_ADDRESS)) {
            predicates.add(new JobAddressContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_ADDRESS).orElse(""))));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_TAG)) {
            predicates.add(new JobTagsContainKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_TAG).orElse(""))));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_PRIORITY)) {
            predicates.add(new JobPriorityContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_PRIORITY).orElse(""))));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_VACANCY)) {
            predicates.add(new JobVacancyContainsKeywordsPredicate(
                    Collections.singletonList(argMultimap.getValue(PREFIX_VACANCY).orElse(""))));
        }

        return new FindJobCommand(predicates);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
