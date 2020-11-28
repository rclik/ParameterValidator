package parameter.types;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumberParameterTest {
    private static int parameterValue;
    private static NumberParameter numberParameter;

    @BeforeClass
    public static void initializeContext() {
        parameterValue = 13;
        numberParameter = new NumberParameter(parameterValue);
    }

    @Test
    public final void getValue_createParameter_shouldReturnItself(){
        Assert.assertEquals(parameterValue, numberParameter.getValue().intValue());
    }

    @Test
    public final void getParameterSize_createParameter_shouldReturnItself(){
        Assert.assertEquals(parameterValue, numberParameter.getParameterSize());
    }

}