package seedu.address.model.information;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class ExperienceTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Experience(null));
    }

    @Test
    public void constructor_invalidExperience_throwsIllegalArgumentException() {
        String emptyExperience = "";
        String negativeExperience = "-1";
        String wordExperience = "Twenty";
        assertThrows(IllegalArgumentException.class, () -> new Experience(emptyExperience));
        assertThrows(IllegalArgumentException.class, () -> new Experience(negativeExperience));
        assertThrows(IllegalArgumentException.class, () -> new Experience(wordExperience));
    }

    @Test
    public void isValidExperience() {
        // null experience
        assertThrows(NullPointerException.class, () -> Experience.isValidExperience(null));

        // invalid experience
        assertFalse(Experience.isValidExperience("")); // empty string
        assertFalse(Experience.isValidExperience("  ")); // spaces only
        assertFalse(Experience.isValidExperience("phone")); // non-numeric
        assertFalse(Experience.isValidExperience("9011p041")); // alphabets within digits
        assertFalse(Experience.isValidExperience("-100")); // negative number
        assertFalse(Experience.isValidExperience("100.1")); // number more that 100
        assertFalse(Experience.isValidExperience("Infinity")); // infinity

        // valid experience
        assertTrue(Experience.isValidExperience("0")); // zero
        assertTrue(Experience.isValidExperience("9")); // positive
        assertTrue(Experience.isValidExperience("    9    ")); // valid number with whitespace
    }
}
