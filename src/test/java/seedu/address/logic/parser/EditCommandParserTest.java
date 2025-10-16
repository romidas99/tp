package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.DESCRIPTION_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.DESCRIPTION_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_DESCRIPTION_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_EMAIL_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_JOB_TYPE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_INDUSTRY_DESC;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.JOB_TYPE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.JOB_TYPE_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.INDUSTRY_DESC_TECH;
import static seedu.address.logic.commands.CommandTestUtil.INDUSTRY_DESC_FINANCE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_JOB_TYPE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_JOB_TYPE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INDUSTRY_TECH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INDUSTRY_FINANCE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOB_TYPE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INDUSTRY;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_THIRD_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.Company.Description;
import seedu.address.model.Company.CompanyName;
import seedu.address.model.Company.Email;
import seedu.address.model.Company.JobType;
import seedu.address.model.Industry.Industry;
import seedu.address.testutil.EditPersonDescriptorBuilder;

/**
 * Contains unit tests for EditCommandParser in the context of an internship tracker application.
 * Tests parsing of edit commands for modifying existing internship applications.
 */
public class EditCommandParserTest {

    private static final String TAG_EMPTY = " " + PREFIX_INDUSTRY;

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE);

    private EditCommandParser parser = new EditCommandParser();

    @Test
    public void parse_missingParts_failure() {
        // no index specified
        assertParseFailure(parser, VALID_NAME_AMY, MESSAGE_INVALID_FORMAT);

        // no field specified
        assertParseFailure(parser, "1", EditCommand.MESSAGE_NOT_EDITED);

        // no index and no field specified
        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidPreamble_failure() {
        // negative index
        assertParseFailure(parser, "-5" + NAME_DESC_AMY, MESSAGE_INVALID_FORMAT);

        // zero index
        assertParseFailure(parser, "0" + NAME_DESC_AMY, MESSAGE_INVALID_FORMAT);

        // invalid arguments being parsed as preamble
        assertParseFailure(parser, "1 some random string", MESSAGE_INVALID_FORMAT);

        // invalid prefix being parsed as preamble
        assertParseFailure(parser, "1 i/ string", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, "1" + INVALID_NAME_DESC, CompanyName.MESSAGE_CONSTRAINTS); // invalid company name
        assertParseFailure(parser, "1" + INVALID_JOB_TYPE_DESC, JobType.MESSAGE_CONSTRAINTS); // invalid job type
        assertParseFailure(parser, "1" + INVALID_EMAIL_DESC, Email.MESSAGE_CONSTRAINTS); // invalid email
        assertParseFailure(parser, "1" + INVALID_DESCRIPTION_DESC, Description.MESSAGE_CONSTRAINTS); // invalid description
        assertParseFailure(parser, "1" + INVALID_INDUSTRY_DESC, Industry.MESSAGE_CONSTRAINTS); // invalid industry

        // invalid job type followed by valid email
        assertParseFailure(parser, "1" + INVALID_JOB_TYPE_DESC + EMAIL_DESC_AMY, JobType.MESSAGE_CONSTRAINTS);

        // while parsing {@code PREFIX_INDUSTRY} alone will reset the industry of the {@code InternshipApplication} being edited,
        // parsing it together with a valid industry results in error
        assertParseFailure(parser, "1" + INDUSTRY_DESC_TECH + INDUSTRY_DESC_FINANCE + TAG_EMPTY, Industry.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, "1" + INDUSTRY_DESC_TECH + TAG_EMPTY + INDUSTRY_DESC_FINANCE, Industry.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, "1" + TAG_EMPTY + INDUSTRY_DESC_TECH + INDUSTRY_DESC_FINANCE, Industry.MESSAGE_CONSTRAINTS);

        // multiple invalid values, but only the first invalid value is captured
        assertParseFailure(parser, "1" + INVALID_NAME_DESC + INVALID_EMAIL_DESC + VALID_DESCRIPTION_AMY + VALID_JOB_TYPE_AMY,
                CompanyName.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_allFieldsSpecified_success() {
        Index targetIndex = INDEX_SECOND_PERSON;
        String userInput = targetIndex.getOneBased() + JOB_TYPE_DESC_BOB + INDUSTRY_DESC_FINANCE
                + EMAIL_DESC_AMY + DESCRIPTION_DESC_AMY + NAME_DESC_AMY + INDUSTRY_DESC_TECH;

        // When multiple industries are specified, only the last one is used since Industry is a single field
        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY)
                .withJobType(VALID_JOB_TYPE_BOB).withEmail(VALID_EMAIL_AMY).withDescription(VALID_DESCRIPTION_AMY)
                .withIndustry(VALID_INDUSTRY_TECH).build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_someFieldsSpecified_success() {
        Index targetIndex = INDEX_FIRST_PERSON;
        String userInput = targetIndex.getOneBased() + JOB_TYPE_DESC_BOB + EMAIL_DESC_AMY;

        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withJobType(VALID_JOB_TYPE_BOB)
                .withEmail(VALID_EMAIL_AMY).build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_oneFieldSpecified_success() {
        // company name
        Index targetIndex = INDEX_THIRD_PERSON;
        String userInput = targetIndex.getOneBased() + NAME_DESC_AMY;
        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY).build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // job type
        userInput = targetIndex.getOneBased() + JOB_TYPE_DESC_AMY;
        descriptor = new EditPersonDescriptorBuilder().withJobType(VALID_JOB_TYPE_AMY).build();
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // email
        userInput = targetIndex.getOneBased() + EMAIL_DESC_AMY;
        descriptor = new EditPersonDescriptorBuilder().withEmail(VALID_EMAIL_AMY).build();
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // description
        userInput = targetIndex.getOneBased() + DESCRIPTION_DESC_AMY;
        descriptor = new EditPersonDescriptorBuilder().withDescription(VALID_DESCRIPTION_AMY).build();
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // industry
        userInput = targetIndex.getOneBased() + INDUSTRY_DESC_TECH;
        descriptor = new EditPersonDescriptorBuilder().withIndustry(VALID_INDUSTRY_TECH).build();
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_multipleRepeatedFields_failure() {
        // More extensive testing of duplicate parameter detections is done in
        // AddCommandParserTest#parse_repeatedNonTagValue_failure()

        // valid followed by invalid
        Index targetIndex = INDEX_FIRST_PERSON;
        String userInput = targetIndex.getOneBased() + INVALID_JOB_TYPE_DESC + JOB_TYPE_DESC_BOB;

        assertParseFailure(parser, userInput, Messages.getErrorMessageForDuplicatePrefixes(PREFIX_JOB_TYPE));

        // invalid followed by valid
        userInput = targetIndex.getOneBased() + JOB_TYPE_DESC_BOB + INVALID_JOB_TYPE_DESC;

        assertParseFailure(parser, userInput, Messages.getErrorMessageForDuplicatePrefixes(PREFIX_JOB_TYPE));

        // mulltiple valid fields repeated
        userInput = targetIndex.getOneBased() + JOB_TYPE_DESC_AMY + DESCRIPTION_DESC_AMY + EMAIL_DESC_AMY
                + INDUSTRY_DESC_TECH + JOB_TYPE_DESC_AMY + DESCRIPTION_DESC_AMY + EMAIL_DESC_AMY + INDUSTRY_DESC_TECH
                + JOB_TYPE_DESC_BOB + DESCRIPTION_DESC_BOB + EMAIL_DESC_BOB + INDUSTRY_DESC_FINANCE;

        assertParseFailure(parser, userInput,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_JOB_TYPE, PREFIX_EMAIL, PREFIX_DESCRIPTION));

        // multiple invalid values
        userInput = targetIndex.getOneBased() + INVALID_JOB_TYPE_DESC + INVALID_DESCRIPTION_DESC + INVALID_EMAIL_DESC
                + INVALID_JOB_TYPE_DESC + INVALID_DESCRIPTION_DESC + INVALID_EMAIL_DESC;

        assertParseFailure(parser, userInput,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_JOB_TYPE, PREFIX_EMAIL, PREFIX_DESCRIPTION));
    }

    @Test
    public void parse_resetIndustry_success() {
        Index targetIndex = INDEX_THIRD_PERSON;
        String userInput = targetIndex.getOneBased() + TAG_EMPTY;

        // Empty industry value should be handled by parser, creating descriptor without industry
        EditPersonDescriptor descriptor = new EditPersonDescriptorBuilder().build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }
}
