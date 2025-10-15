// // // // package seedu.address.testutil;

// // // // import seedu.address.logic.commands.AddCommand;
// // // // import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
// // // // import seedu.address.model.Company.InternshipApplication;

// // // // import static seedu.address.logic.parser.CliSyntax.*;

// // // // /**
// // // //  * A utility class for Person.
// // // //  */
// // // // public class PersonUtil {

// // // //     /**
// // // //      * Returns an add command string for adding the {@code person}.
// // // //      */
// // // //     public static String getAddCommand(InternshipApplication internshipApplication) {
// // // //         return AddCommand.COMMAND_WORD + " " + getPersonDetails(internshipApplication);
// // // //     }

// // // //     /**
// // // //      * Returns the part of command string for the given {@code person}'s details.
// // // //      */
// // // //     public static String getPersonDetails(InternshipApplication internshipApplication) {
// // // //         StringBuilder sb = new StringBuilder();
// // // //         sb.append(PREFIX_COMPANY_NAME + internshipApplication.getName().CompanyName + " ");
// // // //         sb.append(PREFIX_JOB_TYPE + internshipApplication.getJobType().value + " ");
// // // //         sb.append(PREFIX_EMAIL + internshipApplication.getEmail().value + " ");
// // // //         sb.append(PREFIX_DESCRIPTION + internshipApplication.getDescription().value + " ");
// // // //         sb.append(PREFIX_STATUS + internshipApplication.getStatus().value + " ");
// // // //         sb.append(PREFIX_INDUSTRY + internshipApplication.getIndustry().value + " ");

// // // //         return sb.toString();
// // // //     }

// // // //     /**
// // // //      * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
// // // //      */
// // // //     public static String getEditPersonDescriptorDetails(EditPersonDescriptor descriptor) {
// // // //         StringBuilder sb = new StringBuilder();
// // // //         descriptor.getName().ifPresent(name -> sb.append(PREFIX_COMPANY_NAME).append(name.CompanyName).append(" "));
// // // //         descriptor.getPhone().ifPresent(jobType -> sb.append(PREFIX_JOB_TYPE).append(jobType.value).append(" "));
// // // //         descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));
// // // //         descriptor.getDescription().ifPresent(description -> sb.append(PREFIX_DESCRIPTION).append(description.value).append(" "));
// // // //         descriptor.getDescription().ifPresent(status -> sb.append(PREFIX_STATUS).append(status.value).append(" "));
// // // //         descriptor.getDescription().ifPresent(industry -> sb.append(PREFIX_INDUSTRY).append(industry.value).append(" "));

// // // //         return sb.toString();
// // // //     }
// // // // }

// // // package seedu.address.testutil;

// // // import static seedu.address.logic.parser.CliSyntax.*;

// // // import java.util.Set;

// // // import seedu.address.logic.commands.AddCommand;
// // // import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
// // // import seedu.address.model.Company.InternshipApplication;
// // // import seedu.address.model.Industry.Industry;

// // // /**
// // //  * A utility class for InternshipApplication.
// // //  */
// // // public class PersonUtil {

// // //     /**
// // //      * Returns an add command string for adding the {@code internshipApplication}.
// // //      */
// // //     public static String getAddCommand(InternshipApplication internshipApplication) {
// // //         return AddCommand.COMMAND_WORD + " " + getPersonDetails(internshipApplication);
// // //     }

// // //     /**
// // //      * Returns the part of command string for the given {@code internshipApplication}'s details.
// // //      */
// // //     public static String getPersonDetails(InternshipApplication internshipApplication) {
// // //         StringBuilder sb = new StringBuilder();
// // //         sb.append(PREFIX_COMPANY_NAME).append(internshipApplication.getName().CompanyName).append(" ");
// // //         sb.append(PREFIX_JOB_TYPE).append(internshipApplication.getJobType().value).append(" ");
// // //         sb.append(PREFIX_EMAIL).append(internshipApplication.getEmail().value).append(" ");
// // //         sb.append(PREFIX_DESCRIPTION).append(internshipApplication.getDescription().value).append(" ");
// // //         sb.append(PREFIX_STATUS).append(internshipApplication.getStatus().value).append(" ");
// // //         internshipApplication.getIndustry().stream().forEach(
// // //             // Assuming the Industry class has a public field named 'industryName'
// // //             s -> sb.append(PREFIX_INDUSTRY).append(s.industryName).append(" ")
// // //         );
// // //         return sb.toString();
// // //     }

