package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Set;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.Company.InternshipApplication;
import seedu.address.model.Industry.Industry;

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
        sb.append(PREFIX_NAME + internshipApplication.getName().CompanyName + " ");
        sb.append(PREFIX_PHONE + internshipApplication.getJobType().value + " ");
        sb.append(PREFIX_EMAIL + internshipApplication.getEmail().value + " ");
        sb.append(PREFIX_ADDRESS + internshipApplication.getDescription().value + " ");
        internshipApplication.getIndustry().stream().forEach(
            s -> sb.append(PREFIX_TAG + s.IndustryName + " ")
        );
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
     */
    public static String getEditPersonDescriptorDetails(EditPersonDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getName().ifPresent(name -> sb.append(PREFIX_NAME).append(name.CompanyName).append(" "));
        descriptor.getPhone().ifPresent(phone -> sb.append(PREFIX_PHONE).append(phone.value).append(" "));
        descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));
        descriptor.getAddress().ifPresent(address -> sb.append(PREFIX_ADDRESS).append(address.value).append(" "));
        if (descriptor.getTags().isPresent()) {
            Set<Industry> industries = descriptor.getTags().get();
            if (industries.isEmpty()) {
                sb.append(PREFIX_TAG);
            } else {
                industries.forEach(s -> sb.append(PREFIX_TAG).append(s.IndustryName).append(" "));
            }
        }
        return sb.toString();
    }
}
