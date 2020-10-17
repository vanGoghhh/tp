package seedu.address.model.information;

public class PersonComparator {

    private final String comparingCriteria;

    public PersonComparator(String comparingCriteria) {
        this.comparingCriteria = comparingCriteria;
    }

    public String getComparingCriteria() {
        return comparingCriteria;
    }
}
