// // // // package seedu.address.testutil;

// // // // import java.util.HashSet;
// // // // import java.util.Set;

// // // // import seedu.address.model.Company.*;
// // // // import seedu.address.model.Company.CompanyName;
// // // // import seedu.address.model.Industry.Industry;
// // // // import seedu.address.model.util.SampleDataUtil;

// // // // /**
// // // //  * A utility class to help with building Person objects.
// // // //  */
// // // // public class PersonBuilder {

// // // //     public static final String DEFAULT_NAME = "Amy Bee";
// // // //     public static final String DEFAULT_PHONE = "85355255";
// // // //     public static final String DEFAULT_EMAIL = "amy@gmail.com";
// // // //     public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

// // // //     private CompanyName companyName;
// // // //     private JobType jobType;
// // // //     private Email email;
// // // //     private Description description;
// // // //     private Set<Industry> industries;

// // // //     /**
// // // //      * Creates a {@code PersonBuilder} with the default details.
// // // //      */
// // // //     public PersonBuilder() {
// // // //         companyName = new CompanyName(DEFAULT_NAME);
// // // //         jobType = new JobType(DEFAULT_PHONE);
// // // //         email = new Email(DEFAULT_EMAIL);
// // // //         description = new Description(DEFAULT_ADDRESS);
// // // //         industries = new HashSet<>();
// // // //     }

// // // //     /**
// // // //      * Initializes the PersonBuilder with the data of {@code personToCopy}.
// // // //      */
// // // //     public PersonBuilder(InternshipApplication internshipApplicationToCopy) {
// // // //         companyName = internshipApplicationToCopy.getName();
// // // //         jobType = internshipApplicationToCopy.getJobType();
// // // //         email = internshipApplicationToCopy.getEmail();
// // // //         description = internshipApplicationToCopy.getDescription();
// // // //         industries = new HashSet<>(internshipApplicationToCopy.getIndustry());
// // // //     }

// // // //     /**
// // // //      * Sets the {@code Name} of the {@code Person} that we are building.
// // // //      */
// // // //     public PersonBuilder withName(String name) {
// // // //         this.companyName = new CompanyName(name);
// // // //         return this;
// // // //     }

// // // //     /**
// // // //      * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
// // // //      */
// // // //     public PersonBuilder withTags(String ... tags) {
// // // //         this.industries = SampleDataUtil.getTagSet(tags);
// // // //         return this;
// // // //     }

// // // //     /**
// // // //      * Sets the {@code Address} of the {@code Person} that we are building.
// // // //      */
// // // //     public PersonBuilder withAddress(String address) {
// // // //         this.description = new Description(address);
// // // //         return this;
// // // //     }

// // // //     /**
// // // //      * Sets the {@code Phone} of the {@code Person} that we are building.
// // // //      */
// // // //     public PersonBuilder withPhone(String phone) {
// // // //         this.jobType = new JobType(phone);
// // // //         return this;
// // // //     }

// // // //     /**
// // // //      * Sets the {@code Email} of the {@code Person} that we are building.
// // // //      */
// // // //     public PersonBuilder withEmail(String email) {
// // // //         this.email = new Email(email);
// // // //         return this;
// // // //     }

// // // //     public InternshipApplication build() {
// // // //         return new InternshipApplication(companyName, jobType, email, description, industries);
// // // //     }

// // // // }

// // // package seedu.address.testutil;

// // // import java.util.HashSet;
// // // import java.util.Set;

// // // import seedu.address.model.Company.CompanyName;
// // // import seedu.address.model.Company.Description;
// // // import seedu.address.model.Company.Email;
// // // import seedu.address.model.Company.InternshipApplication;
// // // import seedu.address.model.Company.JobType;
// // // import seedu.address.model.Industry.Industry;
// // // import seedu.address.model.util.SampleDataUtil;

// // // /**
// // //  * A utility class to help with building InternshipApplication objects.
// // //  * Note: Renamed from PersonBuilder for clarity.
// // //  */
// // // public class PersonBuilder {

// // //     public static final String DEFAULT_NAME = "Amy Bee";
// // //     public static final String DEFAULT_PHONE = "85355255";
// // //     public static final String DEFAULT_EMAIL = "amy@gmail.com";
// // //     public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

