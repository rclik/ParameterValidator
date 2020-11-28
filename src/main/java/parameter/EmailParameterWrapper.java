package parameter;

import parameter.validator.MaxLengthValidator;
import parameter.validator.ParameterValidator;
import parameter.validator.RegexValidator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class EmailParameterWrapper extends RequiredParameterWrapper {
    private static final Map<ParameterValidator, String> validatorMap = new LinkedHashMap<>();

    static {
        validatorMap.put(new MaxLengthValidator(15), "Email should have at most 10 character long");
        validatorMap.put(new RegexValidator(
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)
        ), "Please provide a valid email address");
    }

    public EmailParameterWrapper(String parameterValue) {
        super(parameterValue, "Email is required parameter", validatorMap);
    }
}