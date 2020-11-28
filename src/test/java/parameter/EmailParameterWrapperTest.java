package parameter;


import org.junit.Assert;
import org.junit.Test;

public class EmailParameterWrapperTest {

    @Test
    public final void validateAndGet_withNullValue_shouldThrowException() {
        try {
            new EmailParameterWrapper(null).validateAndGetParameter();
        } catch (Exception e) {
            Assert.assertEquals("Email is required parameter", e.getMessage());
            return;
        }
        Assert.fail("This test should throw exception");
    }

    @Test
    public final void validateAndGet_withValueLongerThanExpected_shouldThrowException() {
        try {
            new EmailParameterWrapper("parameterlengthismorethanexpected").validateAndGetParameter();
        } catch (Exception e) {
            Assert.assertEquals("Email should have at most 10 character long", e.getMessage());
            return;
        }
        Assert.fail("This test should throw exception");
    }

    @Test
    public final void validateAndGet_withValueWithCorrectLengthButNotValidEmail_shouldThrowException() {
        try {
            new EmailParameterWrapper("rahman").validateAndGetParameter();
        } catch (Exception e) {
            Assert.assertEquals("Please provide a valid email address", e.getMessage());
            return;
        }
        Assert.fail("This test should throw exception");
    }

    @Test
    public final void validateAndGet_withValueWithCorrectAndValidEmail_shouldSuccess() {
        String result = new EmailParameterWrapper("rah@man.com").validateAndGetParameter();
        Assert.assertEquals("rah@man.com", result);
    }

    @Test
    public final void validateAndGet_withValueWithCorrectAndValidEmailWhiteSpaceBeginning_shouldThrowException() {
        try {
            String result = new EmailParameterWrapper(" rah@man.com").validateAndGetParameter();
            Assert.assertEquals("rah@man.com", result);

        } catch (Exception e) {
            Assert.assertEquals("Please provide a valid email address", e.getMessage());
            return;
        }
        Assert.fail("This method should throw an exception");
    }
}