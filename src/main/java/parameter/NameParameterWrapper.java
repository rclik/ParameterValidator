package parameter;

import parameter.validator.ParameterValidator;
import parameter.validator.RegexValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class NameParameterWrapper extends OptionalParameterWrapper {
    private static Map<ParameterValidator, String> validatorMap = new HashMap<>();

    static {
        validatorMap.put(new RegexValidator(Pattern.compile("^.{0,16}$")), "Name should have only characters and 15 character long");
    }

    public NameParameterWrapper(String parameterValue) {
        super(parameterValue, validatorMap);
    }
}
