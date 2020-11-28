package parameter;

import parameter.validator.ParameterValidator;

import java.util.Map;

abstract class ParameterWrapper {
    protected String parameterValue;
    private Map<ParameterValidator, String> validators;

    ParameterWrapper(String parameterValue, Map<ParameterValidator, String> validators) {
        this.parameterValue = parameterValue;
        this.validators = validators;
    }

    void applyValidators() {
        this.validators.forEach((validator, failMessage) -> {
            if (!validator.validate(parameterValue)) {
                throw new RuntimeException(failMessage);
            }
        });
    }

    abstract void validateParameter();
    abstract String getValidParameterValue();

    String validateAndGetParameter(){
        this.validateParameter();
        return this.getValidParameterValue();
    }
}
