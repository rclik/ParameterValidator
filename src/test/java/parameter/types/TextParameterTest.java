package parameter.types;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TextParameterTest {

    private static String parameterValue;
    private static TextParameter textParameter;

    @BeforeClass
    public static void initializeContext() {
        parameterValue = "parameter value";
        textParameter = new TextParameter(parameterValue);
    }

    @Test
    public final void getValue_setTextParameterValue_shouldReturnItself() {
        Assert.assertEquals(parameterValue, textParameter.getValue());
    }

    @Test
    public final void getStringValue_setTextParameterValue_shouldReturnItself() {
        Assert.assertEquals(parameterValue, textParameter.getStringValue());
    }

    @Test
    public final void getParameterSize_setTextParameterValue_shouldReturnParameterLength() {
        Assert.assertEquals(parameterValue.length(), textParameter.getParameterSize());
    }
}