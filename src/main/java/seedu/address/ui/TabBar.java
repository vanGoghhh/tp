package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.logic.Logic;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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


    public TabBar(Logic logic) {
        super(FXML);
        this.logic = logic;
        setPersonAndJobTabBar();
    }

    private void setPersonAndJobTabBar() {
        personTab.setText("Applicants");
        jobTab.setText("Jobs");
        personAndJobTabBar.setTabMinWidth(335);
        personAndJobTabBar.setTabMaxWidth(335);
        PersonListPanel personListPanel = new PersonListPanel(logic.getFilteredPersonList());
        personListPanelPlaceholder.getChildren().add(personListPanel.getRoot());

    }

}
