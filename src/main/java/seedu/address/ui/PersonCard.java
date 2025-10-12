package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.Company.InternshipApplication;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    public final InternshipApplication internshipApplication;

    @FXML
    private HBox cardPane;
    // --- START OF CHANGES ---
    @FXML
    private Label companyName; // Renamed from 'name'
    @FXML
    private Label id;
    @FXML
    private Label jobType; // Renamed from 'phone'
    @FXML
    private Label description; // Renamed from 'address'
    @FXML
    private Label email;
    @FXML
    private FlowPane industries; // Renamed from 'tags'
    // --- END OF CHANGES ---

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(InternshipApplication internshipApplication, int displayedIndex) {
        super(FXML);
        this.internshipApplication = internshipApplication;
        id.setText(displayedIndex + ". ");
        // --- START OF CHANGES ---
        companyName.setText(internshipApplication.getName().CompanyName);
        jobType.setText(internshipApplication.getJobType().value);
        description.setText(internshipApplication.getDescription().value);
        email.setText(internshipApplication.getEmail().value);
        Label industryLabel = new Label(internshipApplication.getIndustry().value);
        industries.getChildren().add(industryLabel);
        Label statusLabel = new Label("Status: " + internshipApplication.getStatus().value);
        industries.getChildren().add(statusLabel);
        // --- END OF CHANGES ---
    }
}
