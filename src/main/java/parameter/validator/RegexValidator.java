package parameter.validator;

import java.util.regex.Pattern;

public class RegexValidator implements ParameterValidator{
    private final Pattern pattern;

    public RegexValidator(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean validate(String parameterValue) {
        return this.pattern.matcher(parameterValue).matches();
    }
}
