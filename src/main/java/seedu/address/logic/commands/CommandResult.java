package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;
import java.util.Optional;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;

    /** Help information should be shown to the user. */
    private final boolean showHelp;

    /** The application should exit. */
    private final boolean exit;

    /** Switches tab accordingly to command. */
    private final Optional<String> tabName;

    /** Right Panel should display a Person */
    private final boolean personRightPanelView;

    /** Right Panel should display a Job */
    private final boolean jobRightPanelView;


    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit, boolean personRightPanelView,
                         boolean jobRightPanelView) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.tabName = Optional.empty();
        this.jobRightPanelView = jobRightPanelView;
        this.personRightPanelView = personRightPanelView;
    }

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit, String tabName) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.tabName = Optional.of(tabName);
        this.jobRightPanelView = false;
        this.personRightPanelView = false;
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and {@code tabName} and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser, String tabName) {
        this(feedbackToUser, false, false, tabName);
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public Optional<String> getTabName() {
        return tabName;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public boolean isExit() {
        return exit;
    }

    public boolean isPersonRightPanelView() {
        return personRightPanelView;
    }

    public boolean isJobRightPanelView() {
        return jobRightPanelView;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && showHelp == otherCommandResult.showHelp
                && exit == otherCommandResult.exit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, showHelp, exit);
    }

}
