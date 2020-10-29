package seedu.address.model.information;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class CompanyNameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new CompanyName(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidCompanyName = "";
        assertThrows(IllegalArgumentException.class, () -> new CompanyName(invalidCompanyName));
    }

    @Test
    public void isValidName() {
        // null name
        assertThrows(NullPointerException.class, () -> CompanyName.isValidCompanyName(null));

        // invalid company name
        assertFalse(CompanyName.isValidCompanyName("")); // empty string
        assertFalse(CompanyName.isValidCompanyName(" ")); // spaces only

        // valid company name
        assertTrue(CompanyName.isValidCompanyName("^")); // only non-alphanumeric characters
        assertTrue(CompanyName.isValidCompanyName("peter*")); // contains non-alphanumeric characters
        assertTrue(CompanyName.isValidCompanyName("peter jack")); // alphabets only; person name
        assertTrue(CompanyName.isValidCompanyName("12345")); // numbers only
        assertTrue(CompanyName.isValidCompanyName("peter the 2nd")); // alphanumeric characters
        assertTrue(CompanyName.isValidCompanyName("Capital Tan")); // with capital letters
        assertTrue(CompanyName.isValidCompanyName("David Roger Jackson Ray Jr 2nd")); // long names
        assertTrue(CompanyName.isValidCompanyName("Google")); // alphabets only; company name
        assertTrue(CompanyName.isValidCompanyName("Software engineer")); // alphabets only; job title
    }
}
