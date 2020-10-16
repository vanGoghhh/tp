package seedu.address.model.information;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's expected salary in dollars.
 * Guarantees: immutable; is valid as declared in {@link #isValidSalary(String)}
 */
public class Salary {

    public static final String MESSAGE_CONSTRAINTS = "Salary has to be an unsigned (non-negative) number.";

    public final double salary;

    /**
     * Constructs an {@code Salary}.
     *
     * @param salary A string representing a valid amount of salary.
     */
    public Salary(String salary) {
        requireNonNull(salary);
        checkArgument(isValidSalary(salary), MESSAGE_CONSTRAINTS);
        this.salary = Double.parseDouble(salary);
    }

    /**
     * Returns if a given String represents valid amount of salary.
     */
    public static boolean isValidSalary(String test) {
        double salaryAmount;
        try {
            salaryAmount = Double.parseDouble(test);
        } catch (NumberFormatException exception) {
            return false;
        }
        return salaryAmount >= 0;
    }

    @Override
    public String toString() {
        return salary + "";
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Salary // instanceof handles nulls
                && salary == ((Salary) other).salary); // state check
    }

    @Override
    public int hashCode() {
        return Double.valueOf(salary).hashCode();
    }
}
