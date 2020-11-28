package parameter;


import org.junit.Assert;
import org.junit.Test;

public class NameParameterWrapperTest {

    @Test
    public final void validateAndGet_withNullValue_shouldReturnNull() {
        try {
            String result = new NameParameterWrapper(null).validateAndGetParameter();
            Assert.assertNull(result);
        } catch (Exception e) {
            Assert.fail("This method should not throw exception");
        }
    }

    @Test
    public final void validateAndGet_withEmptyValue_shouldReturnEmptyString() {
        try {
            String result = new NameParameterWrapper("").validateAndGetParameter();
            Assert.assertEquals("", result);
        } catch (Exception e) {
            Assert.fail("This method should not throw exception");
        }
    }

    @Test
    public final void validateAndGet_withMultipleWhiteSpaceChar_shouldReturnEmptyString () {
        try {
            String result = new NameParameterWrapper("   ").validateAndGetParameter();
            Assert.assertEquals("", result);
        } catch (Exception e) {
            Assert.fail("This method should not throw exception");
        }
    }

    @Test
    public final void validateAndGet_endingOneWhiteSpaceChar_shouldRemoveLastChar () {
        try {
            String result = new NameParameterWrapper("name ").validateAndGetParameter();
            Assert.assertEquals("name", result);
        } catch (Exception e) {
            Assert.fail("This method should not throw exception");
        }
    }

    @Test
    public final void validateAndGet_endingTwoWhiteSpaceChar_shouldRemoveLastTwoChar () {
        try {
            String result = new NameParameterWrapper("name  ").validateAndGetParameter();
            Assert.assertEquals("name", result);
        } catch (Exception e) {
            Assert.fail("This method should not throw exception");
        }
    }

    @Test
    public final void validateAndGet_startingOneWhiteSpaceChar_shouldRemoveFirstChar () {
        try {
            String result = new NameParameterWrapper(" name").validateAndGetParameter();
            Assert.assertEquals("name", result);
        } catch (Exception e) {
            Assert.fail("This method should not throw exception");
        }
    }

    @Test
    public final void validateAndGet_startingTwoWhiteSpaceChar_shouldRemoveFirstTwoChar () {
        try {
            String result = new NameParameterWrapper("  name").validateAndGetParameter();
            Assert.assertEquals("name", result);
        } catch (Exception e) {
            Assert.fail("This method should not throw exception");
        }
    }

    @Test
    public final void validateAndGet_havingOneWhiteSpaceCharMiddle_shouldReturnSame () {
        try {
            String result = new NameParameterWrapper("your name").validateAndGetParameter();
            Assert.assertEquals("your name", result);
        } catch (Exception e) {
            Assert.fail("This method should not throw exception");
        }
    }

    @Test
    public final void validateAndGet_havingTwoWhiteSpaceCharMiddle_shouldReturnSame () {
        try {
            String result = new NameParameterWrapper("your  name").validateAndGetParameter();
            Assert.assertEquals("your  name", result);
        } catch (Exception e) {
            Assert.fail("This method should not throw exception");
        }
    }

    @Test
    public final void validateAndGet_havingNumberChar_shouldReturnSame () {
        try {
            String result = new NameParameterWrapper("your name is 11").validateAndGetParameter();
            Assert.assertEquals("your name is 11", result);
        } catch (Exception e) {
            Assert.fail("This method should not throw exception");
        }
    }

    @Test
    public final void validateAndGet_havingCapitalChar_shouldReturnSame () {
        try {
            String result = new NameParameterWrapper("Your Name is 11").validateAndGetParameter();
            Assert.assertEquals("Your Name is 11", result);
        } catch (Exception e) {
            Assert.fail("This method should not throw exception");
        }
    }

    @Test
    public final void validateAndGet_havingSpecialChar_shouldReturnSame () {
        try {
            String result = new NameParameterWrapper("Your Name is #11").validateAndGetParameter();
            Assert.assertEquals("Your Name is #11", result);
        } catch (Exception e) {
            Assert.fail("This method should not throw exception");
        }
    }

    @Test
    public final void validateAndGet_havingMoreThanSixteenChar_shouldThrowException () {
        try {
            new NameParameterWrapper("Your Name is #11.").validateAndGetParameter();
        } catch (Exception e) {
            Assert.assertEquals("Name should have only characters and 15 character long", e.getMessage());
            return;
        }

        Assert.fail("This message should throw exception");
    }
}