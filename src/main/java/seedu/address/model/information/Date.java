package seedu.address.model.information;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;



/**
 * Represents a Person's date of application for a job.
 * Guarantees: immutable; is valid as declared in {@link #isValidDate(String)}
 */
public class Date {

    public static final String dateFormat = "dd-MM-yy"; // eg. 31-12-20
    public static final String MESSAGE_CONSTRAINTS =
            "Dates must be in the format " + dateFormat;
    public static final DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern(dateFormat);

    public final LocalDate date;
    public final String dateString;

    /**
     * Constructs a {@code Date}.
     *
     * @param dateString A valid date.
     */
    public Date(String dateString) {
        requireNonNull(dateString);
        checkArgument(isValidDate(dateString), MESSAGE_CONSTRAINTS);
        date = LocalDate.parse(dateString, dateFormatter);
        this.dateString = dateString;
    }

    /**
     * Returns true if a given string is a valid date.
     */
    public static boolean isValidDate(String test) {
        try {
            dateFormatter.parse(test);
        } catch (DateTimeException err) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dateString;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Date // instanceof handles nulls
                && date.equals(((Date) other).date)); // state check
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }


}
