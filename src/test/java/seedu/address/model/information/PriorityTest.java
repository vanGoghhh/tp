package seedu.address.model.information;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PriorityTest {

    @Test
    public void equals() {
        Priority priority = new Priority("low");

        // same object -> returns true
        assertTrue(priority.equals(priority));

        // same values -> returns true
        Priority priorityCopy = new Priority(priority.value);
        assertTrue(priority.equals(priorityCopy));

        // different types -> returns false
        assertFalse(priority.equals(1));

        // null -> returns false
        assertFalse(priority.equals(null));

        // different remark -> returns false
        Priority differentPriority = new Priority("moderate");
        assertFalse(priority.equals(differentPriority));
    }
}
