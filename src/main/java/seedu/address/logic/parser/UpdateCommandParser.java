package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STATUS;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.UpdateCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ApplicationStatus.ApplicationStatus;

/**
 * Parses input arguments and creates a new UpdateCommand object
 */
public class UpdateCommandParser implements Parser<UpdateCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the UpdateCommand
     * and returns an UpdateCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public UpdateCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_STATUS);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    UpdateCommand.MESSAGE_USAGE), ive);
        }

        if (!argMultimap.getValue(PREFIX_STATUS).isPresent()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    UpdateCommand.MESSAGE_USAGE));
        }

        String statusString = argMultimap.getValue(PREFIX_STATUS).get();

        // Convert to proper case for validation
        String normalizedStatus = normalizeStatus(statusString);
        if (!ApplicationStatus.isValidStatus(normalizedStatus)) {
            throw new ParseException(ApplicationStatus.MESSAGE_CONSTRAINTS);
        }

        ApplicationStatus status = new ApplicationStatus(normalizedStatus);

        return new UpdateCommand(index, status);
    }

    /**
     * Normalizes the status string to the proper case by matching against valid statuses.
     * This allows case-insensitive input while maintaining the correct capitalization.
     */
    private String normalizeStatus(String statusInput) {
        String[] validStatuses = ApplicationStatus.VALID_STATUSES;

        for (String validStatus : validStatuses) {
            if (validStatus.equalsIgnoreCase(statusInput)) {
                return validStatus;
            }
        }

        // If no match found, return original input (will be caught by validation)
        return statusInput;
    }
}