// // //     /**
// // //      * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
// // //      */
// // //     public static String getEditPersonDescriptorDetails(EditPersonDescriptor descriptor) {
// // //         StringBuilder sb = new StringBuilder();
// // //         descriptor.getName().ifPresent(name -> sb.append(PREFIX_COMPANY_NAME).append(name.CompanyName).append(" "));
// // //         descriptor.getPhone().ifPresent(jobType -> sb.append(PREFIX_JOB_TYPE).append(jobType.value).append(" "));
// // //         descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));
// // //         descriptor.getDescription().ifPresent(description -> sb.append(PREFIX_DESCRIPTION).append(description.value).append(" "));
// // //         // Corrected to call getStatus()
// // //         descriptor.getStatus().ifPresent(status -> sb.append(PREFIX_STATUS).append(status.value).append(" "));
// // //         // Corrected to call getIndustries() and handle a Set
// // //         if (descriptor.getIndustries().isPresent()) {
// // //             Set<Industry> industries = descriptor.getIndustries().get();
// // //             if (industries.isEmpty()) {
// // //                 sb.append(PREFIX_INDUSTRY).append(" ");
// // //             } else {
// // //                 // Assuming the Industry class has a public field named 'industryName'
// // //                 industries.forEach(s -> sb.append(PREFIX_INDUSTRY).append(s.industryName).append(" "));
// // //             }
// // //         }
// // //         return sb.toString();
// // //     }
// // // }

// // package seedu.address.testutil;

// // import static seedu.address.logic.parser.CliSyntax.*;

// // import java.util.Set;

// // import seedu.address.logic.commands.AddCommand;
// // import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
// // import seedu.address.model.Company.InternshipApplication;
// // import seedu.address.model.Industry.Industry;

// // /**
// //  * A utility class for InternshipApplication.
// //  */
// // public class PersonUtil {

// //     /**
// //      * Returns an add command string for adding the {@code internshipApplication}.
// //      */
// //     public static String getAddCommand(InternshipApplication internshipApplication) {
// //         return AddCommand.COMMAND_WORD + " " + getPersonDetails(internshipApplication);
// //     }

// //     /**
// //      * Returns the part of command string for the given {@code internshipApplication}'s details.
// //      */
// //     public static String getPersonDetails(InternshipApplication internshipApplication) {
// //         StringBuilder sb = new StringBuilder();
// //         sb.append(PREFIX_COMPANY_NAME + internshipApplication.getName().CompanyName + " ");
// //         sb.append(PREFIX_JOB_TYPE + internshipApplication.getJobType().value + " ");
// //         sb.append(PREFIX_EMAIL + internshipApplication.getEmail().value + " ");
// //         sb.append(PREFIX_DESCRIPTION + internshipApplication.getDescription().value + " ");
// //         sb.append(PREFIX_STATUS + internshipApplication.getStatus().value + " ");
// //         internshipApplication.getIndustry().stream().forEach(
// //             s -> sb.append(PREFIX_INDUSTRY + s.industryName + " ")
// //         );
// //         return sb.toString();
// //     }

// //     /**
// //      * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
// //      */
// //     public static String getEditPersonDescriptorDetails(EditPersonDescriptor descriptor) {
// //         StringBuilder sb = new StringBuilder();
// //         descriptor.getName().ifPresent(name -> sb.append(PREFIX_COMPANY_NAME).append(name.CompanyName).append(" "));
// //         descriptor.getPhone().ifPresent(jobType -> sb.append(PREFIX_JOB_TYPE).append(jobType.value).append(" "));
// //         descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));
// //         descriptor.getDescription().ifPresent(description -> sb.append(PREFIX_DESCRIPTION).append(description.value).append(" "));
// //         descriptor.getStatus().ifPresent(status -> sb.append(PREFIX_STATUS).append(status.value).append(" "));
// //         if (descriptor.getIndustries().isPresent()) {
// //             Set<Industry> industries = descriptor.getIndustries().get();
// //             if (industries.isEmpty()) {
// //                 sb.append(PREFIX_INDUSTRY).append(" ");
// //             } else {
// //                 industries.forEach(s -> sb.append(PREFIX_INDUSTRY).append(s.industryName).append(" "));
// //             }
// //         }
// //         return sb.toString();
// //     }
// // }

// package seedu.address.testutil;

// import static seedu.address.logic.parser.CliSyntax.*;

// import seedu.address.logic.commands.AddCommand;
// import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
// import seedu.address.model.Company.InternshipApplication;

