package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.io.ObjectInputFilter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.Company.*;
import seedu.address.model.Company.CompanyName;
import seedu.address.model.Industry.Industry;
import seedu.address.model.ApplicationStatus.ApplicationStatus;

/**
 * Edits the details of an existing person in the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the person identified "
            + "by the index number used in the displayed person list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_COMPANY_NAME + "NAME] "
            + "[" + PREFIX_JOB_TYPE + "JOBTYPE] "
            + "[" + PREFIX_EMAIL + "EMAIL] "
            + "[" + PREFIX_DESCRIPTION + "DESCRIPTION] "
            + "[" + PREFIX_INDUSTRY + "INDUSTRY]"
            + "[" + PREFIX_STATUS + "STATUS]"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_JOB_TYPE + "SWE INTERN "
            + PREFIX_EMAIL + "johndoe@example.com";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Person: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book.";

    private final Index index;
    private final EditPersonDescriptor editPersonDescriptor;

    /**
     * @param index of the person in the filtered person list to edit
     * @param editPersonDescriptor details to edit the person with
     */
    public EditCommand(Index index, EditPersonDescriptor editPersonDescriptor) {
        requireNonNull(index);
        requireNonNull(editPersonDescriptor);

        this.index = index;
        this.editPersonDescriptor = new EditPersonDescriptor(editPersonDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<InternshipApplication> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        InternshipApplication internshipApplicationToEdit = lastShownList.get(index.getZeroBased());
        InternshipApplication editedInternshipApplication = createEditedPerson(internshipApplicationToEdit, editPersonDescriptor);

        if (!internshipApplicationToEdit.isSameApplication(editedInternshipApplication) && model.hasPerson(editedInternshipApplication)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.setPerson(internshipApplicationToEdit, editedInternshipApplication);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, Messages.format(editedInternshipApplication)));
    }

    /**
     * Creates and returns a {@code Person} with the details of {@code personToEdit}
     * edited with {@code editPersonDescriptor}.
     */
    private static InternshipApplication createEditedPerson(InternshipApplication internshipApplicationToEdit, EditPersonDescriptor editPersonDescriptor) {
        assert internshipApplicationToEdit != null;

        CompanyName updatedCompanyName = editPersonDescriptor.getName().orElse(internshipApplicationToEdit.getName());
        JobType updatedJobType = editPersonDescriptor.getPhone().orElse(internshipApplicationToEdit.getJobType());
        Email updatedEmail = editPersonDescriptor.getEmail().orElse(internshipApplicationToEdit.getEmail());
        Description updatedDescription = editPersonDescriptor.getDescription().orElse(internshipApplicationToEdit.getDescription());
        Industry updatedIndustries = editPersonDescriptor.getIndustries().orElse(internshipApplicationToEdit.getIndustry());
        ApplicationStatus updatedStatus = editPersonDescriptor.getStatus().orElse(internshipApplicationToEdit.getStatus());

        return new InternshipApplication(updatedCompanyName, updatedIndustries, updatedJobType, updatedDescription, updatedStatus, updatedEmail);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditCommand)) {
            return false;
        }

        EditCommand otherEditCommand = (EditCommand) other;
        return index.equals(otherEditCommand.index)
                && editPersonDescriptor.equals(otherEditCommand.editPersonDescriptor);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("index", index)
                .add("editPersonDescriptor", editPersonDescriptor)
                .toString();
    }

    /**
     * Stores the details to edit the person with. Each non-empty field value will replace the
     * corresponding field value of the person.
     */
    public static class EditPersonDescriptor {
        private CompanyName companyName;
        private JobType jobType;
        private Email email;
        private Description description;
        private Industry industries;

        private ApplicationStatus status;


        public EditPersonDescriptor() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public EditPersonDescriptor(EditPersonDescriptor toCopy) {
            setName(toCopy.companyName);
            setPhone(toCopy.jobType);
            setEmail(toCopy.email);
            setDescription(toCopy.description);
            setIndustry(toCopy.industries);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(companyName, jobType, email, description, industries);
        }

        public void setName(CompanyName companyName) {
            this.companyName = companyName;
        }

        public Optional<CompanyName> getName() {
            return Optional.ofNullable(companyName);
        }

        public void setPhone(JobType jobType) {
            this.jobType = jobType;
        }

        public Optional<JobType> getPhone() {
            return Optional.ofNullable(jobType);
        }

        public void setEmail(Email email) {
            this.email = email;
        }

        public Optional<Email> getEmail() {
            return Optional.ofNullable(email);
        }

        public void setDescription(Description description) {
            this.description = description;
        }

        public Optional<Description> getDescription() {
            return Optional.ofNullable(description);
        }

        /**
         * Sets {@code tags} to this object's {@code tags}.
         * A defensive copy of {@code tags} is used internally.
         */
        public void setIndustry(Industry industries) {
            this.industries = industries;
        }

        /**
         * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code tags} is null.
         */
        public Optional<Industry> getIndustries() {
            return Optional.ofNullable(industries);
        }

        public void setStatus(ApplicationStatus status) {
            this.status = status;
        }

        public Optional<ApplicationStatus> getStatus() { return Optional.ofNullable(status);}

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditPersonDescriptor)) {
                return false;
            }

            EditPersonDescriptor otherEditPersonDescriptor = (EditPersonDescriptor) other;
            return Objects.equals(companyName, otherEditPersonDescriptor.companyName)
                    && Objects.equals(jobType, otherEditPersonDescriptor.jobType)
                    && Objects.equals(email, otherEditPersonDescriptor.email)
                    && Objects.equals(description, otherEditPersonDescriptor.description)
                    && Objects.equals(industries, otherEditPersonDescriptor.industries);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .add("company name", companyName)
                    .add("job type", jobType)
                    .add("email", email)
                    .add("description", description)
                    .add("industry", industries)
                    .add("status", status)
                    .toString();
        }
    }
}
