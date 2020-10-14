package seedu.address.model.information;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's url link to his/her personal profile page.
 * Guarantees: immutable; is valid as declared in {@link #isValidLink(String)}
 */
public class UrlLink {


    public static final String MESSAGE_CONSTRAINTS =
            "Link should be a valid URL link.";
    public final String value;

    /**
     * Constructs a {@code UrlLink}.
     *
     * @param link A valid url link.
     */
    public UrlLink(String link) {
        requireNonNull(link);
        checkArgument(isValidLink(link), MESSAGE_CONSTRAINTS);
        value = link;
    }

    /**
     * Returns true if a given string is a valid link.
     */
    public static boolean isValidLink(String test) {
        return true;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UrlLink // instanceof handles nulls
                && value.equals(((UrlLink) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