// /**
//  * A utility class for InternshipApplication.
//  */
// public class PersonUtil {

//     /**
//      * Returns an add command string for adding the {@code internshipApplication}.
//      */
//     public static String getAddCommand(InternshipApplication internshipApplication) {
//         return AddCommand.COMMAND_WORD + " " + getPersonDetails(internshipApplication);
//     }

//     /**
//      * Returns the part of command string for the given {@code internshipApplication}'s details.
//      */
//     public static String getPersonDetails(InternshipApplication internshipApplication) {
//         StringBuilder sb = new StringBuilder();
//         sb.append(PREFIX_COMPANY_NAME).append(internshipApplication.getName().CompanyName).append(" ");
//         sb.append(PREFIX_JOB_TYPE).append(internshipApplication.getJobType().value).append(" ");
//         sb.append(PREFIX_EMAIL).append(internshipApplication.getEmail().value).append(" ");
//         sb.append(PREFIX_DESCRIPTION).append(internshipApplication.getDescription().value).append(" ");
//         sb.append(PREFIX_STATUS).append(internshipApplication.getStatus().value).append(" ");
//         // Corrected to handle a single industry, no stream needed
//         sb.append(PREFIX_INDUSTRY).append(internshipApplication.getIndustry().industryName).append(" ");
//         return sb.toString();
//     }

//     /**
//      * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
//      */
//     public static String getEditPersonDescriptorDetails(EditPersonDescriptor descriptor) {
//         StringBuilder sb = new StringBuilder();
//         descriptor.getName().ifPresent(name -> sb.append(PREFIX_COMPANY_NAME).append(name.CompanyName).append(" "));
//         // Corrected from getPhone to getJobType
//         descriptor.getJobType().ifPresent(jobType -> sb.append(PREFIX_JOB_TYPE).append(jobType.value).append(" "));
//         descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));
//         descriptor.getDescription().ifPresent(description -> sb.append(PREFIX_DESCRIPTION).append(description.value).append(" "));
//         descriptor.getStatus().ifPresent(status -> sb.append(PREFIX_STATUS).append(status.value).append(" "));
//         // Corrected from getIndustries to getIndustry
//         descriptor.getIndustry().ifPresent(industry -> sb.append(PREFIX_INDUSTRY).append(industry.industryName).append(" "));
//         return sb.toString();
//     }
// }

package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_COMPANY_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INDUSTRY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOB_TYPE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STATUS;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.Company.InternshipApplication;

/**
 * A utility class for InternshipApplication.
 */
public class PersonUtil {

    /**
     * Returns an add command string for adding the {@code internshipApplication}.
     */
    public static String getAddCommand(InternshipApplication internshipApplication) {
        return AddCommand.COMMAND_WORD + " " + getPersonDetails(internshipApplication);
    }

    /**
     * Returns the part of command string for the given {@code internshipApplication}'s details.
     */
    public static String getPersonDetails(InternshipApplication internshipApplication) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_COMPANY_NAME).append(internshipApplication.getName().CompanyName).append(" ");
        sb.append(PREFIX_JOB_TYPE).append(internshipApplication.getJobType().value).append(" ");
        sb.append(PREFIX_EMAIL).append(internshipApplication.getEmail().value).append(" ");
        sb.append(PREFIX_DESCRIPTION).append(internshipApplication.getDescription().value).append(" ");
        sb.append(PREFIX_STATUS).append(internshipApplication.getStatus().value).append(" ");
        // Corrected from .industryName to .value
        sb.append(PREFIX_INDUSTRY).append(internshipApplication.getIndustry().value).append(" ");
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
     */
    public static String getEditPersonDescriptorDetails(EditPersonDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getName().ifPresent(name -> sb.append(PREFIX_COMPANY_NAME).append(name.CompanyName).append(" "));
        descriptor.getJobType().ifPresent(jobType -> sb.append(PREFIX_JOB_TYPE).append(jobType.value).append(" "));
        descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));
        descriptor.getDescription().ifPresent(description -> sb.append(PREFIX_DESCRIPTION).append(description.value).append(" "));
        descriptor.getStatus().ifPresent(status -> sb.append(PREFIX_STATUS).append(status.value).append(" "));
        // Corrected from .industryName to .value
        descriptor.getIndustry().ifPresent(industry -> sb.append(PREFIX_INDUSTRY).append(industry.value).append(" "));
        return sb.toString();
    }
}