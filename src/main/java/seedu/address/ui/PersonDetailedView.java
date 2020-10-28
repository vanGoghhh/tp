package seedu.address.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

import seedu.address.model.information.Person;

public class PersonDetailedView extends UiPart<Region> {
    private static final String FXML = "PersonDetailedView.fxml";
    private static final List<String> LABELS = new ArrayList<>(List.of("Email:", "Years Of Experience: ",
            "Date Of Application:", "Address:", "Profile Link", "Expected Salary:"));

    private final ObservableList<DataPair> list;

    private final Person person;

    @FXML
    private TableView<DataPair> detailPersonView;


    public PersonDetailedView(Person person) {
        super(FXML);
        this.person = person;
        String email = person.getEmail().value;
        String yearsOfExperience = person.getExperience().value;
        String dateOfApplication = person.getDateOfApplication().dateString;
        String address = person.getAddressOptional().map(add -> add.value).orElse("Empty!");
        String profileLink = person.getUrlLinkOptional().map(url -> url.value).orElse("Empty!");
        String salary = person.getSalaryOptional().map(sal -> String.valueOf(sal.salary)).orElse("Empty!");

        list = FXCollections.observableArrayList();
        List<String> data = List.of(email, yearsOfExperience, dateOfApplication, address, profileLink, salary);
        Iterator<String> iter = data.iterator();
        LABELS.forEach(label -> {
            DataPair pair = new DataPair(label, iter.next());
            list.add(pair);
        });

        detailPersonView.setItems(list);
    }
}

