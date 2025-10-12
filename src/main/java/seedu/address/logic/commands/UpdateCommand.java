package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.Company.InternshipApplication;
import seedu.address.model.ApplicationStatus.ApplicationStatus;

/**
 * Updates the status of an existing internship application in the address book.
 */
public class UpdateCommand extends Command {

    public static final String COMMAND_WORD = "update";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Updates the status of the internship application identified "
            + "by the index number used in the displayed application list. "
            + "Existing status will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "s/STATUS\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + "s/Interviewing";

    public static final String MESSAGE_UPDATE_APPLICATION_SUCCESS = "Status updated for '%1$s' to: %2$s";

    private final Index index;
    private final ApplicationStatus status;

    /**
     * @param index of the internship application in the filtered application list to update
     * @param status of the application to be updated to
     */
    public UpdateCommand(Index index, ApplicationStatus status) {
        requireNonNull(index);
        requireNonNull(status);

        this.index = index;
        this.status = status;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<InternshipApplication> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        InternshipApplication applicationToUpdate = lastShownList.get(index.getZeroBased());
        InternshipApplication updatedApplication = new InternshipApplication(
                applicationToUpdate.getName(),
                applicationToUpdate.getIndustry(),
                applicationToUpdate.getJobType(),
                applicationToUpdate.getDescription(),
                status,
                applicationToUpdate.getEmail());

        model.setPerson(applicationToUpdate, updatedApplication);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_UPDATE_APPLICATION_SUCCESS,
                applicationToUpdate.getName(), status));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UpdateCommand)) {
            return false;
        }

        UpdateCommand otherUpdateCommand = (UpdateCommand) other;
        return index.equals(otherUpdateCommand.index)
                && status.equals(otherUpdateCommand.status);
    }
}