// // //     private CompanyName companyName;
// // //     private JobType jobType;
// // //     private Email email;
// // //     private Description description;
// // //     private Set<Industry> industries;

// // //     /**
// // //      * Creates a {@code PersonBuilder} with the default details.
// // //      */
// // //     public PersonBuilder() {
// // //         companyName = new CompanyName(DEFAULT_NAME);
// // //         jobType = new JobType(DEFAULT_PHONE);
// // //         email = new Email(DEFAULT_EMAIL);
// // //         description = new Description(DEFAULT_ADDRESS);
// // //         industries = new HashSet<>();
// // //     }

// // //     /**
// // //      * Initializes the PersonBuilder with the data of {@code internshipApplicationToCopy}.
// // //      */
// // //     public PersonBuilder(InternshipApplication internshipApplicationToCopy) {
// // //         companyName = internshipApplicationToCopy.getName();
// // //         jobType = internshipApplicationToCopy.getJobType();
// // //         email = internshipApplicationToCopy.getEmail();
// // //         description = internshipApplicationToCopy.getDescription();
// // //         industries = new HashSet<>(internshipApplicationToCopy.getIndustry());
// // //     }

// // //     /**
// // //      * Sets the {@code CompanyName} of the {@code InternshipApplication} that we are building.
// // //      */
// // //     public PersonBuilder withName(String name) {
// // //         this.companyName = new CompanyName(name);
// // //         return this;
// // //     }

// // //     /**
// // //      * Parses the {@code industries} into a {@code Set<Industry>} and set it to the {@code InternshipApplication}
// // //      * that we are building.
// // //      */
// // //     public PersonBuilder withIndustries(String... industries) {
// // //         // Assumes SampleDataUtil.getTagSet is renamed or correctly returns Set<Industry>
// // //         this.industries = SampleDataUtil.getTagSet(industries);
// // //         return this;
// // //     }

// // //     /**
// // //      * Sets the {@code Description} of the {@code InternshipApplication} that we are building.
// // //      */
// // //     public PersonBuilder withAddress(String address) {
// // //         this.description = new Description(address);
// // //         return this;
// // //     }

// // //     /**
// // //      * Sets the {@code JobType} of the {@code InternshipApplication} that we are building.
// // //      */
// // //     public PersonBuilder withPhone(String phone) {
// // //         this.jobType = new JobType(phone);
// // //         return this;
// // //     }

// // //     /**
// // //      * Sets the {@code Email} of the {@code InternshipApplication} that we are building.
// // //      */
// // //     public PersonBuilder withEmail(String email) {
// // //         this.email = new Email(email);
// // //         return this;
// // //     }

// // //     public InternshipApplication build() {
// // //         // This assumes InternshipApplication constructor does not handle Status yet.
// // //         // If it does, you'll need to add a withStatus() method and pass it here.
// // //         return new InternshipApplication(companyName, jobType, email, description, industries);
// // //     }
// // // }

// // package seedu.address.testutil;

// // import seedu.address.model.Company.*;
// // import seedu.address.model.Industry.Industry;

// // /**
// //  * A utility class to help with building InternshipApplication objects.
// //  */
// // public class PersonBuilder {

// //     public static final String DEFAULT_NAME = "Amy Bee";
// //     public static final String DEFAULT_PHONE = "85355255";
// //     public static final String DEFAULT_EMAIL = "amy@gmail.com";
// //     public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
// //     public static final String DEFAULT_INDUSTRY = "tech";
// //     public static final String DEFAULT_STATUS = "Pending";

// //     private CompanyName companyName;
// //     private JobType jobType;
// //     private Email email;
// //     private Description description;
// //     // Changed from a Set to a single Industry
// //     private Industry industry;
// //     // Added ApplicationStatus to match the constructor
// //     private ApplicationStatus status;


// //     /**
// //      * Creates a {@code PersonBuilder} with the default details.
// //      */
// //     public PersonBuilder() {
// //         companyName = new CompanyName(DEFAULT_NAME);
// //         jobType = new JobType(DEFAULT_PHONE);
// //         email = new Email(DEFAULT_EMAIL);
// //         description = new Description(DEFAULT_ADDRESS);
// //         industry = new Industry(DEFAULT_INDUSTRY);
// //         status = new ApplicationStatus(DEFAULT_STATUS);
// //     }

