package seedu.address.model.company;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests boundary values for various fields.
 * Important for ensuring validation works at edge cases.
 */
public class BoundaryValueTests {

    @Test
    public void description_exactlyAtMaxLength_valid() {
        // Description max length is 200 characters
        String exactlyMaxLength = "a".repeat(200);
        assertTrue(Description.isValidDescription(exactlyMaxLength));

        // Should successfully create Description
        Description description = new Description(exactlyMaxLength);
        assertTrue(description.value.length() == 200);
    }

    @Test
    public void description_oneCharacterOverMaxLength_invalid() {
        // 201 characters - exceeds max
        String overMaxLength = "a".repeat(201);
        assertFalse(Description.isValidDescription(overMaxLength));

        // Should throw exception
        assertThrows(IllegalArgumentException.class, () -> new Description(overMaxLength));
    }

    @Test
    public void description_oneCharacterUnderMaxLength_valid() {
        // 199 characters - under max
        String underMaxLength = "a".repeat(199);
        assertTrue(Description.isValidDescription(underMaxLength));

        Description description = new Description(underMaxLength);
        assertTrue(description.value.length() == 199);
    }

    @Test
    public void description_emptyString_valid() {
        // Empty descriptions are allowed
        assertTrue(Description.isValidDescription(""));

        Description description = new Description("");
        assertTrue(description.value.isEmpty());
    }

    @Test
    public void description_singleCharacter_valid() {
        // Minimum non-empty length
        assertTrue(Description.isValidDescription("a"));

        Description description = new Description("a");
        assertTrue(description.value.equals("a"));
    }

    @Test
    public void companyName_emptyString_invalid() {
        // Company name cannot be empty
        assertFalse(CompanyName.isValidName(""));
        assertThrows(IllegalArgumentException.class, () -> new CompanyName(""));
    }

    @Test
    public void companyName_singleCharacter_valid() {
        // Single character is valid
        assertTrue(CompanyName.isValidName("A"));

        CompanyName name = new CompanyName("A");
        assertTrue(name.value.equals("A"));
    }

    @Test
    public void companyName_specialCharactersAtStart_invalid() {
        // Cannot start with special character
        assertFalse(CompanyName.isValidName("@Google"));
        assertThrows(IllegalArgumentException.class, () -> new CompanyName("@Google"));
    }

    @Test
    public void jobType_emptyString_invalid() {
        assertFalse(JobType.isValidJobType(""));
        assertThrows(IllegalArgumentException.class, () -> new JobType(""));
    }

    @Test
    public void jobType_singleCharacter_valid() {
        assertTrue(JobType.isValidJobType("A"));

        JobType jobType = new JobType("A");
        assertTrue(jobType.value.equals("A"));
    }

    @Test
    public void jobType_maxLength_valid() {
        // JobType has max length of 50
        String maxLength = "a".repeat(50);
        assertTrue(JobType.isValidJobType(maxLength));

        JobType jobType = new JobType(maxLength);
        assertTrue(jobType.value.length() == 50);
    }

    @Test
    public void email_minimumValid_accepted() {
        // Minimum valid email: a@bc (4 characters)
        assertTrue(Email.isValidEmail("a@bc"));

        Email email = new Email("a@bc");
        assertTrue(email.value.equals("a@bc"));
    }

    @Test
    public void email_veryLongLocalPart_valid() {
        // Long local part should be valid
        String longLocal = "a".repeat(50);
        String longEmail = longLocal + "@example.com";
        assertTrue(Email.isValidEmail(longEmail));

        Email email = new Email(longEmail);
        assertTrue(email.value.equals(longEmail));
    }

    @Test
    public void email_domainWithMinimumTwoChars_valid() {
        // Domain must end with at least 2 characters
        assertTrue(Email.isValidEmail("test@example.co"));
    }

    @Test
    public void email_domainWithOneChar_invalid() {
        // Domain ending with 1 character is invalid
        assertFalse(Email.isValidEmail("test@example.c"));
    }
}
