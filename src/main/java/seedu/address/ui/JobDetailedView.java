package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.model.information.Job;

/**
 * UI component that displays the details of a {@code Job}.
 */
public class JobDetailedView extends UiPart<Region> {
    private static final String FXML = "JobDetailedView.fxml";

    private final Job job;

    @FXML
    private StackPane detailPersonView;
    @FXML
    private Label detailedCompanyName;
    @FXML
    private Label detailedCompanyEmail;
    @FXML
    private Label detailedCompanyPhone;

    /**
     * Creates a detailed view of a {@code Job} with given Job.
     */
    public JobDetailedView(Job job) {
        super(FXML);
        this.job = job;
        String companyName = job.getCompanyName().fullCompanyName;
        String companyPhone = job.getPhone().toString();
        String companyEmail = job.getEmail().toString();
        detailedCompanyName.setText(companyName);
        detailedCompanyPhone.setText(companyPhone);
        detailedCompanyEmail.setText(companyEmail);
    }

}
