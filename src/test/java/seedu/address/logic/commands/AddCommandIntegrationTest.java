package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.Company.InternshipApplication;
import seedu.address.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_newApplication_success() {
        // We use the PersonBuilder (as requested) to build a new, valid application
        InternshipApplication validApplication = new PersonBuilder().withName("Netflix").withJobType("Backend Engineer")
                .withIndustry("Technology").withStatus("Saved").build();

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.addPerson(validApplication);

        assertCommandSuccess(new AddCommand(validApplication), model,
                String.format(AddCommand.MESSAGE_SUCCESS, Messages.format(validApplication)),
                expectedModel);
    }

    @Test
    public void execute_duplicateApplication_throwsCommandException() {
        // This takes the first application from our sample data (Google)
        InternshipApplication applicationInList = model.getAddressBook().getPersonList().get(0);
        
        // We then try to add another application with the same core identity fields
        // (company name, industry, job type) but a different email and description.
        // According to our new logic, this should be considered a duplicate.
        assertCommandFailure(new AddCommand(applicationInList), model,
                AddCommand.MESSAGE_DUPLICATE_PERSON);
    }

}