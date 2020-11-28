package parameter.validator;

public class MaxLengthValidator implements ParameterValidator {
    private final int maxLength;

    public MaxLengthValidator(final int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public boolean validate(String parameterValue) {
        return maxLength > parameterValue.length();
    }
}
