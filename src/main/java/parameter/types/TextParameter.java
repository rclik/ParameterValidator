package parameter.types;

public class TextParameter extends ParameterValueWrapper<String> implements RegexApplicable, MaxValidatorApplicable {
    TextParameter(String value) {
        super(value);
    }

    @Override
    public String getStringValue() {
        return this.value;
    }

    @Override
    public int getParameterSize() {
        return this.value.length();
    }
}
