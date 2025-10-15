// // package seedu.address.testutil;

// // import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
// // import seedu.address.model.Company.*;
// // import seedu.address.model.Company.CompanyName;
// // import seedu.address.model.Industry.Industry;

// // /**
// //  * A utility class to help with building EditPersonDescriptor objects.
// //  */
// // public class EditPersonDescriptorBuilder {

// //     private EditPersonDescriptor descriptor;

// //     public EditPersonDescriptorBuilder() {
// //         descriptor = new EditPersonDescriptor();
// //     }

// //     public EditPersonDescriptorBuilder(EditPersonDescriptor descriptor) {
// //         this.descriptor = new EditPersonDescriptor(descriptor);
// //     }

// //     /**
// //      * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
// //      */
// //     public EditPersonDescriptorBuilder(InternshipApplication internshipApplication) {
// //         descriptor = new EditPersonDescriptor();
// //         descriptor.setName(internshipApplication.getName());
// //         descriptor.setPhone(internshipApplication.getJobType());
// //         descriptor.setEmail(internshipApplication.getEmail());
// //         descriptor.setDescription(internshipApplication.getDescription());
// //         descriptor.setIndustry(internshipApplication.getIndustry());
// //     }

// //     /**
// //      * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
// //      */
// //     public EditPersonDescriptorBuilder withName(String name) {
// //         descriptor.setName(new CompanyName(name));
// //         return this;
// //     }

// //     /**
// //      * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
// //      */
// //     public EditPersonDescriptorBuilder withPhone(String phone) {
// //         descriptor.setPhone(new JobType(phone));
// //         return this;
// //     }

// //     /**
// //      * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
// //      */
// //     public EditPersonDescriptorBuilder withEmail(String email) {
// //         descriptor.setEmail(new Email(email));
// //         return this;
// //     }

// //     /**
// //      * Sets the {@code Address} of the {@code EditPersonDescriptor} that we are building.
// //      */
// //     public EditPersonDescriptorBuilder withAddress(String address) {
// //         descriptor.setDescription(new Description(address));
// //         return this;
// //     }

// //     /**
// //      * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPersonDescriptor}
// //      * that we are building.
// //      */
// //     public EditPersonDescriptorBuilder withTags(String industry) {
// //         descriptor.setIndustry(new Industry(industry));
// //         return this;
// //     }

// //     public EditPersonDescriptor build() {
// //         return descriptor;
// //     }
// // }

// package seedu.address.testutil;

// import java.util.Set;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;

// import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
// import seedu.address.model.Company.Description;
// import seedu.address.model.Company.Email;
// import seedu.address.model.Company.InternshipApplication;
// import seedu.address.model.Company.JobType;
// import seedu.address.model.Company.CompanyName;
// import seedu.address.model.Industry.Industry;

// /**
//  * A utility class to help with building EditPersonDescriptor objects.
//  */
// public class EditPersonDescriptorBuilder {

//     private EditPersonDescriptor descriptor;

//     public EditPersonDescriptorBuilder() {
//         descriptor = new EditPersonDescriptor();
//     }

//     public EditPersonDescriptorBuilder(EditPersonDescriptor descriptor) {
//         this.descriptor = new EditPersonDescriptor(descriptor);
//     }

//     /**
//      * Returns an {@code EditPersonDescriptor} with fields containing {@code internshipApplication}'s details
//      */
//     public EditPersonDescriptorBuilder(InternshipApplication internshipApplication) {
//         descriptor = new EditPersonDescriptor();
//         descriptor.setName(internshipApplication.getName());
//         descriptor.setPhone(internshipApplication.getJobType());
//         descriptor.setEmail(internshipApplication.getEmail());
//         descriptor.setDescription(internshipApplication.getDescription());
//         // Assumes EditPersonDescriptor has setIndustries for a Set
//         descriptor.setIndustries(internshipApplication.getIndustry());
//     }

//     /**
//      * Sets the {@code CompanyName} of the {@code EditPersonDescriptor} that we are building.
//      */
//     public EditPersonDescriptorBuilder withName(String name) {
//         descriptor.setName(new CompanyName(name));
//         return this;
//     }

//     /**
//      * Sets the {@code JobType} of the {@code EditPersonDescriptor} that we are building.
//      */
//     public EditPersonDescriptorBuilder withPhone(String phone) {
//         descriptor.setPhone(new JobType(phone));
//         return this;
//     }

//     /**
//      * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
//      */
//     public EditPersonDescriptorBuilder withEmail(String email) {
//         descriptor.setEmail(new Email(email));
//         return this;
//     }

//     /**
//      * Sets the {@code Description} of the {@code EditPersonDescriptor} that we are building.
//      */
//     public EditPersonDescriptorBuilder withAddress(String address) {
//         descriptor.setDescription(new Description(address));
//         return this;
//     }

//     /**
//      * Parses the {@code industries} into a {@code Set<Industry>} and sets it to the {@code EditPersonDescriptor}
//      * that we are building.
//      */
//     public EditPersonDescriptorBuilder withIndustries(String... industries) {
//         Set<Industry> industrySet = Stream.of(industries).map(Industry::new).collect(Collectors.toSet());
//         // Assumes EditPersonDescriptor has setIndustries for a Set
//         descriptor.setIndustries(industrySet);
//         return this;
//     }

//     public EditPersonDescriptor build() {
//         return descriptor;
//     }
// }

package seedu.address.testutil;

import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.Company.*;
import seedu.address.model.Industry.Industry;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditPersonDescriptorBuilder {

    private EditPersonDescriptor descriptor;

    public EditPersonDescriptorBuilder() {
        descriptor = new EditPersonDescriptor();
    }

    public EditPersonDescriptorBuilder(EditPersonDescriptor descriptor) {
        this.descriptor = new EditPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code internshipApplication}'s details
     */
    public EditPersonDescriptorBuilder(InternshipApplication internshipApplication) {
        descriptor = new EditPersonDescriptor();
        descriptor.setName(internshipApplication.getName());
        // Corrected from setPhone to setJobType
        descriptor.setJobType(internshipApplication.getJobType());
        descriptor.setEmail(internshipApplication.getEmail());
        descriptor.setDescription(internshipApplication.getDescription());
        // Corrected from setIndustries to setIndustry
        descriptor.setIndustry(internshipApplication.getIndustry());
    }

    /**
     * Sets the {@code CompanyName} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setName(new CompanyName(name));
        return this;
    }

    /**
     * Sets the {@code JobType} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withPhone(String phone) {
        // Corrected from setPhone to setJobType
        descriptor.setJobType(new JobType(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Description} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withAddress(String address) {
        descriptor.setDescription(new Description(address));
        return this;
    }

    /**
     * Sets the {@code Industry} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withIndustry(String industry) {
        // Corrected from setIndustries to setIndustry
        descriptor.setIndustry(new Industry(industry));
        return this;
    }

    public EditPersonDescriptor build() {
        return descriptor;
    }
}