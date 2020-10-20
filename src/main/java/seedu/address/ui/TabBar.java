package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.logic.Logic;
import seedu.address.model.ModelManager;


public class TabBar extends UiPart<Region> {

    private static final String FXML = "TabBar.fxml";
    private static final String FXML2 = "PersonListPanel.fxml";

    private Logic logic;

    @FXML
    private TabPane personAndJobTabBar;

    @FXML
    private Tab personTab;

    @FXML
    private Tab jobTab;

    @FXML
    private StackPane personListPanelPlaceholder;

    @FXML
    private StackPane jobListPanelPlaceholder;


    /**
     * Creates a {@code TabBar} with the given {@code Logic}.
     */
    public TabBar(Logic logic) {
        super(FXML);
        this.logic = logic;
        setPersonAndJobTabBar();
        populateTab();
    }

    /**
     * Initialises the two tabs on the tabpane.
     */
    private void setPersonAndJobTabBar() {
        personTab.setText("Applicants");
        jobTab.setText("Jobs");
        personAndJobTabBar.setTabMinWidth(320);
        personAndJobTabBar.setTabMaxWidth(320);
    }

    /**
     * Fills the tabs with a list of applicants or jobs.
     */
    private void populateTab() {
        PersonListPanel personListPanel = new PersonListPanel(logic.getFilteredPersonList());
        JobListPanel jobListPanel = new JobListPanel(logic.getFilteredJobList());
        personListPanelPlaceholder.getChildren().add(personListPanel.getRoot());
        jobListPanelPlaceholder.getChildren().add(jobListPanel.getRoot());
    }
}
