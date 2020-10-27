package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import seedu.address.logic.commands.FindJobCommand;
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
            String jobTitle = argMultimap.getValue(PREFIX_JOB_TITLE).orElse("");
            List<String> words = splitInput(jobTitle);
            predicates.add(new JobJobTitleContainsKeywordsPredicate(words));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_COMPANY_NAME)) {
            String company = argMultimap.getValue(PREFIX_COMPANY_NAME).orElse("");
            List<String> words = splitInput(company);
            predicates.add(new JobCompanyNameContainsKeywordsPredicate(words));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_PHONE)) {
            String phone = argMultimap.getValue(PREFIX_PHONE).orElse("");
            List<String> words = splitInput(phone);
            predicates.add(new JobPhoneContainsKeywordsPredicate(words));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_EMAIL)) {
            String email = argMultimap.getValue(PREFIX_EMAIL).orElse("");
            List<String> words = splitInput(email);
            predicates.add(new JobEmailContainsKeywordsPredicate(words));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_ADDRESS)) {
            String address = argMultimap.getValue(PREFIX_ADDRESS).orElse("");
            List<String> words = splitInput(address);
            predicates.add(new JobAddressContainsKeywordsPredicate(words));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_TAG)) {
            String tag = argMultimap.getValue(PREFIX_TAG).orElse("");
            List<String> words = splitInput(tag);
            predicates.add(new JobTagsContainKeywordsPredicate(words));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_PRIORITY)) {
            String priority = argMultimap.getValue(PREFIX_PRIORITY).orElse("");
            List<String> words = splitInput(priority);
            predicates.add(new JobPriorityContainsKeywordsPredicate(words));
        }
        if (arePrefixesPresent(argMultimap, PREFIX_VACANCY)) {
            String vacancy = argMultimap.getValue(PREFIX_VACANCY).orElse("");
            List<String> words = splitInput(vacancy);
            predicates.add(new JobVacancyContainsKeywordsPredicate(words));
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

    /**
     * Splits a String into words.
     * @param userInput User specified keyword for a field.
     * @return a List containing the words.
     */
    public List<String> splitInput(String userInput) {
        List<String> keywords = new ArrayList<>();
        String[] words = userInput.split("\\s+");
        Collections.addAll(keywords, words);
        return keywords;
    }

}
