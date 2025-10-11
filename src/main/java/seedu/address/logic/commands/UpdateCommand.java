package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Updates the status of an existing person in the address book.
 */
public class UpdateCommand extends Command {

    public static final String COMMAND_WORD = "update";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Updates the status of the person identified "
            + "by the index number used in the displayed person list. "
            + "Existing status will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "s/STATUS\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + "s/Interviewing";

    public static final String MESSAGE_UPDATE_PERSON_SUCCESS = "Status updated for '%1$s' to: %2$s";

    private final Index index;
    private final String status;

    /**
     * @param index of the person in the filtered person list to update
     * @param status of the person to be updated to
     */
    public UpdateCommand(Index index, String status) {
        requireNonNull(index);
        requireNonNull(status);

        this.index = index;
        this.status = status;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToUpdate = lastShownList.get(index.getZeroBased());
        
        // For now, just return a success message without actually updating the person
        return new CommandResult(String.format(MESSAGE_UPDATE_PERSON_SUCCESS, 
                personToUpdate.getName(), status));
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