// //     /**
// //      * Initializes the PersonBuilder with the data of {@code internshipApplicationToCopy}.
// //      */
// //     public PersonBuilder(InternshipApplication internshipApplicationToCopy) {
// //         companyName = internshipApplicationToCopy.getName();
// //         jobType = internshipApplicationToCopy.getJobType();
// //         email = internshipApplicationToCopy.getEmail();
// //         description = internshipApplicationToCopy.getDescription();
// //         industry = internshipApplicationToCopy.getIndustry();
// //         status = internshipApplicationToCopy.getStatus();
// //     }

// //     /**
// //      * Sets the {@code CompanyName} of the {@code InternshipApplication} that we are building.
// //      */
// //     public PersonBuilder withName(String name) {
// //         this.companyName = new CompanyName(name);
// //         return this;
// //     }

// //     /**
// //      * Sets the {@code Industry} of the {@code InternshipApplication} that we are building.
// //      */
// //     public PersonBuilder withIndustry(String industry) {
// //         this.industry = new Industry(industry);
// //         return this;
// //     }

// //     /**
// //      * Sets the {@code Description} of the {@code InternshipApplication} that we are building.
// //      */
// //     public PersonBuilder withAddress(String address) {
// //         this.description = new Description(address);
// //         return this;
// //     }

// //     /**
// //      * Sets the {@code JobType} of the {@code InternshipApplication} that we are building.
// //      */
// //     public PersonBuilder withPhone(String phone) {
// //         this.jobType = new JobType(phone);
// //         return this;
// //     }

// //     /**
// //      * Sets the {@code Email} of the {@code InternshipApplication} that we are building.
// //      */
// //     public PersonBuilder withEmail(String email) {
// //         this.email = new Email(email);
// //         return this;
// //     }
    
// //     /**
// //      * Sets the {@code ApplicationStatus} of the {@code InternshipApplication} that we are building.
// //      */
// //     public PersonBuilder withStatus(String status) {
// //         this.status = new ApplicationStatus(status);
// //         return this;
// //     }

// //     /**
// //      * Builds the InternshipApplication.
// //      */
// //     public InternshipApplication build() {
// //         // Updated to match the constructor: CompanyName, Industry, JobType, Description, ApplicationStatus, Email
// //         return new InternshipApplication(companyName, industry, jobType, description, status, email);
// //     }
// // }   

// package seedu.address.testutil;

// // Add this import statement
// import seedu.address.model.ApplicationStatus.ApplicationStatus;
// import seedu.address.model.Company.CompanyName;
// import seedu.address.model.Company.Description;
// import seedu.address.model.Company.Email;
// import seedu.address.model.Company.InternshipApplication;
// import seedu.address.model.Company.JobType;
// import seedu.address.model.Industry.Industry;

// /**
//  * A utility class to help with building InternshipApplication objects.
//  */
// public class PersonBuilder {

//     public static final String DEFAULT_NAME = "Amy Bee";
//     public static final String DEFAULT_PHONE = "85355255";
//     public static final String DEFAULT_EMAIL = "amy@gmail.com";
//     public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
//     public static final String DEFAULT_INDUSTRY = "tech";
//     public static final String DEFAULT_STATUS = "Pending";

//     private CompanyName companyName;
//     private JobType jobType;
//     private Email email;
//     private Description description;
//     private Industry industry;
//     private ApplicationStatus status;

//     /**
//      * Creates a {@code PersonBuilder} with the default details.
//      */
//     public PersonBuilder() {
//         companyName = new CompanyName(DEFAULT_NAME);
//         jobType = new JobType(DEFAULT_PHONE);
//         email = new Email(DEFAULT_EMAIL);
//         description = new Description(DEFAULT_ADDRESS);
//         industry = new Industry(DEFAULT_INDUSTRY);
//         status = new ApplicationStatus(DEFAULT_STATUS);
//     }

//     /**
//      * Initializes the PersonBuilder with the data of {@code internshipApplicationToCopy}.
//      */
//     public PersonBuilder(InternshipApplication internshipApplicationToCopy) {
//         companyName = internshipApplicationToCopy.getName();
//         jobType = internshipApplicationToCopy.getJobType();
//         email = internshipApplicationToCopy.getEmail();
//         description = internshipApplicationToCopy.getDescription();
//         industry = internshipApplicationToCopy.getIndustry();
//         status = internshipApplicationToCopy.getStatus();
//     }

