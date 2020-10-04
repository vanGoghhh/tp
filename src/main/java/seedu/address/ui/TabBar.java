package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Region;

public class TabBar extends UiPart<Region> {

    private static final String FXML = "TabBar.fxml";

    @FXML
    private TabPane personAndJobTabBar;


    public TabBar() {
        super(FXML);
        setPersonAndJobTabBar();
    }

    private void setPersonAndJobTabBar() {
        Tab personTab = new Tab("Applicants");
        Tab jobTab = new Tab("Jobs");
        personAndJobTabBar.getTabs().add(personTab);
        personAndJobTabBar.getTabs().add(jobTab);
        personAndJobTabBar.setTabMinWidth(335);
        personAndJobTabBar.setTabMaxWidth(335);

    }
}
