package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import seedu.address.logic.commands.AddCommand;
import static seedu.address.logic.commands.CommandTestUtil.DESCRIPTION_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.DESCRIPTION_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.INDUSTRY_DESC_FINANCE;
import static seedu.address.logic.commands.CommandTestUtil.INDUSTRY_DESC_TECH;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_DESCRIPTION_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_EMAIL_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_INDUSTRY_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_JOB_TYPE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.JOB_TYPE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.JOB_TYPE_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INDUSTRY_FINANCE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INDUSTRY_TECH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_JOB_TYPE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COMPANY_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOB_TYPE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import seedu.address.model.Company.CompanyName;
import seedu.address.model.Company.Description;
import seedu.address.model.Company.Email;
import seedu.address.model.Company.InternshipApplication;
import seedu.address.model.Company.JobType;
import seedu.address.model.Industry.Industry;
import seedu.address.testutil.PersonBuilder;
import static seedu.address.testutil.TypicalPersons.AMY;
import static seedu.address.testutil.TypicalPersons.BOB;

/**
 * Contains unit tests for AddCommandParser in the context of an internship tracker application.
 * Tests parsing of add commands for creating new internship applications.
 */

public class AddCommandParserTest {
    private AddCommandParser parser = new AddCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        InternshipApplication expectedInternshipApplication = new PersonBuilder(BOB).withTags(VALID_INDUSTRY_TECH).build();

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_BOB + JOB_TYPE_DESC_BOB + EMAIL_DESC_BOB
                + DESCRIPTION_DESC_BOB + INDUSTRY_DESC_TECH, new AddCommand(expectedInternshipApplication));


        // multiple industries - all accepted
        InternshipApplication expectedInternshipApplicationMultipleTags = new PersonBuilder(BOB).withTags(VALID_INDUSTRY_TECH, VALID_INDUSTRY_FINANCE)
                .build();
        assertParseSuccess(parser,
                NAME_DESC_BOB + JOB_TYPE_DESC_BOB + EMAIL_DESC_BOB + DESCRIPTION_DESC_BOB + INDUSTRY_DESC_FINANCE + INDUSTRY_DESC_TECH,
                new AddCommand(expectedInternshipApplicationMultipleTags));
    }

    @Test
    public void parse_repeatedNonTagValue_failure() {
        String validExpectedPersonString = NAME_DESC_BOB + JOB_TYPE_DESC_BOB + EMAIL_DESC_BOB
                + DESCRIPTION_DESC_BOB + INDUSTRY_DESC_TECH;

        // multiple company names
        assertParseFailure(parser, NAME_DESC_AMY + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_COMPANY_NAME));

        // multiple job types
        assertParseFailure(parser, JOB_TYPE_DESC_AMY + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_JOB_TYPE));

        // multiple emails
        assertParseFailure(parser, EMAIL_DESC_AMY + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_EMAIL));

        // multiple descriptions
        assertParseFailure(parser, DESCRIPTION_DESC_AMY + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_DESCRIPTION));

        // multiple fields repeated
        assertParseFailure(parser,
                validExpectedPersonString + JOB_TYPE_DESC_AMY + EMAIL_DESC_AMY + NAME_DESC_AMY + DESCRIPTION_DESC_AMY
                        + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_COMPANY_NAME, PREFIX_DESCRIPTION, PREFIX_EMAIL, PREFIX_JOB_TYPE));

        // invalid value followed by valid value

        // invalid company name
        assertParseFailure(parser, INVALID_NAME_DESC + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_COMPANY_NAME));

        // invalid email
        assertParseFailure(parser, INVALID_EMAIL_DESC + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_EMAIL));

        // invalid job type
        assertParseFailure(parser, INVALID_JOB_TYPE_DESC + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_JOB_TYPE));

        // invalid description
        assertParseFailure(parser, INVALID_DESCRIPTION_DESC + validExpectedPersonString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_DESCRIPTION));

        // valid value followed by invalid value

        // invalid company name
        assertParseFailure(parser, validExpectedPersonString + INVALID_NAME_DESC,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_COMPANY_NAME));

        // invalid email
        assertParseFailure(parser, validExpectedPersonString + INVALID_EMAIL_DESC,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_EMAIL));

        // invalid job type
        assertParseFailure(parser, validExpectedPersonString + INVALID_JOB_TYPE_DESC,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_JOB_TYPE));

        // invalid description
        assertParseFailure(parser, validExpectedPersonString + INVALID_DESCRIPTION_DESC,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_DESCRIPTION));
    }

    @Test
    public void parse_optionalFieldsMissing_success() {
        // zero industries
        InternshipApplication expectedInternshipApplication = new PersonBuilder(AMY).withTags().build();
        assertParseSuccess(parser, NAME_DESC_AMY + JOB_TYPE_DESC_AMY + EMAIL_DESC_AMY + DESCRIPTION_DESC_AMY,
                new AddCommand(expectedInternshipApplication));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE);

        // missing company name prefix
        assertParseFailure(parser, VALID_NAME_BOB + JOB_TYPE_DESC_BOB + EMAIL_DESC_BOB + DESCRIPTION_DESC_BOB,
                expectedMessage);

        // missing job type prefix
        assertParseFailure(parser, NAME_DESC_BOB + VALID_JOB_TYPE_BOB + EMAIL_DESC_BOB + DESCRIPTION_DESC_BOB,
                expectedMessage);

        // missing email prefix
        assertParseFailure(parser, NAME_DESC_BOB + JOB_TYPE_DESC_BOB + VALID_EMAIL_BOB + DESCRIPTION_DESC_BOB,
                expectedMessage);

        // missing description prefix
        assertParseFailure(parser, NAME_DESC_BOB + JOB_TYPE_DESC_BOB + EMAIL_DESC_BOB + VALID_DESCRIPTION_BOB,
                expectedMessage);

        // all prefixes missing
        assertParseFailure(parser, VALID_NAME_BOB + VALID_JOB_TYPE_BOB + VALID_EMAIL_BOB + VALID_DESCRIPTION_BOB,
                expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid company name
        assertParseFailure(parser, INVALID_NAME_DESC + JOB_TYPE_DESC_BOB + EMAIL_DESC_BOB + DESCRIPTION_DESC_BOB
                + INDUSTRY_DESC_FINANCE + INDUSTRY_DESC_TECH, CompanyName.MESSAGE_CONSTRAINTS);

        // invalid job type
        assertParseFailure(parser, NAME_DESC_BOB + INVALID_JOB_TYPE_DESC + EMAIL_DESC_BOB + DESCRIPTION_DESC_BOB
                + INDUSTRY_DESC_FINANCE + INDUSTRY_DESC_TECH, JobType.MESSAGE_CONSTRAINTS);

        // invalid email
        assertParseFailure(parser, NAME_DESC_BOB + JOB_TYPE_DESC_BOB + INVALID_EMAIL_DESC + DESCRIPTION_DESC_BOB
                + INDUSTRY_DESC_FINANCE + INDUSTRY_DESC_TECH, Email.MESSAGE_CONSTRAINTS);

        // invalid description
        assertParseFailure(parser, NAME_DESC_BOB + JOB_TYPE_DESC_BOB + EMAIL_DESC_BOB + INVALID_DESCRIPTION_DESC
                + INDUSTRY_DESC_FINANCE + INDUSTRY_DESC_TECH, Description.MESSAGE_CONSTRAINTS);

        // invalid industry
        assertParseFailure(parser, NAME_DESC_BOB + JOB_TYPE_DESC_BOB + EMAIL_DESC_BOB + DESCRIPTION_DESC_BOB
                + INVALID_INDUSTRY_DESC + VALID_INDUSTRY_TECH, Industry.MESSAGE_CONSTRAINTS);

        // two invalid values, only first invalid value reported
        assertParseFailure(parser, INVALID_NAME_DESC + JOB_TYPE_DESC_BOB + EMAIL_DESC_BOB + INVALID_DESCRIPTION_DESC,
                CompanyName.MESSAGE_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + NAME_DESC_BOB + JOB_TYPE_DESC_BOB + EMAIL_DESC_BOB
                + DESCRIPTION_DESC_BOB + INDUSTRY_DESC_FINANCE + INDUSTRY_DESC_TECH,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }
}