//     /**
//      * Sets the {@code CompanyName} of the {@code InternshipApplication} that we are building.
//      */
//     public PersonBuilder withName(String name) {
//         this.companyName = new CompanyName(name);
//         return this;
//     }

//     /**
//      * Sets the {@code Industry} of the {@code InternshipApplication} that we are building.
//      */
//     public PersonBuilder withIndustry(String industry) {
//         this.industry = new Industry(industry);
//         return this;
//     }

//     /**
//      * Sets the {@code Description} of the {@code InternshipApplication} that we are building.
//      */
//     public PersonBuilder withAddress(String address) {
//         this.description = new Description(address);
//         return this;
//     }

//     /**
//      * Sets the {@code JobType} of the {@code InternshipApplication} that we are building.
//      */
//     public PersonBuilder withPhone(String phone) {
//         this.jobType = new JobType(phone);
//         return this;
//     }

//     /**
//      * Sets the {@code Email} of the {@code InternshipApplication} that we are building.
//      */
//     public PersonBuilder withEmail(String email) {
//         this.email = new Email(email);
//         return this;
//     }
    
//     /**
//      * Sets the {@code ApplicationStatus} of the {@code InternshipApplication} that we are building.
//      */
//     public PersonBuilder withStatus(String status) {
//         this.status = new ApplicationStatus(status);
//         return this;
//     }

//     /**
//      * Builds the InternshipApplication.
//      */
//     public InternshipApplication build() {
//         // Updated to match the constructor: CompanyName, Industry, JobType, Description, ApplicationStatus, Email
//         return new InternshipApplication(companyName, industry, jobType, description, status, email);
//     }
// }

package seedu.address.testutil;

import seedu.address.model.ApplicationStatus.ApplicationStatus;
import seedu.address.model.Company.CompanyName;
import seedu.address.model.Company.Description;
import seedu.address.model.Company.Email;
import seedu.address.model.Company.InternshipApplication;
import seedu.address.model.Company.JobType;
import seedu.address.model.Industry.Industry;

/**
 * A utility class to help with building InternshipApplication objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_JOB_TYPE = "Software Engineer";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_DESCRIPTION = "Backend microservices";
    public static final String DEFAULT_INDUSTRY = "Technology";
    public static final String DEFAULT_STATUS = "Saved";

    private CompanyName companyName;
    private JobType jobType;
    private Email email;
    private Description description;
    private Industry industry;
    private ApplicationStatus status;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        companyName = new CompanyName(DEFAULT_NAME);
        jobType = new JobType(DEFAULT_JOB_TYPE);
        email = new Email(DEFAULT_EMAIL);
        description = new Description(DEFAULT_DESCRIPTION);
        industry = new Industry(DEFAULT_INDUSTRY);
        status = new ApplicationStatus(DEFAULT_STATUS);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code applicationToCopy}.
     */
    public PersonBuilder(InternshipApplication applicationToCopy) {
        companyName = applicationToCopy.getName();
        jobType = applicationToCopy.getJobType();
        email = applicationToCopy.getEmail();
        description = applicationToCopy.getDescription();
        industry = applicationToCopy.getIndustry();
        status = applicationToCopy.getStatus();
    }

    /**
     * Sets the {@code CompanyName} of the {@code InternshipApplication} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.companyName = new CompanyName(name);
        return this;
    }

    /**
     * Sets the {@code JobType} of the {@code InternshipApplication} that we are building.
     */
    public PersonBuilder withJobType(String jobType) {
        this.jobType = new JobType(jobType);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code InternshipApplication} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Description} of the {@code InternshipApplication} that we are building.
     */
    public PersonBuilder withDescription(String description) {
        this.description = new Description(description);
        return this;
    }

    /**
     * Sets the {@code Industry} of the {@code InternshipApplication} that we are building.
     */
    public PersonBuilder withIndustry(String industry) {
        this.industry = new Industry(industry);
        return this;
    }

    /**
     * Sets the {@code ApplicationStatus} of the {@code InternshipApplication} that we are building.
     */
    public PersonBuilder withStatus(String status) {
        this.status = new ApplicationStatus(status);
        return this;
    }

    public InternshipApplication build() {
        return new InternshipApplication(companyName, industry, jobType, description, status, email);
    }
}