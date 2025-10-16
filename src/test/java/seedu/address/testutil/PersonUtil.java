package seedu.address.testutil;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.Company.InternshipApplication;

import static seedu.address.logic.parser.CliSyntax.*;

/**
 * A utility class for Person.
 */
public class PersonUtil {

    /**
     * Returns an add command string for adding the {@code person}.
     */
    public static String getAddCommand(InternshipApplication internshipApplication) {
        return AddCommand.COMMAND_WORD + " " + getPersonDetails(internshipApplication);
    }

    /**
     * Returns the part of command string for the given {@code person}'s details.
     */
    public static String getPersonDetails(InternshipApplication internshipApplication) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_COMPANY_NAME).append(internshipApplication.getName().toString()).append(" ");
        sb.append(PREFIX_JOB_TYPE).append(internshipApplication.getJobType().value).append(" ");
        sb.append(PREFIX_EMAIL).append(internshipApplication.getEmail().value).append(" ");
        sb.append(PREFIX_DESCRIPTION).append(internshipApplication.getDescription().value).append(" ");
        sb.append(PREFIX_INDUSTRY).append(internshipApplication.getIndustry().value).append(" ");
        sb.append(PREFIX_STATUS).append(internshipApplication.getStatus().value).append(" ");

        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
     */
    public static String getEditPersonDescriptorDetails(EditPersonDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getName().ifPresent(name -> sb.append(PREFIX_COMPANY_NAME).append(name.toString()).append(" "));
        descriptor.getJobType().ifPresent(jobType -> sb.append(PREFIX_JOB_TYPE).append(jobType.value).append(" "));
        descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));
        descriptor.getDescription().ifPresent(description -> sb.append(PREFIX_DESCRIPTION).append(description.value).append(" "));
        descriptor.getStatus().ifPresent(status -> sb.append(PREFIX_STATUS).append(status.value).append(" "));
        descriptor.getIndustry().ifPresent(industry -> sb.append(PREFIX_INDUSTRY).append(industry.value).append(" "));

        return sb.toString();
    }
}
