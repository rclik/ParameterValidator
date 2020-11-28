package parameter;

import parameter.validator.MaxLengthValidator;
import parameter.validator.ParameterValidator;

import java.util.HashMap;
import java.util.Map;

public class EmailParameterWrapper extends RequiredParameterWrapper {
    private static final Map<ParameterValidator, String> validatorMap = new HashMap<>();

    static {
        validatorMap.put(new MaxLengthValidator(10), "Email should have at most 10 character long");
    }

    public EmailParameterWrapper(String parameterValue) {
        super(parameterValue, "Email is required parameter", validatorMap);
    }
}