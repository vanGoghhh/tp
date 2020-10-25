package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.information.Job;

/**
 * Finds and lists all jobs in job address book whose details contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindJobCommand extends Command {
    public static final String COMMAND_WORD = "find job";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all jobs whose details contain all of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " n/samsung e/recruitment@samsung.com";

    private final Predicate<Job> predicate;

    public FindJobCommand(Predicate<Job> predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredJobList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_JOBS_LISTED_OVERVIEW, model.getFilteredJobList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindJobCommand // instanceof handles nulls
                && predicate.equals(((FindJobCommand) other).predicate)); // state check
    }
}
