package seedu.address.ui;

/**
 * Class to represent a pair of field and data to be used in the detail person table.
 */
public class DataPair {
    private final String field;
    private final String data;

    public DataPair(String field, String data) {
        this.field = field;
        this.data = data;
    }
}
